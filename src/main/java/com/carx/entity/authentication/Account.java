package com.carx.entity.authentication;

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

import com.carx.utilities.Constants;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Size;
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

@Table(name = "Account")
public class Account implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "accountId")
	private long accountId;
	
	@Column(name = "username", nullable = false, unique = true)
	@Size(min = Constants.USERNAME_MIN_LENGTH, message = "username must have at least 6 characters")
	private String username;
	
	@Column(name = "password", nullable = false)
	@Size(min = Constants.PASSWORD_MIN_LENGTH, message = "password must have at least 6 characters")
	private String password;
	
	@Column(name = "createDate", nullable = false)
	private Date createDate;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "status", columnDefinition = "INT DEFAULT " + Constants.DEFAULT_STATUS, nullable = false)
	private int status;
	
	//RELATIONSHIP SETUP
	
	@ManyToOne(targetEntity = Role.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "roleId", referencedColumnName = "roleId", nullable = false)
	@JsonIgnore
	@ToString.Exclude
	private Role role;
}
