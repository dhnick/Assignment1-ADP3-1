package za.ac.cput.service;


import za.ac.cput.domain.Receptionist;

import java.util.List;
import java.util.Set;

public interface IReceptionistService extends IService<Receptionist, String>{

    Set<Receptionist> getAll();
}
