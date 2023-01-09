package com.masai.app.Exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage 
{
	private LocalDateTime ldt;
	private String message;
	private String details;
}
