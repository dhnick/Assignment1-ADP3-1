package za.ac.cput.service;
/* Tables.Java
 *  Entity for Tables
 *  Author: Chulumanco Buhle Nkwindana (219390983)
 * */
import com.mysql.cj.xdevapi.Table;
import za.ac.cput.domain.Tables;
import za.ac.cput.repository.TableRepository;

import java.util.List;
import java.util.Optional;

public class TableService implements ITableService{
    private final TableRepository repository;
    private static ITableService SERVICE ;

    private TableService() {this.repository = TableRepository.getRepository();}

    public static ITableService getService() {
        if ( SERVICE == null)
            SERVICE = new TableService();
        return SERVICE;
    }

    @Override
    public Tables save(Tables tables) {
        return this.repository.create(tables);
    }

    @Override
    public Optional<Tables> read(String s) {
        return Optional.ofNullable(this.repository.read(s));
    }

    @Override
    public void delete(Tables tables) {
        this.repository.delete(String.valueOf(tables));

    }

    @Override
    public List<Tables> getAll() {
        return (List<Tables>) this.repository.getAll();
    }

    @Override
    public List<Tables> findByTableId(String tableID) {
        return this.repository.findByTableId(tableID);
    }

    @Override
    public void deleteById(String id) {
        Optional<Tables> tables = read(id);
        if(tables.isPresent()){
            delete(tables.get());
        }

    }



    }
