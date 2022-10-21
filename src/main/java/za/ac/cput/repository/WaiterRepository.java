package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Waiters;

import java.util.List;
import java.util.Optional;

@Repository
public interface WaiterRepository extends JpaRepository<Waiters, String> {

    List<Waiters> findAll();
    Waiters getStaffID( String staffID);

    void deleteStaffByStaffID(String staffID);

    Optional<Waiters> findByFirstName(String firstname);
}
