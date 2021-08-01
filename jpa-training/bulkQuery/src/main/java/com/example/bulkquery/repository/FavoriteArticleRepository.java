package com.example.bulkquery.repository;

import com.example.bulkquery.entity.FavoriteArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FavoriteArticleRepository extends JpaRepository<FavoriteArticle, Long> {

    @Modifying
    @Query("delete from FavoriteArticle fa where fa.member.id = :memberId")
    void deleteByMemberId(@Param("memberId") Long memberId);
}
