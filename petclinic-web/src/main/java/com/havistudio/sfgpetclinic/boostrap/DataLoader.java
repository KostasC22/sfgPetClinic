package com.havistudio.sfgpetclinic.boostrap;

import com.havistudio.sfgpetclinic.model.Owner;
import com.havistudio.sfgpetclinic.model.PetType;
import com.havistudio.sfgpetclinic.model.Vet;
import com.havistudio.sfgpetclinic.services.OwnerService;
import com.havistudio.sfgpetclinic.services.PetTypeService;
import com.havistudio.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService){
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        Owner owner2 = new Owner();
        owner1.setFirstName("Michael");
        owner2.setFirstName("Fiona");
        owner1.setLastName("Weston");
        owner2.setLastName("Glenanne");
        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        Vet vet2 = new Vet();
        vet1.setFirstName("Sam");
        vet2.setFirstName("Jessie");
        vet1.setLastName("Axe");
        vet2.setLastName("Porter");
        vetService.save(vet1);
        vetService.save(vet2);
        System.out.println("Loaded Vets....");
    }
}
