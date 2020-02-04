package com.myterminalart.mypetclinic.bootstrap;

import com.myterminalart.mypetclinic.model.Owner;
import com.myterminalart.mypetclinic.model.PetType;
import com.myterminalart.mypetclinic.model.Vet;
import com.myterminalart.mypetclinic.services.OwnerService;
import com.myterminalart.mypetclinic.services.PetTypeService;
import com.myterminalart.mypetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType petTypeDog = new PetType();
        petTypeDog.setName("Dog");
        PetType savedDog = petTypeService.save(petTypeDog);

        PetType petTypeCat = new PetType();
        petTypeCat.setName("Cat");
        PetType savedCat = petTypeService.save(petTypeCat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Gustavo");
        owner1.setLastName("Chalco");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Claudia");
        owner2.setLastName("Okada");

        ownerService.save(owner2);

        System.out.println("Duenos cargados...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Valdiviezo");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Wilmer");
        vet2.setLastName("Valdiviezo");

        vetService.save(vet2);

        System.out.printf("Veterinarios cargados...");



    }
}
