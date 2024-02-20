package com.carx.entity.schoolManagement;

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

import com.carx.entity.tournamentManagement.Member;
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

@Table(name = "Student")
public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "studentId")
	private long studentId;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "DOB", nullable = false)
	private Date DOB;
	
	@Column(name = "gender", nullable = false)
	private boolean gender;
	
	@Column(name = "phone", nullable = false)
	private String phone;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "status", columnDefinition = "INT DEFAULT " + Constants.DEFAULT_STATUS, nullable = false)
	private int status;
	
	//RELATIONSHIP SETUP
	@OneToMany(targetEntity = Member.class, mappedBy = "student")
	@JsonIgnore
	@ToString.Exclude
	private Collection<Member> memberList;
	
	@ManyToOne(targetEntity = School.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "schoolId", referencedColumnName = "schoolId", nullable = false)
	@JsonIgnore
	@ToString.Exclude
	private School school;
}
