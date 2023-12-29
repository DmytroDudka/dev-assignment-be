package com.transferz.dao;

import com.transferz.dto.AirportDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AIRPORT")
public class Airport extends BaseDao
{
	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "CODE", length = 20, nullable = false)
	private String code;

	@Column(name = "COUNTRY", length = 60, nullable = false)
	private String country;

	public Airport(AirportDto dto) {
		this.name = dto.getName();
		this.code = dto.getCode();
		this.country = dto.getCountry();
	}
}
