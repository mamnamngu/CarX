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

@Table(name = "CarType")
public class CarType implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carTypeId")
	private int carTypeId;
	
	@Column(name = "name", columnDefinition = "NVARCHAR(" + Constants.NVARCHAR_DEFAULT_LENGTH + ")", nullable = false)
	private String name;
	
	@Column(name = "description", columnDefinition = "NVARCHAR(" + Constants.NVACHAR_MAX_LENGTH + ")", nullable = true)
	private String description;
	
	@Column(name = "avatar", columnDefinition = "NVARCHAR(300) DEFAULT '" + com.swd.carx.utilities.Constants.DEFAULT_AVATAR + "'", nullable = false)
	private String avatar;
	
	@Column(name = "note", columnDefinition = "NVARCHAR(" + Constants.NVARCHAR_DEFAULT_LENGTH + ")", nullable = true)
	private String note;
	
	@Column(name = "status", columnDefinition = "INT DEFAULT " + Constants.DEFAULT_STATUS, nullable = false)
	private int status;
	
	//RELATIONSHIP SETUP
	
	@OneToMany(targetEntity = Car.class, mappedBy = "carType")
	@JsonIgnore
	@ToString.Exclude
	private Collection<Car> carList;	
}
