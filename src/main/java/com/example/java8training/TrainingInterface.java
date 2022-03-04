/**
 * 
 */
package com.example.java8training;

/**
 * @author kuzhali.r
 *
 */
@FunctionalInterface
public interface TrainingInterface {
	
	public void weclometoTraining(String trainingName);
	
	public static void validateTraining() {
		
	}
	
	public default void reviewTraining() {
		
	}
}
