package com.tarena.dao;

/**
 *	自定义异常，用于封装DAO抛出的异常信息。
 *	我们在代码中捕获到异常后，将其封装成
 *	DaoException抛出，这样其他同事在调用我的
 *	方法时，就可以知道异常已经进行过处理，他
 *	不必再次处理异常。
 */
public class DaoException extends Exception {

	/**
	 * 实例化时，要求提供明确的异常信息，
	 * 以及原始的异常堆栈信息。
	 */
	public DaoException(
		String message, Throwable cause) {
		super(message, cause);
	}

}
