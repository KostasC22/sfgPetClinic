package com.havistudio.sfgpetclinic.boostrap;

import com.havistudio.sfgpetclinic.model.Owner;
import com.havistudio.sfgpetclinic.model.Vet;
import com.havistudio.sfgpetclinic.services.OwnerService;
import com.havistudio.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService){
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        Owner owner2 = new Owner();
        owner1.setId(1L);
        owner2.setId(2L);
        owner1.setFirstName("Michael");
        owner2.setFirstName("Fiona");
        owner1.setLastName("Weston");
        owner2.setLastName("Glenanne");
        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        Vet vet2 = new Vet();
        vet1.setId(1L);
        vet2.setId(2L);
        vet1.setFirstName("Sam");
        vet2.setFirstName("Jessie");
        vet1.setLastName("Axe");
        vet2.setLastName("Porter");
        vetService.save(vet1);
        vetService.save(vet2);
        System.out.println("Loaded Vets....");
    }
}
