package com.myterminalart.mypetclinic.repositories;

import com.myterminalart.mypetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
