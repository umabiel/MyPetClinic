package com.myterminalart.mypetclinic.services;

import java.util.Set;

public interface CrudService<T, ID> {

    Set<T> findAll();

    T finbById(ID id);

    T save(T t);

    void delete(T t);

    void deleteById(ID id);
}
