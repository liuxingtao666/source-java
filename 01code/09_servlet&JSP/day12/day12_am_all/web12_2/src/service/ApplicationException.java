package service;

public class ApplicationException extends Exception{
	//´íÎó´úÂë
	private String errorCode;

	public ApplicationException() {
	}

	public ApplicationException(String arg0) {
		errorCode = arg0;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
}
