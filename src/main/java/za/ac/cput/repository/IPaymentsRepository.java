package za.ac.cput.repository;

import za.ac.cput.domain.Payments;

import java.util.Set;
/* IPaymentsRepository.Java
 *  Entity for Payments
 *  Author: Chulumanco Buhle Nkwindana (219390983)
 *  Date: 29 March 2022
 * */
public interface IPaymentsRepository extends IRepository<Payments , String>{


    public Set<Payments> getAll();

}
