package com.transferz.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PASSENGER")
public class Passenger extends BaseDao {

	@Column(name = "NAME", length = 1024)
	private String name;

	@Column(name = "FLIGHT_CODE", length = 20)
	private String flightCode;

}
