package com.example.redisexample.service;

import com.example.redisexample.dto.Create;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional
public class BoardServiceFactory {

    private final BoardService boardService;

    public String process(Create create, List<MultipartFile> infoFile) {
        if (create.getCreateType().equals(Create.CreateType.INFO)) {
            return "INFO";
        } else if (create.getCreateType().equals(Create.CreateType.CONTENT)) {
            return "CONTENT";
        } else if (create.getCreateType().equals(Create.CreateType.COMMENT)) {
            return "COMMENT";
        }
        return "NULL";
    }
}
