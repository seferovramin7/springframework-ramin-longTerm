package sfgpetclinic.bootstrap;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sfgpetclinic.model.*;
import sfgpetclinic.service.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0){
            LoadData();
        }


    }

    private void LoadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(dog);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

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

        Visit catVisit = new Visit();
        catVisit.setPet(eliSCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Kittyyy");

        visitService.save(catVisit);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Same");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Same");
        vet2.setLastName("Houston");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded vets....");
    }
}
