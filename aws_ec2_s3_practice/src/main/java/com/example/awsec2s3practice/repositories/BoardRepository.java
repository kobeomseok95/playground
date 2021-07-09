package com.example.awsec2s3practice.repositories;

import com.example.awsec2s3practice.entities.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
