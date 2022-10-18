
package za.ac.cput.repository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface IRepository <T, ID>{
  T save(T t);
  Optional<T> read(ID id);
   void delete(ID id);




}
