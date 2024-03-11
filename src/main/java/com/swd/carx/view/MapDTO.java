package com.swd.carx.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Data
public class MapDTO {
	
	private int mapId;
	private String mapName;
	private String description;
	private int status;
	private String statusTxt;
	
	//Map Type
	private int mapTypeId;
	private String typeName;
}
