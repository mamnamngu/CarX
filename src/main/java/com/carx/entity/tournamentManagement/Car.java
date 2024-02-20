package com.carx.entity.tournamentManagement;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.carx.entity.schoolManagement.Team;
import com.carx.utilities.Constants;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString

@Table(name = "Car")
public class Car implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carId")
	private long carId;
	
	@Column(name = "carName", nullable = false)
	private String carName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "createDate", nullable = false)
	private Date createDate;
	
	@Column(name = "status", columnDefinition = "INT DEFAULT " + Constants.DEFAULT_STATUS, nullable = false)
	private int status;
	
	//RELATIONSHIP SETUP
	
	@ManyToOne(targetEntity = CarType.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "carTypeId", referencedColumnName = "carTypeId", nullable = false)
	@JsonIgnore
	@ToString.Exclude
	private CarType carType;
	
	@ManyToOne(targetEntity = Team.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "teamId", referencedColumnName = "teamId", nullable = false)
	@JsonIgnore
	@ToString.Exclude
	private Team team;
}
