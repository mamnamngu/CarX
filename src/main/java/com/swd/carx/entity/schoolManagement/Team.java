package com.swd.carx.entity.schoolManagement;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.swd.carx.entity.tournamentManagement.Car;
import com.swd.carx.entity.tournamentManagement.CarInRace;
import com.swd.carx.entity.tournamentManagement.Member;
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

@Table(name = "Team")
public class Team implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "teamId")
	private long teamId;
	
	@Column(name = "teamName", columnDefinition = "NVARCHAR(" + Constants.NVARCHAR_DEFAULT_LENGTH + ")", nullable = false)
	private String teamName;
	
	@Column(name = "avatar", columnDefinition = "NVARCHAR(300) DEFAULT '" + com.swd.carx.utilities.Constants.DEFAULT_AVATAR + "'", nullable = false)
	private String avatar;
	
	@Column(name = "description", columnDefinition = "NVARCHAR(" + Constants.NVACHAR_MAX_LENGTH + ")", nullable = true)
	private String description;
	
	@Column(name = "status", columnDefinition = "INT DEFAULT " + Constants.DEFAULT_STATUS, nullable = false)
	private int status;
	
	//RELATIONSHIP SETUP
	
	@ManyToOne(targetEntity = SchoolTour.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "schoolTourId", referencedColumnName = "schoolTourId", nullable = false)
	@JsonIgnore
	@ToString.Exclude
	private SchoolTour schoolTour;

	@OneToMany(targetEntity = Car.class, mappedBy = "team")
	@JsonIgnore
	@ToString.Exclude
	private Collection<Car> carList;
	
	@OneToMany(targetEntity = CarInRace.class, mappedBy = "team")
	@JsonIgnore
	@ToString.Exclude
	private Collection<CarInRace> carInRaceList;
	
	@OneToMany(targetEntity = Member.class, mappedBy = "team")
	@JsonIgnore
	@ToString.Exclude
	private Collection<Member> memberList;
}
