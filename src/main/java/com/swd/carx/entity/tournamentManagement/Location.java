package com.swd.carx.entity.tournamentManagement;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.swd.carx.utilities.Constants;

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

@Table(name = "Location")
public class Location implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "locationId")
	private int locationId;
	
	@Column(name = "locationName", columnDefinition = "NVARCHAR(1000) DEFAULT " + Constants.DEFAULT_LOCATION, nullable = false)
	private String locationName;
	
	@Column(name = "description", columnDefinition = "NVARCHAR(" + Constants.NVACHAR_MAX_LENGTH + ")", nullable = true)
	private String description;
	
	@Column(name = "status", columnDefinition = "INT DEFAULT " + Constants.DEFAULT_STATUS, nullable = false)
	private int status;
	
	//RELATIONSHIP SETUP
	@OneToMany(targetEntity = Tournament.class, mappedBy = "location")
	@JsonIgnore
	@ToString.Exclude
	private Collection<Tournament> tournamentList;
}
