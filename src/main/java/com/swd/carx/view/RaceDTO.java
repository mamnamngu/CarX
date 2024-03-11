package com.swd.carx.view;

import java.util.Date;

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
public class RaceDTO {

	private long raceId;
	private Date startTime;
	private Date endTime;
	private String note;
	private int status;
	private String statusTxt;
	
	//Round
	private long roundId;
	private String roundNote;
	
	//Umpire
	private int umpireId;
	private String name;
	
	//Map
	private int mapId;
	private String mapName;
	
}
