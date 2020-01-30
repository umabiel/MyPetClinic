package com.myterminalart.mypetclinic.bootstrap;

import com.myterminalart.mypetclinic.model.Owner;
import com.myterminalart.mypetclinic.model.Vet;
import com.myterminalart.mypetclinic.services.OwnerService;
import com.myterminalart.mypetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Gustavo");
        owner1.setLastName("Chalco");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Claudia");
        owner2.setLastName("Okada");

        ownerService.save(owner2);

        System.out.println("Duenos cargados...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Valdiviezo");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Wilmer");
        vet2.setLastName("Valdiviezo");

        vetService.save(vet2);

        System.out.printf("Veterinarios cargados...");



    }
}
