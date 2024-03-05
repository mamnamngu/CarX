package com.swd.carx.entity.tournamentManagement;

import java.io.Serializable;
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
import com.swd.carx.entity.schoolManagement.Student;
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

@Table(name = "Member")
public class Member implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "memberId")
	private long memberId;
	
	@Column(name = "note", columnDefinition = "NVARCHAR(" + Constants.NVARCHAR_DEFAULT_LENGTH + ")", nullable = true)
	private String note;
	
	@Column(name = "status", columnDefinition = "INT DEFAULT " + Constants.DEFAULT_STATUS, nullable = false)
	private int status;
	
	//RELATIONSHIP SETUP
	
	@ManyToOne(targetEntity = Student.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "studentId", referencedColumnName = "studentId", nullable = false)
	@JsonIgnore
	@ToString.Exclude
	private Student student;
	
	@ManyToOne(targetEntity = Team.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "teamId", referencedColumnName = "teamId", nullable = false)
	@JsonIgnore
	@ToString.Exclude
	private Team team;
	
	@ManyToOne(targetEntity = Tournament.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "tournamentId", referencedColumnName = "tournamentId", nullable = false)
	@JsonIgnore
	@ToString.Exclude
	private Tournament tournament;
	
}
