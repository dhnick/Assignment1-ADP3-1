
package za.ac.cput.repository;

import za.ac.cput.domain.Receptionist;

import java.util.Optional;
@Deprecated
public interface IRepository <T, ID>{
  public T create(T t);
  public T read(ID id);
  public T update(T t);
  public boolean delete(ID id);


}
