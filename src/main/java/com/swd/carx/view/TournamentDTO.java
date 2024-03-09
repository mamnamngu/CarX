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
public class TournamentDTO {

	private long tournamentId;
	private String tournamentName;
	private Date date;
	private int status;
	private String statusTxt;
	
	//School Year
	private int yearId;
	private int yearNo;
	
	//Location
	private int locationId;
	private String locationName;
}
