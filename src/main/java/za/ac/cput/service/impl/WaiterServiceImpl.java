package za.ac.cput.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Waiters;
import za.ac.cput.repository.WaiterRepository;
import za.ac.cput.service.WaiterService;

import java.util.List;
import java.util.Optional;

@Service
public class WaiterServiceImpl implements WaiterService {

    public final WaiterRepository waiterRepository;

    @Autowired
    public WaiterServiceImpl(WaiterRepository waiterRepository)
    {this.waiterRepository = waiterRepository;}


    @Override
    public Waiters save(Waiters waiters) {
        return this.waiterRepository.save(waiters);
    }

    @Override
    public Optional<Waiters> read(String s) {
        return this.waiterRepository.findById(s);
    }

    @Override
    public void delete(Waiters waiters) {
        this.waiterRepository.delete(waiters);

    }

    @Override
    public List<Waiters> findAll() {
        return this.waiterRepository.findAll();
    }

    public Waiters getStaffID(String staffID) {
        return this.waiterRepository.getStaffID(staffID);
    }

    public void deleteWaiterByWaiterID(String staffID) {
        this.waiterRepository.deleteStaffByStaffID(staffID);
    }
    @Override
    public Optional<Waiters> findByFirstName(String firstname) {
        return this.waiterRepository.findByFirstName(firstname);

    }


}



