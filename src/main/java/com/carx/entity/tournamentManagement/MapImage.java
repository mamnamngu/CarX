package com.carx.entity.tournamentManagement;

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

@Table(name = "MapImage")
public class MapImage implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mapImageId")
	private long mapImageId;
	
	@Column(name = "link", nullable = false)
	private String link;
	
	@Column(name = "note")
	private String note;
	
	//RELATIONSHIP SETUP
	
	@ManyToOne(targetEntity = Map.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "mapId", referencedColumnName = "mapId", nullable = false)
	@JsonIgnore
	@ToString.Exclude
	private Map map;
}
