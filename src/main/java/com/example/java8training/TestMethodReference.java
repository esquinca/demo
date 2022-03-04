/**
 * 
 */
package com.example.java8training;

import static java.lang.System.out;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author kuzhali.r
 *
 */
public class TestMethodReference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> methodRefModes = new ArrayList<String>();
		methodRefModes.add("Static");
		methodRefModes.add("Instance - Specific type");
		methodRefModes.add("Instance - arbitrary");
		methodRefModes.add("Constructor");
		
		//useStaticReference(methodRefModes);
		//useInstanceReference(methodRefModes);
		useConstructor(methodRefModes);
		//useArbitraryMethodRef(methodRefModes);
	}
	
	/**
	 * From Static method reference
	 * @param trainingList
	 */
	public static void useStaticReference(List<String> methodRefModes) {
		if(Objects.nonNull(methodRefModes)) {
			System.out.println("From Static method reference");
			/*
			 * for(String refMode: methodRefModes)
			 * MethodReferenceInterface.happyLearning(refMode);
			 */
			
			for(String input: methodRefModes)
				MethodReferenceInterface.happyLearning(input);
			
			methodRefModes.forEach(mode->{
				MethodReferenceInterface.happyLearning(mode);
			});

			
			methodRefModes.forEach(MethodReferenceInterface::happyLearning);
			
		}
	}
	
	/**
	 * From Instance method reference
	 * @param methodRefs
	 */
	public static void useInstanceReference(List<String> methodRefs) {
		System.out.println("From Instance method reference");
		MethodReferenceInterface methodRefInterface = new MethodReferenceImpl();
		
		User user = new User();
		//user.setUserName(methodRefs.get(0));
		
		methodRefs.forEach(user::setUserName);
		
		System.out.println(user.getUserName());
	}
	
	/**
	 * From Constructor method reference
	 * @param methodRefModes
	 */
	public static void useConstructor(List<String> methodRefModes) {
		System.out.println("From Constructor method reference");
		List<Training> trainings = methodRefModes.parallelStream().map(Training::new).collect(Collectors.toList());
		
		
		/*
		 * for(String mode: methodRefModes) { Training tr = new Training(mode);
		 * trainings.add(tr); }
		 */
		
		/*
		 * methodRefModes.forEach(ref->{ Training myTraining = new Training(ref);
		 * trainings.add(myTraining); });
		 */
		/*
		 * System.out.println(LocalTime.now()); IntStream.rangeClosed(1,
		 * 2000).parallel().forEach(out::println); System.out.println(LocalTime.now());
		 */
		
		
		  System.out.println(LocalTime.now()); IntStream.rangeClosed(1,
		  2000).forEach(out::println); System.out.println(LocalTime.now());
		 
		//stream.p
		//trainings.forEach(out::println);
	}
	
	public static void useArbitraryMethodRef(List<String> methodRefs) {
		String[] names = new String[] {"Java9", "JAVA8", "Java8", "vava11"};
		
		  Optional<String[]> strNames = Optional.of(names);
		  
		  if(strNames.isPresent()) 
			  strNames.get();
		  
		  
		  strNames.ifPresent(Arrays::asList);
		  
		  
		  strNames.ifPresent(arr->{
			  Arrays.asList(arr);  
		  });
		  
		  System.out.println(Optional.ofNullable(names).get());
		  //Employee employee = new Employee();
		  //System.out.println(employee.getUser().get());
		  
		  
		 // System.out.println("From Arbitrary method reference");
		 
		//Comparator<String> strComparator = String::compareTo;
		Comparator<String> strComparator = (s1, s2)->s1.compareTo(s2);
		//Collections.sort(Arrays.asList(names), strComparator);
		
		//Stream.of(names).forEach(System.out::println);
		
		List<String> trainings = Stream.of(names).sorted(strComparator).collect(Collectors.toList());
		
		Stream.of(names).forEach(System.out::println);
		
		Collections.sort(Arrays.asList(names), strComparator);
		
		System.out.println("After collections sort");
		Stream.of(names).forEach(System.out::println);
		
		/*
		 * System.out.println(Stream.of(names).filter(name->name.startsWith("Java")).
		 * count()); Stream<String> str =
		 * Stream.of(names).filter(name->name.startsWith("Java"));
		 * 
		 * //List<String> trainings1 =
		 * Stream.of(names).sorted((x,y)->x.compareTo(y)).collect(Collectors.toList());
		 * 
		 * trainings.forEach(out::println);
		 */
	}
}