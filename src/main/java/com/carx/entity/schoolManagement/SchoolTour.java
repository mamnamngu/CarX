package com.carx.entity.schoolManagement;

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

import com.carx.entity.tournamentManagement.Tournament;
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

@Table(name = "SchoolTour")
public class SchoolTour implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "schoolTourId")
	private long schoolTourId;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "status", columnDefinition = "INT DEFAULT " + Constants.DEFAULT_STATUS, nullable = false)
	private int status;
	
	//RELATIONSHIP SETUP
	
	@OneToMany(targetEntity = Team.class, mappedBy = "schoolTour")
	@JsonIgnore
	@ToString.Exclude
	private Collection<Team> teamList;
	
	@ManyToOne(targetEntity = School.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "schoolId", referencedColumnName = "schoolId", nullable = false)
	@JsonIgnore
	@ToString.Exclude
	private School school;
	
	@ManyToOne(targetEntity = Tournament.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "tournamentId", referencedColumnName = "tournamentId", nullable = false)
	@JsonIgnore
	@ToString.Exclude
	private Tournament tournament;
}
