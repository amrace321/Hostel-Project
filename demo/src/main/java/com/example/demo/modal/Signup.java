package com.example.demo.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Signup {
	private int id;
	@NotNull
	@Size(min=2, max=30)
	private String firstName;
	@NotNull
	@Size(min=2, max=30)
	private String lastName;
	@NotNull
	@Size(min=2, max=30)
	private String userName;
	@NotNull
	@Size(min=7, max=14)
	private String contact;
	
	private String email;
	private String password;
	private String confirmPassword;


}
