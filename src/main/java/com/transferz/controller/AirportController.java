package com.transferz.controller;

import com.transferz.dao.Airport;
import com.transferz.dto.AirportDto;
import com.transferz.service.IAirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("airport")
@RequiredArgsConstructor
public class AirportController {

    private final IAirportService airportService;

    @PostMapping("/create")
    public Airport create(@Valid @RequestBody AirportDto airportDto) {
        return airportService.create(airportDto);
    }

    @GetMapping("/all")
    public Page<Airport> getAllPaginatedAirports(@RequestParam(defaultValue = "0", required = false) int pageNumber,
                                                 @RequestParam(defaultValue = "10", required = false) int pageSize,
                                                 @RequestBody(required = false) Map<String, String> parameters) {

        return airportService.getPaginatedAirports(PageRequest.of(pageNumber, pageSize), parameters);
    }
}
