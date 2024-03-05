package com.swd.carx.entity.tournamentManagement;

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

@Table(name = "MapType")
public class MapType implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mapTypeId")
	private int mapTypeId;
	
	@Column(name = "typeName", columnDefinition = "NVARCHAR(" + Constants.NVARCHAR_DEFAULT_LENGTH + ")", nullable = false)
	private String typeName;
	
	@Column(name = "description", columnDefinition = "NVARCHAR(" + Constants.NVACHAR_MAX_LENGTH + ")", nullable = true)
	private String description;
	
	@Column(name = "status", columnDefinition = "INT DEFAULT " + Constants.DEFAULT_STATUS, nullable = false)
	private int status;
	
	//RELATIONSHIP SETUP
	
	@OneToMany(targetEntity = Map.class, mappedBy = "mapType")
	@JsonIgnore
	@ToString.Exclude
	private Collection<Map> mapList;
	
	@ManyToOne(targetEntity = Tournament.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "tournamentId", referencedColumnName = "tournamentId", nullable = false)
	@JsonIgnore
	@ToString.Exclude
	private Tournament tournament;
}
