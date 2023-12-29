package com.transferz.service.impl;


import com.transferz.dao.Flight;
import com.transferz.dao.Passenger;
import com.transferz.dto.PassengerDto;
import com.transferz.enums.FlightStatus;
import com.transferz.exception.FlightException;
import com.transferz.repository.FlightRepository;
import com.transferz.repository.PassengerRepository;
import com.transferz.service.IPassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PassengerService implements IPassengerService {

    @Value("${value.amountOfPassengerPerFlight}")
    private int amountOfPassengerPerFlight;

    private final PassengerRepository passengerRepository;

    private final FlightRepository flightRepository;


    @Transactional
    @Override
    public Passenger create(PassengerDto dto) {
        Flight flight = getActiveFlight();
        Passenger passenger = new Passenger();

        if (passengerRepository.getAllPassengersNamesPerFlight(flight.getCode())
                .contains(dto.getName())) {
            throw new FlightException(FlightException.ALREADY_REGISTERED);
        }

        flight.setPassengerCount(flight.getPassengerCount() + 1);
        flightRepository.save(flight);

        passenger.setName(dto.getName());
        passenger.setFlightCode(flight.getCode());

        return passengerRepository.save(passenger);
    }


    /**
     * Retrieving of active flight based on FIFO chain algorithm.
     *
     * @return activeFlight;
     */

    private Flight getActiveFlight() {
        Optional<Flight> availableFlight = flightRepository.getFirstFlightByStatus(FlightStatus.AVAILABLE.name());

        if (availableFlight.isPresent()) {
            if (availableFlight.get().getPassengerCount() < amountOfPassengerPerFlight) {
                return availableFlight.get();
            } else {
                updateFlightStatus(availableFlight.get(), FlightStatus.UNAVAILABLE);
            }
        }

        Optional<Flight> pendingFlight = flightRepository.getFirstFlightByStatus(FlightStatus.PENDING.name());

        if (pendingFlight.isPresent() && pendingFlight.get().getPassengerCount() < amountOfPassengerPerFlight) {
            return updateFlightStatus(pendingFlight.get(), FlightStatus.AVAILABLE);
        }

        throw new FlightException(FlightException.NOT_FOUND);
    }

    private Flight updateFlightStatus(Flight flight, FlightStatus status) {
        flight.setFlightStatus(status);
        return flightRepository.save(flight);
    }
}
