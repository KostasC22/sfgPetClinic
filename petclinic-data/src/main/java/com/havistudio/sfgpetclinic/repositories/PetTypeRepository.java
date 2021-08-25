package com.havistudio.sfgpetclinic.repositories;

import com.havistudio.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
