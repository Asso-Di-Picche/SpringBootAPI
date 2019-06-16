package com.esame.exception;

/** Rappresenta un'eccezzione personalizzata di tipo IllegalArgumentException.
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/index.html?java/lang/IllegalArgumentException.html">IllegalArgumentException</a>
 * @author Marco Sebastianelli
 * @author Cristian Vitali
*/

public class FilterIllegalArgumentException extends IllegalArgumentException{

	public FilterIllegalArgumentException() {
		super();
	}

	public FilterIllegalArgumentException(String message) {
		super(message);
	}
}
