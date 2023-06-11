package com.example.graphql.board.adapter.port.out.persistence

import org.springframework.data.jpa.repository.JpaRepository

internal interface BoardJpaRepository : JpaRepository<BoardJpaEntity, Long>