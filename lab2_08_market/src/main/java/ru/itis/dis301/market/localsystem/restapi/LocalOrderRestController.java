package ru.itis.dis301.market.localsystem.restapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.dis301.market.dto.OrderDto;

@RestController
@RequestMapping("/local/order")
public class LocalOrderRestController {

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto addNewOrder(@RequestBody OrderDto order) {
        return order;
    }

    @PutMapping("/put")
    public void editOrder(@RequestBody OrderDto order) {

    }

    /**
     * Предназначен только для смены статуса
     * @param status
     */
    @PatchMapping("/patch/{orderUID}")
    public void setOrderStatus(@RequestParam Long status) {

    }

}
