package com.swd.carx.entity.tournamentManagement;

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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.swd.carx.entity.schoolManagement.Team;
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

@Table(name = "CarInRace")
public class CarInRace implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carRaceId")
	private long carRaceId;
	
	@Column(name = "startTime", nullable = true)
	private Date startTime;
	
	@Column(name = "endTime", nullable = true)
	private Date endTime;
	
	@Column(name = "bonus", columnDefinition = "INT DEFAULT 0", nullable = true)
	private int bonus;
	
	@Column(name = "penalty", columnDefinition = "INT DEFAULT 0", nullable = true)
	private int penalty;
	
	@Column(name = "score", nullable = true)
	@javax.validation.constraints.Size(min = Constants.SCORE_MIN, max = Constants.SCORE_MAX, message = "Scores must be whole numbers from 0 to 100")
	private int score;
	
	@Column(name = "racePosition", nullable = true)
	private int racePosition;
	
	@Column(name = "status", columnDefinition = "INT DEFAULT " + Constants.DEFAULT_STATUS, nullable = false)
	private int status;
	
	//RELATIONSHIP SETUP
	
	@ManyToOne(targetEntity = Team.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "teamId", referencedColumnName = "teamId", nullable = false)
	@JsonIgnore
	@ToString.Exclude
	private Team team;
	
	@ManyToOne(targetEntity = Race.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "raceId", referencedColumnName = "raceId", nullable = false)
	@JsonIgnore
	@ToString.Exclude
	private Race race;
}
