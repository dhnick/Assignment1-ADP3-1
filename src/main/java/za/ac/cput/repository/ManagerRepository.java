package za.ac.cput.repository;

/* ManagersRepository.Java
 *  Author: Tim Davids 219296219
 *  Entity for ManagersRepository
 *  Date: 27 March 2022
 * */

import za.ac.cput.domain.Managers;

import java.util.HashSet;
import java.util.Set;

public class ManagerRepository implements IManagerRepository {
    private static ManagerRepository repository = null;
    private Set<Managers> ManagerDB = null;

    private ManagerRepository() {
        ManagerDB = new HashSet<Managers>();
    }

    public static ManagerRepository getRepository() {
        if (repository == null) {
            repository = new ManagerRepository();
        }
        return repository;
    }

    @Override
    public Managers create(Managers manager) {
        boolean success = ManagerDB.add(manager);
        if (!success)
            return null;
        return manager;

    }


    @Override
    public Managers read(String ManagerID) {
        for (Managers k : ManagerDB) {
            if (k.getManagerID() == ManagerID) {
                return k;

            }

        }
        return null;
    }

    @Override
    public Managers update(Managers managers) {
        {
            Managers firstManagers = read(managers.getManagerID());
            if (firstManagers != null) {
                ManagerDB.remove(firstManagers);
                ManagerDB.add(managers);
                return managers;
            }
            return null;
        }

    }



    @Override
    public void delete(String ManagersID) {
        Managers managersToDelete = read(ManagersID);
        if (managersToDelete == null) {
            System.out.println("Manager is null ");
        } else {
            ManagerDB.remove(managersToDelete);
            System.out.println("Manager is deleted ");

        }

    }

    @Override
    public Set<Managers> getAll() {
        return ManagerDB;
    }
}

