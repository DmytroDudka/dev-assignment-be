package com.transferz.service.impl;


import com.transferz.dao.Airport;
import com.transferz.dto.AirportDto;
import com.transferz.repository.AirportRepository;
import com.transferz.repository.specification.AirportSpecification;
import com.transferz.service.IAirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AirportService implements IAirportService {

    private final AirportRepository airportRepository;

    @Transactional
    @Override
    public Airport create(AirportDto dto) {
        return airportRepository.save(new Airport(dto));
    }

    @Override
    public Page<Airport> getPaginatedAirports(Pageable pageable, Map<String, String> parameters) {
        return airportRepository.findAll(AirportSpecification.filterAirport(parameters), pageable);
    }
}
