package com.example.awsec2s3practice.services.implement;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.util.IOUtils;
import com.example.awsec2s3practice.dtos.BoardDto;
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
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final S3Service s3Service;
    private final BoardRepository boardRepository;

    @Override
    public Long createBoard(BoardDto boardDto, MultipartFile file) {

        String fileName = getFilename(file);
        uploadFile(file, getFilename(file));
        return saveBoard(boardDto, s3Service.getFileURL(fileName));
    }

    private void uploadFile(MultipartFile file, String fileName) {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(file.getContentType());

        // TODO : WARN 안뜨게 개선하기
        try (InputStream inputStream = file.getInputStream()){
            s3Service.uploadFile(inputStream, objectMetadata, fileName);
        } catch(IOException e) {
            throw new IllegalArgumentException(String.format("파일 업로드 중 에러가 발생했습니다. (%s)", file.getOriginalFilename()));
        }
    }

    private Long saveBoard(BoardDto boardDto, String fileURL) {

        Board board = Board.builder()
                .imageURL(fileURL)
                .title(boardDto.getTitle())
                .text(boardDto.getText())
                .build();

        Board savedBoard = boardRepository.save(board);

        return savedBoard.getId();
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
    public BoardDto getBoard(Long id) {
        return null;
    }

    @Override
    public Long updateBoard(Long id) {
        return null;
    }

    @Override
    public Long deleteBoard(Long id) {
        return null;
    }
}
