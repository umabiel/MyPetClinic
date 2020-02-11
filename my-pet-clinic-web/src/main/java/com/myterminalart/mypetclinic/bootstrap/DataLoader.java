package com.myterminalart.mypetclinic.bootstrap;

import com.myterminalart.mypetclinic.model.*;
import com.myterminalart.mypetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0)
            loadData();


    }

    private void loadData() {
        //        Tipos de Mascota
        PetType petTypeDog = new PetType();
        petTypeDog.setName("Dog");
        PetType savedDog = petTypeService.save(petTypeDog);

        PetType petTypeCat = new PetType();
        petTypeCat.setName("Cat");
        PetType savedCat = petTypeService.save(petTypeCat);

//        Especialidades
        Speciality radiology = new Speciality();
        radiology.setDescription("Radiologia");
        Speciality radioSaved = specialtyService.save(radiology);

        Speciality surggery = new Speciality();
        surggery.setDescription("Cirugia");
        Speciality surgeySaved = specialtyService.save(surggery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentista");
        Speciality dentSaved = specialtyService.save(dentistry);

//      Dueños y sus Mascotas
        Owner owner1 = new Owner();
        owner1.setFirstName("Gustavo");
        owner1.setLastName("Chalco");
        owner1.setAddress("Calle Atahualpa 558");
        owner1.setCity("Miraflores - Lima");
        owner1.setTelephone("987654321");

        Pet asiri = new Pet();
        asiri.setPetType(savedCat);
        asiri.setOwner(owner1);
        asiri.setBirthDay(LocalDate.now());
        asiri.setName("Asiri");
        owner1.getPets().add(asiri);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Claudia");
        owner2.setLastName("Okada");
        owner2.setAddress("Calle Atahualpa 558");
        owner2.setCity("Miraflores - Lima");
        owner2.setTelephone("9876543234");

        Pet africa = new Pet();
        africa.setPetType(savedDog);
        africa.setOwner(owner2);
        africa.setBirthDay(LocalDate.now());
        africa.setName("Africa");
        owner2.getPets().add(africa);

        ownerService.save(owner2);

        Visit dogVisit = new Visit();
        dogVisit.setPet(africa);
        dogVisit.setDate(LocalDate.now());
        dogVisit.setDescription("Bano");

        visitService.save(dogVisit);

        System.out.println("Visitas cargados...");

        System.out.println("Duenos cargados...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Valdiviezo");
        vet1.getSpecialities().add(surgeySaved);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Wilmer");
        vet2.setLastName("Valdiviezo");
        vet2.getSpecialities().add(dentSaved);

        vetService.save(vet2);

        System.out.printf("Veterinarios cargados...");
    }
}
