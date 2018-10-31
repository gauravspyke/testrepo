package com.ksa.core.util;

/**
 * Opertator interface, purpose of this interface is to provide caclulate method
 * 
 * @version 1.0
 * @author Shashank.Agarwal
 * @since Jan 30, 2017 5:50:44 PM
 */
public interface Operator {

	/**
	 * This interface method is being used to do calculation for two operands
	 * 
	 * @param leftOperand
	 * @param rightOperand
	 * @return
	 */
	double calculate(double leftOperand, double rightOperand);

	/**
	 * This interface method is being used to do comparison of two operands
	 * 
	 * @param leftOperand
	 * @param rightOperand
	 * @return
	 */
	boolean compare(double leftOperand, double rightOperand);

}
