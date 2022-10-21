package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Waiters;
import za.ac.cput.service.impl.WaiterServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("Waiters")
@Slf4j
public class WaiterController {

    private final WaiterServiceImpl waiterService;

    @Autowired
    public WaiterController(WaiterServiceImpl waiterService)
    {this.waiterService = waiterService;}


    @PostMapping("save")
    public ResponseEntity<Waiters> save(@Valid @RequestBody Waiters waiters) {
        return ResponseEntity.ok
                (this.waiterService.save(waiters));
    }

    @GetMapping("read/{type}")
    public ResponseEntity<Waiters> read(@PathVariable String StaffID) {
        Waiters read = this.waiterService.getStaffID(StaffID);
        return ResponseEntity.ok(read);
    }

    @DeleteMapping("delete/{type}")
    public ResponseEntity<Void> deleteWaiterByWaiterID(@PathVariable String StaffID)
    {
        this.waiterService.deleteWaiterByWaiterID(StaffID);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("all")
    public ResponseEntity<List<Waiters>> findAll() {
        List<Waiters> waiters = this.waiterService.findAll();
        return ResponseEntity.ok(waiters);
    }



}


