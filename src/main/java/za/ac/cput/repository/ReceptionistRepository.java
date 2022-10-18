package za.ac.cput.repository;
/*
    ReceptionistRepository.java
    Entity for ReceptionistRepository
    Author: Jody Heideman (219307725)
    Date: 06/03/2022
 */
import za.ac.cput.domain.Receptionist;

import java.util.*;

public class ReceptionistRepository {


    private final List<Receptionist> receptionistList;
    private static ReceptionistRepository repository;


    private ReceptionistRepository(){
        this.receptionistList = new ArrayList<>();
    }

    public static ReceptionistRepository getRepository() {
        if (repository == null)
            repository = new ReceptionistRepository();
        return repository;

    }

    public Receptionist save(Receptionist receptionist) {

        Optional<Receptionist> read = read(receptionist.getReceptionistID());
        if(read.isPresent()){
            delete(read.get());
        }
        this.receptionistList.add(receptionist);
        return receptionist;
    }

    public Optional<Receptionist> read(String receptionistId) {
        return this.receptionistList.stream().filter(c-> c.getReceptionistID().equalsIgnoreCase(receptionistId))
                .findFirst();
    }

    public void delete(Receptionist delivery) {
        this.receptionistList.remove(delivery);
    }


    public List<Receptionist> getAll() {
        return this.receptionistList;
    }

}
