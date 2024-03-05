package com.swd.carx.entity.tournamentManagement;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.swd.carx.entity.schoolManagement.SchoolTour;
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

@Table(name = "Tournament")
public class Tournament implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tournamentId")
	private long tournamentId;
	
	@Column(name = "tournamentName", columnDefinition = "NVARCHAR(" + Constants.NVARCHAR_DEFAULT_LENGTH + ")", nullable = false)
	private String tournamentName;
	
	@Column(name = "date", nullable = false)
	private Date date;
	
	@Column(name = "status", columnDefinition = "INT DEFAULT " + Constants.DEFAULT_STATUS, nullable = false)
	private int status;

	//RELATIONSHIP SETUP
	@ManyToOne(targetEntity = SchoolYear.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "yearId", referencedColumnName = "yearId", nullable = false)
	@JsonIgnore
	@ToString.Exclude
	private SchoolYear schoolYear;
	
	@ManyToOne(targetEntity = Location.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "locationId", referencedColumnName = "locationId", nullable = false)
	@JsonIgnore
	@ToString.Exclude
	private Location location;
	
	@OneToMany(targetEntity = SchoolTour.class, mappedBy = "tournament")
	@JsonIgnore
	@ToString.Exclude
	private Collection<SchoolTour> schoolTourList;
	
	@OneToMany(targetEntity = MapType.class, mappedBy = "tournament")
	@JsonIgnore
	@ToString.Exclude
	private Collection<MapType> mapTypeList;
	
	@OneToMany(targetEntity = Round.class, mappedBy = "tournament")
	@JsonIgnore
	@ToString.Exclude
	private Collection<Round> roundList;
	
	@OneToMany(targetEntity = Member.class, mappedBy = "tournament")
	@JsonIgnore
	@ToString.Exclude
	private Collection<Member> memberList;
}
