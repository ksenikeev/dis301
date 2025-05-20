package ru.itis.dis301.market.central.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.dis301.market.dto.OfferDto;
import java.util.List;
import java.util.UUID;

/**
 * Центральная площадка
 * Контроллер, обслуживающий предложение
 */
@RestController
@RequestMapping("/central/offer")
public class OfferRestController {

    @PostMapping(value = "/add", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public OfferDto saveNewOffer(@RequestBody OfferDto offer) {

        return offer;
    }

    @PutMapping("/put")
    @ResponseStatus(HttpStatus.OK)
    public void editOffer(@RequestBody OfferDto offer) {

    }

    /**
     * 1. Если не было движения (заказов), то просто удаляем
     * 2. Иначе обнуляем остатки
     */
    @DeleteMapping("/delete")
    public OfferDto deleteOffer(@RequestBody OfferDto offer) {

        return offer;
    }

    @GetMapping("/find/{offerUid}")
    public OfferDto findOfferByUid(@PathVariable UUID offerUid) {

        return null;
    }

    /**
     * Поиск предложения по товару (представленному категорией и именем)
     * @param category
     * @param name
     * @return
     */
    @GetMapping("/findbymerch")
    public List<OfferDto> findOfferByMerch(
            @RequestParam Long category,
            @RequestParam String name) {

        return null;
    }

    /**
     * Поиск предложений от определенной организации
     * @param name латинская транскрипция названия организации
     * @return
     */
    @GetMapping("/findbyorg")
    public List<OfferDto> findOfferByOrganizationName(
            @RequestParam String name) {

        return null;
    }
}
