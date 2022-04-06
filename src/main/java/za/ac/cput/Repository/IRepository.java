package za.ac.cput.Repository;

import za.ac.cput.Domain.Receptionist;

import java.util.HashSet;

public interface IRepository<T , ID> {
     T create(T t);
     T read(ID id);
     T update(T t);
     boolean delete(ID id);


}
