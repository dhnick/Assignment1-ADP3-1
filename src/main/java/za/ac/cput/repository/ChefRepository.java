package za.ac.cput.repository;
/* ChefRepository.java
 * Author: Smangele Witness Mabaso (220047154)
 * Date: 6 April 2022
 */

import za.ac.cput.domain.Chef;

import java.util.HashSet;
import java.util.Set;

public class ChefRepository implements IChefRepository {
    private static ChefRepository repository = null;
    private Set<Chef> ChefDB = null;

    private ChefRepository() {
        ChefDB = new HashSet<Chef>();
    }

    private static ChefRepository getRepository() {
        if (repository == null){
            repository = new ChefRepository();
    }
    return repository;
}

    @Override
    public Chef create(Chef chef) {
        boolean success = ChefDB.add(chef);
        if (!success)
            return null;
        return chef;
    }

    @Override
    public Chef read(String chefID) {
        for (Chef e : ChefDB){
            if (e.getChefID().equals(chefID))
                return e;
    }
    return  null;
    }

    @Override
    public Chef update(Chef chef) {
        Chef firstCustomer = read(chef.getChefID());
        if (firstCustomer != null) {
            ChefDB.remove(firstCustomer);
            ChefDB.add(chef);
            return chef;
        }
        return null;
    }

    @Override
    public void delete(String chefID) {
        Chef deleteChef = read(chefID);
        if (deleteChef == null) {
            System.out.println("Chef is null");
        }
        ChefDB.remove(deleteChef);
        System.out.println("Chef successfully removed!");
    }

    @Override
    public Set<Chef> getAll() {
        return null;
    }
}
