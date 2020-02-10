package com.myterminalart.mypetclinic.repositories;

import com.myterminalart.mypetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
