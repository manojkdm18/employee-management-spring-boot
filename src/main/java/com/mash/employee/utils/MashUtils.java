/**
 * 
 */
package com.mash.employee.utils;

import java.util.Optional;


/**
 * @author manoj
 *
 */
public class MashUtils {


	public static boolean isNotEmpty(Object obj) {
		Optional<Object> opt = Optional.ofNullable(obj);
		if(opt.isPresent()) return true;
		return false;
	}
}
