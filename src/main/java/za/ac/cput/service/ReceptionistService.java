package za.ac.cput.service;
/*
    ReceptionistService.java
    Entity for ReceptionistService
    Author: Jody Heideman (219307725)
    Date: 14/08/2022
*/

import za.ac.cput.domain.Receptionist;
import za.ac.cput.repository.ReceptionistRepository;

import java.util.List;
import java.util.Optional;

public class ReceptionistService implements IReceptionistService{


    private final ReceptionistRepository repository;
    private static IReceptionistService service;


    private ReceptionistService(){
        this.repository = ReceptionistRepository.getRepository();
    }

    public static IReceptionistService getService() {
        if (service == null)
            service = new ReceptionistService();
        return service;

    }

    public Receptionist save(Receptionist receptionist) {
        return this.repository.save(receptionist);
    }


    public Optional<Receptionist> read(String s) {
        return this.repository.read(s);
    }

    public void delete(Receptionist receptionist) {
        this.repository.delete(receptionist);
    }


    public List<Receptionist> getAll() {
        return this.repository.getAll();
    }
}

