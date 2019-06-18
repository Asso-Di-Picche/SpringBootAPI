package com.esame.exception;

/** Rappresenta un'eccezzione personalizzata di tipo ClassNotFoundException.
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/index.html?java/lang/ClassNotFoundException.html">ClassNotFoundException</a>
 * @author Marco Sebastianelli
 * @author Cristian Vitali
*/

public class StatsNotFoundException extends ClassNotFoundException{


	private static final long serialVersionUID = 4L;

	public StatsNotFoundException() {
		super();
	}

	public StatsNotFoundException(String message) {
		super(message);
	}
}
