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

public class CarDTO {

	private long carId;
	private String carName;
	private String description;
	private Date createDate;
	private int status;
	private String statusTxt;
	
	//Team
	private long teamId;
	private String teamName;
	private String avatar;
	
	//CarType
	private int carTypeId;
	private String name;
}
