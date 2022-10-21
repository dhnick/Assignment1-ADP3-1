package za.ac.cput.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Managers;
import za.ac.cput.repository.ManagerRepository;
import za.ac.cput.service.ManagerService;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerService {

    public final ManagerRepository managerRepository;

    @Autowired
    public ManagerServiceImpl(ManagerRepository managerRepository)
    {this.managerRepository = managerRepository;}

    @Override
    public Managers save(Managers managers) {
        return this.managerRepository.save(managers);
    }

    @Override
    public Optional<Managers> read(String s) {
        return this.managerRepository.findById(s);
    }

    @Override
    public void delete(Managers managers) {
        this.managerRepository.delete(managers);

    }

    @Override
    public List<Managers> findAll() {
        return this.managerRepository.findAll();
    }

    public Managers getManagerID(String managerID) {
        return this.managerRepository.getManagerID(managerID);
    }

    public void deleteManagerByManagerID(String managerID) {
        this.managerRepository.deleteManagerByManagerID(managerID);
    }
}
