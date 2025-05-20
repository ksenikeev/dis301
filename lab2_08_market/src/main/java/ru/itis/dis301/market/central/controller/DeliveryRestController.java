package ru.itis.dis301.market.central.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.dis301.market.dto.DeliveryDto;

@RestController
@RequestMapping("/central/delivery")
public class DeliveryRestController {

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryDto addNewDelivery(@RequestBody DeliveryDto delivery) {
        return delivery;
    }

    /**
     * Подтверждение факта доставки заказчику (отправляет только заказчик)
     * @param delivery
     */
    @PutMapping("/confirm")
    @ResponseStatus(HttpStatus.OK)
    public void confirmDelivery(@RequestBody DeliveryDto delivery) {

    }
}
