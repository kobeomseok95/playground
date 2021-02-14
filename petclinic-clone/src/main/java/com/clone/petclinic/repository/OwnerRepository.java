package com.clone.petclinic.repository;

import com.clone.petclinic.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    // 객체 그래프로 탐색하기!, left, 해당 객체의 필드명으로 그래프 탐색
    @Query("select distinct o from Owner o" +
            " left join fetch o.pets p" +
            " where o.lastName like %:lastName%")
    @Transactional(readOnly = true)
    Collection<Owner> findByLastName(@Param("lastName") String lastName);
    
    // 단건 조회시 모두 fetch를 통해 가져오기
    @Query("select distinct o from Owner o" +
            " left join fetch o.pets p" +
            " left join fetch p.petType pt" +
            " left join fetch p.visits v" +
            " where o.id = :id")
    @Transactional(readOnly = true)
    Optional<Owner> findByIdFetch(@Param("id") Long id);
}
