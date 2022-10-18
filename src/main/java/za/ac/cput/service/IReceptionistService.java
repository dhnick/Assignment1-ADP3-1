package za.ac.cput.service;


import za.ac.cput.domain.Receptionist;

import java.util.List;

public interface IReceptionistService extends IService<Receptionist, String>{

    List<Receptionist> getAll();
}
