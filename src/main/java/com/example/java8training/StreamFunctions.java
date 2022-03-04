/**
 * 
 */
package com.example.java8training;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author kuzhali.r
 *
 */
public class StreamFunctions {
	
	public static void main (String[] args) {
		Map<Integer, User> userMap = new HashMap<Integer, User>();
		userMap.put(1, new User(1, "Janu", LocalDate.of(2001, 12, 12), "Female", "Graduate"));
		userMap.put(2, new User(2, "Renu", LocalDate.of(2005, 2, 22), "Female", "SSLC"));
		userMap.put(3, new User(3, "Meenu", LocalDate.of(1994, 3, 3), "Female", "Post Graduate"));
		userMap.put(4, new User(4, "Banu", LocalDate.of(2001, 6, 15), "Female", "Graduate"));
		userMap.put(5, new User(5, "Seenu", LocalDate.of(2001, 8, 31), "Male", "Graduate"));
		
		int start = 1;
		int end = 100;
		//Wrapper Streams
		IntStream.rangeClosed(start, end);
		//Stream.of("w", "s", "c");
		
		//Filter method with Predicate
		//streamFilter(userMap);
		
		//Map method with Function
	
		List<User> users = streamMapWithGroup(userMap);
		
		//forEach method with Consumer
		userMap.values().forEach(System.out::println);
		
		//Reduce Operation
		//streamReduce();
		
		//LocalDate with Sort
		if(users!=null && users.size()>0)
			System.out.println("Working");
		users.stream().sorted((u1, u2)->u1.getDateOfBirth().compareTo(u2.getDateOfBirth()));
		
		users.sort(Comparator.comparing(u->u.getDateOfBirth()));
		
		
		Collections.sort(users, Comparator.comparing(User::getDateOfBirth));
		
		Collections.sort(users, new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
			int var = 0;
			var = o1.getUserId()>o2.getUserId()?1:-1;
				return var;
			}
		});
		
		Collections.sort(users, (o1,o2)->{
			
			int var = 0;
			var = o1.getUserId()>o2.getUserId()?1:-1;
				return var;		
			});
		
		/*
		 * Collections.sort(users, new Comparator<User>() {
		 * 
		 * @Override public int compare(User u1, User u2) {
		 * if(u1.getDateOfBirth()==u2.getDateOfBirth()) return 0; return
		 * u1.getDateOfBirth().isAfter(u2.getDateOfBirth())?1:-1; } });
		 * //System.out.println(employees);
		 */		
	}

	/**
	 * @param userMap
	 * @return
	 */
	private static List<User> streamMapWithGroup(Map<Integer, User> userMap) {
		List<User> users = userMap.values().stream()
				//.sorted((u1,u2)->u1.getDateOfBirth().compareTo(u2.getDateOfBirth()))
				.collect(Collectors.toList());
				//.forEach(System.out::println);
		List<Employee> employeeList = new ArrayList<Employee>();
		
		Map<String, List<Employee>> employees = 
				userMap.values().stream()
				.map(user->employeeMapper(user)
		).collect(Collectors.groupingBy(Employee::getGender));
		
		
		System.out.println("HashMap Size: "+employees.size());
		
		employees.entrySet().stream().forEach(System.out::println);
		return users;
	}

	/**
	 * @param user
	 * @return
	 */
	private static Employee employeeMapper(User user) {
		Employee employee = new Employee(user.getUserName(), user.getGender(), user.getEducation());
		return employee;
	}

	/**
	 * @param userMap
	 */
	private static void streamFilter(Map<Integer, User> userMap) {
		Set<User> userList = userMap.values().stream().filter(u->u.getGender().equals("Female")).collect(Collectors.toSet());
		
		/*
		 * Map<String, List<User>> userNewMap =
		 * userMap.values().stream().collect(Collectors.groupingBy(User::getEducation));
		 * System.out.println(userNewMap.size());
		 */
		userList.forEach(System.out::println);
		
		/*
		 * for(User u: userMap.values()) { if(u.getGender().equals("Female"))
		 * userList.add(u); }
		 */
	}

	/**
	 * 
	 */
	private static void streamReduce() {
		List<String> numbers = Arrays.asList("1","2","3", "4", "5");
		String reducedString = numbers.stream().reduce("Start", (s1,s2)->s1.concat(s2));
		System.out.println(reducedString);
	}

}