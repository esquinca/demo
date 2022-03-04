/**
 * 
 */
package com.example.java8training;

import java.util.Optional;

/**
 * @author kuzhali.r
 *
 */
public class MethodReferenceImpl implements MethodReferenceInterface {

	@Override
	public void methodReferenceLearning(String refMode) {
		Optional.of(refMode).ifPresent(System.out::println);
	}

}
