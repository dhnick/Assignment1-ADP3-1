package za.ac.cput.domain;/*
Chulumanco Buhle Nkwindana 219390983
PaymentController.java
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.service.IPaymentService;
import za.ac.cput.service.PaymentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("restaurant/payment/")
@Slf4j
public class PaymentController {
    private final IPaymentService iPaymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {this.iPaymentService = paymentService;
    }

    @PostMapping("save")
    public ResponseEntity<Payments> save(@Valid @RequestBody Payments payment){
        log.info("Save request: {}", payment);
        Payments saved = iPaymentService.save(payment);
        return ResponseEntity.ok(saved);}

    @GetMapping("read/{paymentId}")
    public ResponseEntity<Payments> read(@PathVariable String paymentId){
        Payments payment = this.iPaymentService.read(paymentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment not found"));
        return ResponseEntity.ok(payment);}

    @DeleteMapping("delete/{paymentId}")
    public ResponseEntity<Void> delete(@PathVariable String paymentId)
    {
        log.info("Delete request: {}", paymentId);
        this.iPaymentService.deleteById(paymentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("findAll")
    public ResponseEntity<List<Payments>> findAll(){
        List<Payments> paymentList = this.iPaymentService.getAll();
        return ResponseEntity.ok(paymentList);
    }


}

