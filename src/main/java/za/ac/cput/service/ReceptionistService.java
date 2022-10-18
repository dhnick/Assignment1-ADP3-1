package za.ac.cput.service;
/*
    ReceptionistService.java
    Entity for ReceptionistService
    Author: Jody Heideman (219307725)
    Date: 14/08/2022
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Delivery;
import za.ac.cput.domain.Receptionist;
import za.ac.cput.repository.IReceptionistRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public class ReceptionistService implements IReceptionistService{

    @Autowired
    private IReceptionistRepository repository;
    private static ReceptionistService service = null;

    public static ReceptionistService getService() {
        if (service == null)
            service = new ReceptionistService();
        return service;

    }

    public Receptionist save(Receptionist receptionist) {
        return this.repository.save(receptionist);
    }


    public Receptionist read(String receptionistId) {
        return this.repository.findById(receptionistId).orElse(null);
    }

    @Override
    public Receptionist update(Receptionist receptionistId)
    {
        if(this.repository.existsById(receptionistId.getReceptionistID()))
        {
            return this.repository.save(receptionistId);
        }

        return null;
    }

    public boolean delete(String receptionistId) {
        this.repository.deleteById(receptionistId);

        if(this.repository.existsById(receptionistId)){
            return false;
        }
        return true;
    }


    public Set<Receptionist> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}

