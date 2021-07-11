package com.example.awsec2s3practice.services.implement;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;
import com.example.awsec2s3practice.services.components.S3Component;
import com.example.awsec2s3practice.services.interfaces.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

import static java.util.stream.Collectors.*;

@Component
@RequiredArgsConstructor
public class S3ServiceImpl implements S3Service {

    private final AmazonS3Client amazonS3Client;
    private final S3Component s3Component;

    @Override
    public void uploadFile(InputStream inputStream, ObjectMetadata objectMetadata, String fileName) {
        amazonS3Client.putObject(
                new PutObjectRequest(s3Component.getBucket(), fileName, inputStream, objectMetadata)
                        .withCannedAcl(CannedAccessControlList.PublicRead));
    }

    @Override
    public List<String> getFileURL(List<String> filenames) {
        return filenames.stream()
                .map(filename -> String.valueOf(amazonS3Client.getUrl(s3Component.getBucket(), filename)))
                .collect(toList());
    }

    @Override
    public void deleteFile(List<String> filenames) {
        filenames.forEach(filename -> {
            amazonS3Client.deleteObject(new DeleteObjectRequest(s3Component.getBucket(), filename));
        });
    }
}
