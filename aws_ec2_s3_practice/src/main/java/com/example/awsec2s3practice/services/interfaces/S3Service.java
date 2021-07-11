package com.example.awsec2s3practice.services.interfaces;

import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

public interface S3Service {

    void uploadFile(InputStream inputStream, ObjectMetadata objectMetadata, String fileName);

    List<String> getFileURL(List<String> filenames);

    void deleteFile(List<String> filenames);
}
