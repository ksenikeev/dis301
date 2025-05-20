package ru.itis.dis301.market.localsystem.restapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.dis301.market.dto.DeliveryDto;

@RestController
@RequestMapping("/local/delivery")
public class LocalDeliveryRestController {

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryDto addNewDelivery(@RequestBody DeliveryDto delivery) {
        return delivery;
    }

    /**
     * Подтверждение факта доставки заказчику (отправляет центральная площадка)
     * @param delivery
     */
    @PutMapping("/confirm")
    @ResponseStatus(HttpStatus.OK)
    public void confirmDelivery(@RequestBody DeliveryDto delivery) {

    }
}
