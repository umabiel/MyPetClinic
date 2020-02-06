package com.myterminalart.mypetclinic.services.map;

import com.myterminalart.mypetclinic.model.Speciality;
import com.myterminalart.mypetclinic.services.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialtyService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return super.save(speciality);
    }

    @Override
    public void delete(Speciality t) {
        super.delete(t);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
