package za.ac.cput.repository;

import za.ac.cput.domain.Tables;

import java.util.HashSet;
import java.util.Set;
//chulumano buhle Nkwinda
//219390983
//adp3
public class TableRepository implements ITablesRepository{

    private static TableRepository repository = null;
    private Set<Tables> tablesDB = new HashSet<Tables>();

    public static TableRepository getRepository(){
        if (repository == null){
            repository = new TableRepository();
        }
        return repository;
    }

    @Override
    public Tables create(Tables tables) {
        this.tablesDB.add(tables);
        return tables;
    }

    @Override
    public Tables read(String tableID) {

        for(Tables t : tablesDB){
            if(t.getTableID().equals(tableID)){
                return t;
            }
        }
       return  null;
    }

    @Override
    public Tables update(Tables tables) {
        Tables tables1 = read(tables.getTableID());
        if (tables != null){
            tablesDB.remove(tables1);
            tablesDB.add(tables);
            return tables;
        }
        return null;
    }

    @Override
    public void delete(String tableID) {

        Tables deleteTables = read(tableID);
        if (deleteTables == null){
            System.out.println("null");
        }
        tablesDB.remove(deleteTables);
        System.out.println("removed");

    }

    @Override
    public Set<Tables> getAll() {
        return tablesDB;
    }
}
