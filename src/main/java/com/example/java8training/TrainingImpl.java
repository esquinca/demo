/**
 * 
 */
package com.example.java8training;

/**
 * @author kuzhali.r
 *
 */
public class TrainingImpl implements TrainingInterface {

	@Override
	public void weclometoTraining(String trainingName) {
		System.out.println("Welcome to "+trainingName+" training");
	}

}
