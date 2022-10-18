package za.ac.cput.repository;

/* WaitersRepository.Java
 *  Author: Tim Davids 219296219
 *  Entity for WaitersRepository
 *  Date: 27 March 2022
 * */

import za.ac.cput.domain.Waiters;

import java.util.HashSet;
import java.util.Set;

public class WaiterRepository implements IWaiterRepository {
    private static WaiterRepository repository = null;
    private Set<Waiters> WaiterDB = null;

    private WaiterRepository() {
        WaiterDB = new HashSet<Waiters>();
    }

    public static WaiterRepository getRepository() {
        if (repository == null) {
            repository = new WaiterRepository();
        }
        return repository;
    }

    @Override
    public Waiters create(Waiters waiters) {
        boolean success = WaiterDB.add(waiters);
        if (!success)
            return null;
        return waiters;

    }

    @Override
    public Waiters read(String staffID) {

        for (Waiters L : WaiterDB) {
            if (Waiters.getStaffID() == staffID) {
                return L;


            }

        }
        return null;
    }


    @Override
    public Waiters update(Waiters waiters) {

        Waiters firstWaiters = read(Waiters.getStaffID());
        if (firstWaiters != null) {
            WaiterDB.remove(firstWaiters);
            WaiterDB.add(waiters);
            return waiters;

        }


        return null;
    }

    @Override
    public void delete(String staffID) {
        Waiters waitersToDelete = read(staffID);
        if (waitersToDelete == null) {
            System.out.println("Waiter is null ");
        } else {
            WaiterDB.remove(waitersToDelete);
            System.out.println("Waiter is deleted ");

        }


    }

    @Override
    public Set<Waiters> getAll() {
        return WaiterDB;
    }
}


