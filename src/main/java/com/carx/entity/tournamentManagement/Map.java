package com.carx.entity.tournamentManagement;

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

@Table(name = "Map")
public class Map implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mapId")
	private int mapId;
	
	@Column(name = "mapName", nullable = false)
	private String mapName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "status", columnDefinition = "INT DEFAULT " + Constants.DEFAULT_STATUS, nullable = false)
	private int status;
	
	//RELATIONSHIP SETUP
	
	@OneToMany(targetEntity = Race.class, mappedBy = "map")
	@JsonIgnore
	@ToString.Exclude
	private Collection<Race> raceList;
	
	@OneToMany(targetEntity = MapImage.class, mappedBy = "map")
	@JsonIgnore
	@ToString.Exclude
	private Collection<MapImage> mapImageList;
	
	@ManyToOne(targetEntity = MapType.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "mapTypeId", referencedColumnName = "mapTypeId", nullable = false)
	@JsonIgnore
	@ToString.Exclude
	private MapType mapType;
}
