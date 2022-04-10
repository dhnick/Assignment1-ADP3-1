package za.ac.cput.repository;

import za.ac.cput.domain.Payments;

import java.util.Set;
//chulumano buhle Nkwinda
//219390983
//adp3
public interface IPaymentsRepository extends IRepository<Payments , String>{


    public Set<Payments> getAll();

}
