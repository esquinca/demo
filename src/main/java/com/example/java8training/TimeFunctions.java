/**
 * 
 */
package com.example.java8training;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author kuzhali.r
 *
 */
public class TimeFunctions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LocalDate currentDate = LocalDate.now();
		LocalDate dob = LocalDate.of(2000, 10, 23);
		System.out.println("Compare: " +ChronoUnit.YEARS.between(currentDate, dob));
		
		LocalTime startTime = LocalTime.now(ZoneId.systemDefault());
		//LocalTime ss = LocalTime.now();
		
		LocalTime.now(Clock.systemUTC());
		//System.out.println(startTime);
		//LocalDate parsedDate = LocalDate.parse(startTime.toString(), DateTimeFormatter.ISO_DATE);
		//parsedDate.format(DateTimeFormatter.ISO_DATE);
		
		LocalTime endTime = LocalTime.MIDNIGHT.minusHours(11);
		System.out.println(endTime);
		
		timeStream(startTime, endTime);
		//timeStreamFor(startTime, endTime);
	}
	
	static void timeStream(LocalTime startTime, LocalTime endTime) {
	  List<Integer> hourList = Stream.iterate(startTime, h->h.plusMinutes(1))
	  .limit(ChronoUnit.MINUTES.between(startTime, endTime)+1)
	  
	  .map(LocalTime::getMinute).collect(Collectors.toList());
	  
	  
	  hourList.stream().forEach(t->System.out.println(t));
	  //.forEach(sec->System.out.println(sec));
	  
	  
	 //IntStream.range(1001, 1006).forEach(System.out::println);
	}

	static void timeStreamFor(LocalTime startTime, LocalTime endTime) {
	  for(LocalTime start1 = startTime;start1.isBefore(endTime); start1=start1.plusMinutes(1))
	  { 
		  System.out.println(start1); 
	  }
	}
}
