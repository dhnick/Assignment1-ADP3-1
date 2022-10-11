package za.ac.cput.service;
/*
    IService.java
    Entity for IService
    Author: Jody Heideman (219307725)
    Date: 14/08/2022
*/
import java.util.Optional;

public interface IService<T, ID> {


    T save(T t);
    Optional<T> read(ID id);
    void delete(T t);
}
