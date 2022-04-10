package za.ac.cput.repository;

import za.ac.cput.domain.Tables;

import java.util.Set;
//chulumano buhle Nkwinda
//219390983
//adp3
public interface ITablesRepository extends IRepository<Tables, String>{

    public Set<Tables> getAll();
}
