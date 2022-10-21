package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Managers;
import za.ac.cput.domain.Waiters;

import java.util.List;
import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Managers, String> {


    List<Managers> findAll();
    Managers getManagerID( String ManagerID);

    void deleteManagerByManagerID(String ManagerID);

    Optional<Managers> findByFirstName(String firstname);


}
