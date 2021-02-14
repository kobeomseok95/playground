package com.clone.petclinic.repository;

import com.clone.petclinic.domain.Pet;
import com.clone.petclinic.domain.PetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet, Long> {

    @Query("select pt from PetType pt")
    @Transactional(readOnly = true)
    List<PetType> getPetTypes();

    @Query("select pt from PetType pt where pt.name = :name")
    @Transactional(readOnly = true)
    PetType findByPetTypeName(@Param("name") String name);

    @Query("select p from Pet p join fetch p.owner o where p.id = :id")
    @Transactional(readOnly = true)
    Optional<Pet> findByPetIdWithOwner(@Param("id") Long id);
}
