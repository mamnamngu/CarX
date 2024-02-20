package com.carx.entity.tournamentManagement;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

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

@Table(name = "Race")
public class Race implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "raceId")
	private long raceId;
	
	@Column(name = "startTime", nullable = false)
	private Date startTime;
	
	@Column(name = "endTime", nullable = false)
	private Date endTime;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "status", columnDefinition = "INT DEFAULT " + Constants.DEFAULT_STATUS, nullable = false)
	private int status;
	
	//RELATIONSHIP SETUP
	
	@ManyToOne(targetEntity = Round.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "roundId", referencedColumnName = "roundId", nullable = false)
	@JsonIgnore
	@ToString.Exclude
	private Round round;
	
	@ManyToOne(targetEntity = Umpire.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "umpireId", referencedColumnName = "umpireId", nullable = false)
	@JsonIgnore
	@ToString.Exclude
	private Umpire umpire;
	
	@ManyToOne(targetEntity = Map.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "mapId", referencedColumnName = "mapId", nullable = false)
	@JsonIgnore
	@ToString.Exclude
	private Map map;
	
	@OneToMany(targetEntity = CarInRace.class, mappedBy = "race")
	@JsonIgnore
	@ToString.Exclude
	private Collection<CarInRace> carInRaceList;
}
