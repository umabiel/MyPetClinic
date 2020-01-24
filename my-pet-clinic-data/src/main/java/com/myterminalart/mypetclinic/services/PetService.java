package com.myterminalart.mypetclinic.services;

import com.myterminalart.mypetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
