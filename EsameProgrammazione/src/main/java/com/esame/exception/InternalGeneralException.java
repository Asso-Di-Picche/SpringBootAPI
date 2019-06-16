package com.esame.exception;

/** Rappresenta un'eccezzione personalizzata di tipo Exception.
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/index.html?java/lang/Exception.html">Exception</a>
 * @author Marco Sebastianelli
 * @author Cristian Vitali
*/

public class InternalGeneralException extends Exception {

	public InternalGeneralException() {
		super();
	}

	public InternalGeneralException(String message) {
		super(message);
	}
}

