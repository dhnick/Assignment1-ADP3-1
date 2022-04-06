package za.ac.cput.Repository;

import za.ac.cput.Domain.Receptionist;

import java.util.HashSet;
import java.util.Set;

public class ReceptionistRepository implements IReceptionistRepository {

    private static ReceptionistRepository repository = null;
    private Set<Receptionist> receptionistDB = null;

    private ReceptionistRepository(){
        receptionistDB = new HashSet<Receptionist>();
    }

    public static ReceptionistRepository getRepository() {

        if (repository == null)
            repository = new ReceptionistRepository();
        return repository;

    }

    @Override
    public Receptionist create(Receptionist receptionist) {
    boolean success = receptionistDB.add(receptionist);
    if(!success)
        return null;
    return receptionist;
    }

    @Override
    public Receptionist read(Integer receptionistID) {

        for (Receptionist r : receptionistDB) {
            if (r.getReceptionistID() == receptionistID) {
                return r;

            }
        }

        return null;

     /*   //lamda expression
        Receptionist receptionist = receptionistDB.stream()
                .filter(r -> r.getReceptionistID() == receptionistID)
                .findAny()
                .orElse(null);
        return receptionist;
        */
    }

    @Override
    public Receptionist update(Receptionist receptionist) {

    Receptionist oldReceptionist = read(receptionist.getReceptionistID());
    if(oldReceptionist !=null){
        receptionistDB.remove(oldReceptionist);
        receptionistDB.add(receptionist);
        return receptionist;
    }
    return null;

    }

    @Override
    public boolean delete(Integer receptionistID) {
        Receptionist receptionistToDelete = read(receptionistID);
        if(receptionistToDelete == null)
            return false;
            receptionistDB.remove(receptionistToDelete);

        return true;
    }

    @Override
    public Set<Receptionist> getAll() {
        return receptionistDB;
    }













}
