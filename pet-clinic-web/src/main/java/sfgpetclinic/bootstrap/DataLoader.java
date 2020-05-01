package sfgpetclinic.bootstrap;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sfgpetclinic.model.Owner;
import sfgpetclinic.model.Pet;
import sfgpetclinic.model.PetType;
import sfgpetclinic.model.Vet;
import sfgpetclinic.service.OwnerService;
import sfgpetclinic.service.PetTypeService;
import sfgpetclinic.service.VetService;

import java.time.LocalDate;

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

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(dog);


        Owner owner1 = new Owner();
        owner1.setFirstName("Murad");
        owner1.setLastName("Heyderov");
        owner1.setAddress("Heyder Eliyev st.");
        owner1.setCity("Baku");
        owner1.setTelephone("051-898-07-77");

        Pet muradsDog = new Pet();
        muradsDog.setPetType(savedDogType);
        muradsDog.setOwner(owner1);
        muradsDog.setBirthDate(LocalDate.now());
        muradsDog.setName("Rosco");
        owner1.getPets().add(muradsDog);


        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Eli");
        owner2.setLastName("Babayev");
        owner2.setAddress("Bextiyar Vahabzade st.");
        owner2.setCity("NAxcivan");
        owner2.setTelephone("055-345-43-03");

        Pet eliSCat = new Pet();
        eliSCat.setPetType(savedCatType);
        eliSCat.setOwner(owner2);
        eliSCat.setBirthDate(LocalDate.now());
        eliSCat.setName("Meow");
        owner2.getPets().add(eliSCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Same");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Same");
        vet2.setLastName("Houston");

        vetService.save(vet2);

        System.out.println("Loaded vets....");

    }
}
