package za.ac.cput.Repository;

public interface IRepository <C, ID>{
    C create(C c);
    C read(ID id);
    C update(C c);
    void Delete(ID id);


}
