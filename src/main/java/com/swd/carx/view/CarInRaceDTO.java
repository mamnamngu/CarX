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
public class CarInRaceDTO {

	private long carRaceId;
	private Date startTime;
	private Date endTime;
	private int bonus;
	private int penalty;
	private int score;
	private int racePosition;
	private int status;
	private String statusTxt;
	
	//Team
	private long teamId;
	private String teamName;
	private String avatar;
	
	//Race
	private long raceId;
	private String raceNote;
}
