package ru.itis.dis301.market.localsystem.restapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.dis301.market.dto.PaymentDto;

@RestController
@RequestMapping("/local/payment")
public class LocalPaymentRestController {

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentDto addNewPayment(@RequestBody PaymentDto payment) {
        return payment;
    }
}
