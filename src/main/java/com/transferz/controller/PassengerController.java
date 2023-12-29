package com.transferz.controller;

import com.transferz.dao.Passenger;
import com.transferz.dto.PassengerDto;
import com.transferz.service.IPassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("passenger")
@RequiredArgsConstructor
public class PassengerController {

    private final IPassengerService passengerService;

    @PostMapping("/create")
    public Passenger getAllPaginatedFlights(@Valid @RequestBody PassengerDto passengerDto) {
        return passengerService.create(passengerDto);
    }

}
