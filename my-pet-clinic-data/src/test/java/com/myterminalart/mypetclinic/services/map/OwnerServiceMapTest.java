package com.myterminalart.mypetclinic.services.map;

import com.myterminalart.mypetclinic.model.Owner;
import com.myterminalart.mypetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerService ownerService;
    final Long ownerId = 1L;
    final String lastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerService = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());

        ownerService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerService.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerService.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner = Owner.builder().id(id).build();
        Owner ownerSaved = ownerService.save(owner);

        assertEquals(id, ownerSaved.getId());
    }

    @Test
    void saveNoId() {
        Owner ownerSaved = ownerService.save(Owner.builder().build());

        assertNotNull(ownerSaved);
        assertNotNull(ownerSaved.getId());

    }

    @Test
    void delete() {
        ownerService.delete(ownerService.findById(ownerId));
        assertEquals(0, ownerService.findAll().size());
    }

    @Test
    void deleteById() {

        ownerService.deleteById(ownerId);
        assertEquals(0, ownerService.findAll().size());

    }

    @Test
    void findByLastName() {
        Owner owner = ownerService.findByLastName(lastName);

        assertNotNull(owner);

        assertEquals(ownerId, owner.getId());

    }

    @Test
    void findByLastNameNotFound() {
        Owner owner = ownerService.findByLastName("foo");

        assertNull(owner);

    }
}