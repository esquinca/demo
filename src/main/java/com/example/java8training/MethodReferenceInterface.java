/**
 * 
 */
package com.example.java8training;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author kuzhali.r
 *
 */
@FunctionalInterface
public interface MethodReferenceInterface {
	
	public static void happyLearning(String refMode) {
		
		Function<String, String> function = s->s.toUpperCase();
		
		
		
		Function<String, Integer> intFn = Integer::parseInt;
		
		Integer myInt = intFn.apply(refMode);
		
		System.out.println(function.apply(refMode));
		
		
		
		  Consumer<String> consumer = System.out::println;
		  
		  
		  consumer.accept(refMode);
		 
	}
	
	public abstract void methodReferenceLearning(String refMode);
	
	//Java 7
	public default String toUpperCase(String input) {
		return input.toUpperCase();
	}
	
	public default void testMethod() {
		
	}
}
