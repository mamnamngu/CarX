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
public class TeamDTO {

	private long teamId;
	private String teamName;
	private String avatar;
	private String description;
	private int status;
	private String statusTxt;
	
	//School Tour
	private long schooTourId;
	
	//School
	private int schoolId;
	private String schoolName;
	
	//Tournament
	private long tournamentId;
	private String tournamentName;
}
