package za.ac.cput.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Managers;
import za.ac.cput.service.impl.ManagerServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("Managers")
@Slf4j
public class ManagerController {

    private final ManagerServiceImpl managerService;

    @Autowired
    public ManagerController(ManagerServiceImpl managerService)
    {this.managerService = managerService;}


    @PostMapping("save")
    public ResponseEntity<Managers> save(@Valid @RequestBody Managers managers) {
        return ResponseEntity.ok
                (this.managerService.save(managers));
    }

    @GetMapping("read/{type}")
    public ResponseEntity<Managers> read(@PathVariable String ManagerID) {
        Managers read = this.managerService.getManagerID(ManagerID);
        return ResponseEntity.ok(read);
    }

    @DeleteMapping("delete/{type}")
    public ResponseEntity<Void> deleteManagerByManagerID(@PathVariable String ManagerID)
    {
        this.managerService.deleteManagerByManagerID(ManagerID);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("all")
    public ResponseEntity<List<Managers>> findAll() {
        List<Managers> managers = this.managerService.findAll();
        return ResponseEntity.ok(managers);
    }



}
