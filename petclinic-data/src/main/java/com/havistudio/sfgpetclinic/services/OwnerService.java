package com.havistudio.sfgpetclinic.services;

import com.havistudio.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
