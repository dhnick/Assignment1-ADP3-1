package za.ac.cput.service;

import za.ac.cput.domain.Managers;

import java.util.List;

public interface ManagerService extends IService <Managers, String> {


    List<Managers> findAll();
}
