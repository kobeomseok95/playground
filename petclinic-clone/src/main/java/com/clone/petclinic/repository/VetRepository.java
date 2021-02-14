package com.clone.petclinic.repository;

import com.clone.petclinic.domain.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface VetRepository extends JpaRepository<Vet, Long> {

    @Query("select distinct v from Vet v" +
            " left join fetch v.specialities vs" +
            " left join fetch vs.speciality s")
    @Transactional(readOnly = true)
    Collection<Vet> findAllFetch();
}
