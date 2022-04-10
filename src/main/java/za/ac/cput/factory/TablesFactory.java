package za.ac.cput.factory;
import za.ac.cput.domain.Tables;

import java.util.UUID;
public class TablesFactory {
    public static Tables build(String tableStatus,int capacity,String tableType){
            String tableID= UUID.randomUUID().toString();

            return new Tables.TablesBuilder()
                    .setTableID(tableID)
                    .setTableStatus(tableStatus)
                    .setCapacity(capacity)
                    .setTableStatus(tableStatus).build();
    }
}
