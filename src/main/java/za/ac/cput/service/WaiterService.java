package za.ac.cput.service;

import za.ac.cput.domain.Waiters;

import java.util.List;
import java.util.Optional;

public interface WaiterService extends IService <Waiters, String>{

    List<Waiters> findAll();

    Optional<Waiters> findByFirstName(String firstname);
}
