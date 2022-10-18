package za.ac.cput.repository;

import za.ac.cput.domain.Tables;

import java.util.Set;
/* ITablesRepository.Java
 *  Entity for Tables
 *  Author: Chulumanco Buhle Nkwindana (219390983)
 *  Date: 29 March 2022
 * */
public interface ITablesRepository extends IRepository<Tables, String>{

    public Set<Tables> getAll();
}
