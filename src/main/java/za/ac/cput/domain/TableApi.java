package za.ac.cput.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.service.ITableService;
/* TablesApi.java
 *  Entity for Tables
 *  Author: Chulumanco Buhle Nkwindana (219390983)
 *  Date: August 2022
 * */

@Component
public class TableApi {
    public final ITableService tableService;


    @Autowired
    public TableApi ( ITableService tableService){
        this.tableService = tableService;
    }

    public Tables save ( Tables table) {
        try {
            if (tableService.findByTableId(table.getTableID()) != null)
            {
                return tableService.save(table);
            }

            else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Table ID not found , kindly create and save a table");
            }

        } catch ( IllegalArgumentException ex ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Table ID not found , kindly  create a table ");
        }

    }
}

