package com.example.bulkquery.repository;

import com.example.bulkquery.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Modifying
    @Query("delete from Member m where m.id = :memberId")
    void deleteByMemberId(@Param("memberId") Long memberId);

    @Query("select m from Member m join fetch m.favoriteArticleList where m.id = :memberId")
    Optional<Member> findByIdFetch(@Param("memberId") Long memberId);
}
