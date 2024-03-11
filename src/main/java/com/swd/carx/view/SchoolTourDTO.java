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
public class SchoolTourDTO {

	private long schoolTourId;
	private String note;
	private int status;
	private String statusTxt;
	
	//Tournament
	private long tournamentId;
	private String tournamentName;
	
	//School
	private int schoolId;
	private String schoolName;
}
