package sfgpetclinic.bootstrap;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sfgpetclinic.model.Owner;
import sfgpetclinic.model.Vet;
import sfgpetclinic.service.OwnerService;
import sfgpetclinic.service.VetService;
import sfgpetclinic.service.map.OwnerServiceMap;
import sfgpetclinic.service.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader() {
        ownerService =  new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Ramin");
        owner1.setLastName("Safarov");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Eli");
        owner2.setLastName("babayev");

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Same");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Same");
        vet2.setLastName("Houston");

        vetService.save(vet2);

        System.out.println("Loaded vets....");

    }
}
