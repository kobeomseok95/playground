package com.example.jpashop.repository;

import com.example.jpashop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByName(String name);

//     MultipleBagFetchException 발생
    @Query("select distinct m from Member m " +
            "join fetch m.orders o " +
            "join fetch o.delivery d " +
            "where m.id = :id " +
            "order by o.createdAt desc")
    Optional<Member> findByIdFetch(@Param("id") Long id);
}
