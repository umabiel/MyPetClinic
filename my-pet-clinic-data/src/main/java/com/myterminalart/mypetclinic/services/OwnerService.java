package com.myterminalart.mypetclinic.services;

import com.myterminalart.mypetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
