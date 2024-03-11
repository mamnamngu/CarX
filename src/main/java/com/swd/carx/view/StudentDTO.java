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
public class StudentDTO {

	private long studentId;
	private String name;
	private Date DOB;
	private boolean gender;
	private String phone;
	private String email;
	private String note;
	private int status;
	private String statusTxt;
	
	//School
	private int schoolId;
	private String schoolName;
	
}
