package com.dhiraj.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CourseDto {

	private Long cid;

	@NotNull(message = "required")
	@NotBlank(message = "cannot be blank")
	private String name;

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

}
