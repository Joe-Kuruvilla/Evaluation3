package com.masai.app.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User 
{
	@Id
	@GeneratedValue
	private int userId;
	@Pattern(regexp="^[A-Z][a-z]*", message="First Name must not contain numbers or special characters")
	private String firstname;
	@Pattern(regexp="^[A-Z][a-z]*", message="Last name Name must not contain numbers or special characters")
	private String lastname;
	@Min(10)
	@Max(10)
	private String mobileNumber;
	private String address;
	private String gender;
	@Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){6,12}$",
    message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
	private String password;
	@Min(8)
	private int age;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private List<Fir> fir=new ArrayList<>();
	
}
