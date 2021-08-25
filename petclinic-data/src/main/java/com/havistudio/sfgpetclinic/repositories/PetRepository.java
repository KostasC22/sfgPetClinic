package com.havistudio.sfgpetclinic.repositories;

import com.havistudio.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
