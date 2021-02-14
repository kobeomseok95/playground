package com.clone.petclinic.repository;

import com.clone.petclinic.controller.dto.OwnerJoinAndEditRequestDto;
import com.clone.petclinic.controller.dto.PetJoinAndEditRequestDto;
import com.clone.petclinic.domain.*;
import com.clone.petclinic.dummy.OwnerDummy;
import com.clone.petclinic.dummy.PetDummy;
import com.clone.petclinic.dummy.VisitDummy;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RepositoryTest {

    private static Logger logger = LoggerFactory.getLogger(RepositoryTest.class);

    @Autowired
    EntityManager em;

    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    PetRepository petRepository;

    @Autowired
    VisitRepository visitRepository;

    @Autowired
    VetRepository vetRepository;

    @Test
    void Owner등록() {

        //given
        Owner owner = OwnerDummy.createOwner();

        //when
        Owner save = ownerRepository.save(owner);

        //then
        assertNotNull(save.getId());
    }

    @Test
    void Owner_수정() throws Exception {

        //given
        Owner owner = OwnerDummy.createOwner();
        Owner savedOwner = ownerRepository.save(owner);
        OwnerJoinAndEditRequestDto dto = OwnerDummy.createOwnerJoinAndEditRequestDto();

        //when
        owner.saveOrEdit(dto);
        Owner editOwner = ownerRepository.findById(savedOwner.getId()).orElseThrow();

        assertAll(
                () -> assertEquals(savedOwner.getId(), editOwner.getId()),
                () -> assertEquals(editOwner.getFirstName(), "edit"),
                () -> assertEquals(editOwner.getLastName(), "edit"),
                () -> assertEquals(editOwner.getPhone(), "edit"),
                () -> assertEquals(editOwner.getAddress().getCity(), "edit"),
                () -> assertEquals(editOwner.getAddress().getStreet(), "edit"),
                () -> assertEquals(editOwner.getAddress().getZipcode(), "edit")
        );
    }

    @Test
    void Pet_등록() throws Exception {

        //given
        Owner owner = OwnerDummy.createOwner();
        ownerRepository.save(owner);
        Pet pet = PetDummy.createPet(petRepository.getPetTypes().get(0));
        pet.addOwner(owner);

        //when
        Pet savedPet = petRepository.save(pet);

        //then
        assertAll(
                () -> assertEquals(savedPet.getOwner().getId(), owner.getId()),
                () -> assertEquals(owner.getPets().size(), 1),
                () -> assertEquals(owner.getPets().iterator().next(), savedPet)
        );
    }

    @Test
    void Pet_수정_view()throws Exception {

        //given
        Owner owner = OwnerDummy.createOwner();
        ownerRepository.save(owner);
        Pet pet = PetDummy.createPet(petRepository.getPetTypes().get(0));
        pet.addOwner(owner);
        petRepository.save(pet);

        //when
        Pet findPet = petRepository.findByPetIdWithOwner(pet.getId()).orElseThrow();

        //then
        assertEquals(findPet.getId(), pet.getId());
        assertNotNull(findPet.getOwner());
        assertEquals(findPet.getOwner().getId(), owner.getId());
    }

    @Test
    void Pet_수정() throws Exception {

        //given
        Owner owner = OwnerDummy.createOwner();
        ownerRepository.save(owner);
        Pet pet = PetDummy.createPet(petRepository.getPetTypes().get(0));
        pet.addOwner(owner);
        petRepository.save(pet);
        PetJoinAndEditRequestDto dto = PetDummy.createPetJoinAndEditRequestDto();
        PetType type = petRepository.findByPetTypeName(dto.getPetType());

        //when
        pet.convertDtoIntoPet(dto, type);
        em.flush();
        em.clear();

        //then
        Pet findPet = petRepository.findById(pet.getId()).orElseThrow();
        assertAll(
                () -> assertEquals(findPet.getOwner().getId(), owner.getId()),
                () -> assertEquals(pet.getPetType().getName(), "snake"),
                () -> assertEquals(findPet.getOwner().getPets().size(), 1),
                () -> assertEquals(findPet.getOwner().getPets().iterator().next().getId(), findPet.getId())
        );
    }

    @Test
    void visit등록() throws Exception {

        //given
        Owner owner = OwnerDummy.createOwner();
        ownerRepository.save(owner);

        Pet pet = PetDummy.createPet(petRepository.getPetTypes().get(0));
        pet.addOwner(owner);
        petRepository.save(pet);

        //when
        Visit visit = VisitDummy.createVisit();
        visit.addPet(pet);
        visitRepository.save(visit);

        Pet findPet = petRepository.findById(pet.getId()).orElseThrow();
        assertEquals(findPet.getVisits().iterator().next().getId(), visit.getId());
    }

    @Test
    void Owner_단건_조회() throws Exception {

        //given
        Owner owner = OwnerDummy.createOwner();
        Pet pet1 = PetDummy.createPet(petRepository.getPetTypes().get(1));
        Pet pet2 = PetDummy.createPet(petRepository.getPetTypes().get(3));
        Visit visit1 = VisitDummy.createVisit();
        Visit visit2 = VisitDummy.createVisit();

        //연관관계
        visit1.addPet(pet1);
        visit2.addPet(pet2);
        pet1.addOwner(owner);
        pet2.addOwner(owner);

        // 저장
        ownerRepository.save(owner);
        petRepository.save(pet1);
        petRepository.save(pet2);
        visitRepository.save(visit1);
        visitRepository.save(visit2);
        em.flush();
        em.clear();

        //when
        Owner findOwner = ownerRepository.findByIdFetch(owner.getId()).orElseThrow();

        //then
        assertEquals(findOwner.getPets().size(), 2);
        for (Pet pet : findOwner.getPets()) {
            assertNotNull(pet.getPetType());
            assertEquals(pet.getVisits().size(), 1);
        }
    }

    @Test
    void Owner_다수_조회() throws Exception {
        //given
        Owner owner1 = OwnerDummy.createOwner();
        Pet pet1 = PetDummy.createPet(petRepository.getPetTypes().get(1));
        Pet pet2 = PetDummy.createPet(petRepository.getPetTypes().get(3));
        Visit visit1 = VisitDummy.createVisit();
        Visit visit2 = VisitDummy.createVisit();
        Owner owner2 = OwnerDummy.createOwner();
        Owner owner3 = OwnerDummy.createOwner();

        //연관관계
        visit1.addPet(pet1);
        visit2.addPet(pet2);
        pet1.addOwner(owner1);
        pet2.addOwner(owner1);

        // 저장
        ownerRepository.save(owner1);
        ownerRepository.save(owner2);
        ownerRepository.save(owner3);
        petRepository.save(pet1);
        petRepository.save(pet2);
        visitRepository.save(visit1);
        visitRepository.save(visit2);
        em.flush();
        em.clear();

        //when
        Collection<Owner> owners = ownerRepository.findByLastName("o");

        //then
        assertEquals(owners.size(), 3);
        for (Owner owner : owners) {
            assertNotNull(owner.getPets());
        }
    }

    @Test
    void vets_조회() throws Exception{
        Collection<Vet> vets = vetRepository.findAllFetch();

        assertEquals(vets.size(), 6);
    }
}















