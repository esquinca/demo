package com.example.exercises;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class StringCombination {

	public static void main(String[] args) {
		String[] planets = {"Mercury", "Venus", "Mars"};
		
		String combinedString = String.join(", ", planets);
		System.out.println("Planets: " + combinedString);
		
		
		LocalDate localDate = LocalDate.now();
		LocalTime now = LocalTime.now();
		LocalDateTime now2 = LocalDateTime.now();
		
		System.out.println(now2);
		
	}

}
