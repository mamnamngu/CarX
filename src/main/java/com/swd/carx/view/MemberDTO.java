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
public class MemberDTO {

	private long memberId;
	private String note;
	private int status;
	private String statusTxt;
	
	//Student
	private long studentId;
	private String name;
		
	//Team
	private long teamId;
	private String teamName;
	private String avatar;
	
	//Tournament
	private long tournamentId;
	private String tournamentName;
	
}
