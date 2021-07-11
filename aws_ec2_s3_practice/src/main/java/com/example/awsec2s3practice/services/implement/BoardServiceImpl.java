package com.example.awsec2s3practice.services.implement;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.example.awsec2s3practice.dtos.BoardDto;
import com.example.awsec2s3practice.dtos.BoardResponseDto;
import com.example.awsec2s3practice.entities.Board;
import com.example.awsec2s3practice.repositories.BoardRepository;
import com.example.awsec2s3practice.services.interfaces.BoardService;
import com.example.awsec2s3practice.services.interfaces.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

// TODO : Connection 에러 뜨는 거 해결하기
// No content length specified for stream data.
// Stream contents will be buffered in memory and could result in out of memory errors.
@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final S3Service s3Service;
    private final BoardRepository boardRepository;

    @Override
    public Long createBoard(BoardDto boardDto, List<MultipartFile> files) {

        if (validateFiles(files))
            return saveBoard(boardDto);

        List<String> fileNames = getFilenames(files);
        return saveBoard(boardDto, fileNames, s3Service.getFileURL(fileNames));
    }

    private boolean validateFiles(List<MultipartFile> files) {
        if (files.size() == 1) {
            MultipartFile file = files.get(0);
            String checkFilename = file.getOriginalFilename();

            return checkFilename.isBlank() || checkFilename.isEmpty();
        }
        return false;
    }

    private Long saveBoard(BoardDto boardDto) {

        Board board = Board.from(boardDto);
        Board savedBoard = boardRepository.save(board);
        return savedBoard.getId();
    }

    private List<String> getFilenames(List<MultipartFile> files) {

        List<String> fileNames = new ArrayList<>();
        for (MultipartFile file : files) {

            String filename = getFilename(file);
            fileNames.add(filename);
            uploadFile(file, filename);
        }

        return fileNames;
    }

    private void uploadFile(MultipartFile file, String fileName) {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(file.getContentType());

        try (InputStream inputStream = file.getInputStream()){
            s3Service.uploadFile(inputStream, objectMetadata, fileName);
        } catch(IOException e) {
            throw new IllegalArgumentException(String.format("파일 업로드 중 에러가 발생했습니다. (%s)", file.getOriginalFilename()));
        }
    }

    private Long saveBoard(BoardDto boardDto, List<String> fileNames, List<String> fileURLs) {

        String fileURL = insertSeparatorToFileURLs(fileURLs);
        String fileName = insertSeparatorToFileURLs(fileNames);

        Board board = Board.of(boardDto, fileName, fileURL);
        Board savedBoard = boardRepository.save(board);
        return savedBoard.getId();
    }

    private String insertSeparatorToFileURLs(List<String> files) {
        return String.join(",", files);
    }

    private String getFilename(MultipartFile file) {
        return UUID.randomUUID().toString()
                .concat(getFileExtension(file.getOriginalFilename()));
    }

    private String getFileExtension(String fileName) {
        try {
            return fileName.substring(fileName.lastIndexOf("."));
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(String.format("잘못된 형식의 파일 (%s) 입니다.", fileName));
        }
    }

    @Override
    public BoardResponseDto getBoard(Long id) {

        Board board = boardRepository.findById(id).orElseThrow();
        return map(board);
    }

    private BoardResponseDto map(Board board) {
        return BoardResponseDto.builder()
                .id(String.valueOf(board.getId()))
                .text(board.getText())
                .title(board.getTitle())
                .imageURL(board.getImageURL())
                .build();
    }

    @Override
    public void updateBoard(Long id) {

    }

    @Override
    public void deleteBoard(Long id) {

        Board board = boardRepository.findById(id).orElseThrow();
        List<String> fileNames = separateFilenames(board.getFileName());

        if (!validateFilenames(fileNames)) {
            s3Service.deleteFile(fileNames);
        }
        boardRepository.deleteById(id);
    }

    private boolean validateFilenames(List<String> fileNames) {
        if(fileNames.size() == 1) {

            String name = fileNames.get(0);
            return name == null || name.equals("");
        }
        return false;
    }

    private List<String> separateFilenames(String fileName) {
        return Arrays.asList(fileName.split(","));
    }
}
