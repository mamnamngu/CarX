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

@Table(name = "Round")
public class Round implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roundId")
	private long roundId;
	
	@Column(name = "startTime", nullable = false)
	private Date startTime;
	
	@Column(name = "endTime", nullable = false)
	private Date endTime;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "status", columnDefinition = "INT DEFAULT " + Constants.DEFAULT_STATUS, nullable = false)
	private int status;
	
	//RELATIONSHIP SETUP
	
	@OneToMany(targetEntity = Race.class, mappedBy = "round")
	@JsonIgnore
	@ToString.Exclude
	private Collection<Race> raceList;
	
	@ManyToOne(targetEntity = Tournament.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "tournamentId", referencedColumnName = "tournamentId", nullable = false)
	@JsonIgnore
	@ToString.Exclude
	private Tournament tournament;
}
