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
public class MapTypeDTO {

	private int mapTypeId;
	private String typeName;
	private String description;
	private int status;
	private String statusTxt;
	
	//Tournament
	private long tournamentId;
	private String tournamentName;
}
