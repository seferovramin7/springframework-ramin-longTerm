package sfgpetclinic.service.map;

import sfgpetclinic.model.Owner;
import sfgpetclinic.service.CrudService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService <Owner, Long> {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }
    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        return super.save( object , object.getId());
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
}
