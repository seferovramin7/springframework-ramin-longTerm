package sfgpetclinic.service;

import sfgpetclinic.model.Owner;

// @author Ramin Safarov

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
