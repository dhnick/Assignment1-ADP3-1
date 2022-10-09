package za.ac.cput.domain;
/* TableController.Java
 *  Entity for Tables
 *  Author: Chulumanco Buhle Nkwindana (219390983)
 * */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.service.ITableService;
import za.ac.cput.service.TableService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("restaurant/table/")
@Slf4j
public class TableController {

    private final ITableService iTableService;

    @Autowired
    public TableController(TableService tableService) {this.iTableService = tableService;
    }

    @PostMapping("save")
    public ResponseEntity<Tables> save(@Valid @RequestBody Tables table){
        log.info("Save request: {}", table);
        Tables saved = iTableService.save(table);
        return ResponseEntity.ok(saved);}

    @GetMapping("read/{tableId}")
    public ResponseEntity<Tables> read(@PathVariable String tableId){
        Tables table = this.iTableService.read(tableId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Table not found"));
        return ResponseEntity.ok(table);}

    @DeleteMapping("delete/{tableId}")
    public ResponseEntity<Void> delete(@PathVariable String tableId)
    {
        log.info("Delete request: {}", tableId);
        this.iTableService.deleteById(tableId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("findAll")
    public ResponseEntity<List<Tables>> findAll(){
        List<Tables> tableList = this.iTableService.getAll();
        return ResponseEntity.ok(tableList);
    }


}
