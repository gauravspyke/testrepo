package com.ksa.core.exception;

/**
 * 
 * @author GUR37729
 *
 */
public class CoreException extends Exception {

	private static final long serialVersionUID = 1L;
	private int statusCode;
    private Exception exception;
    private String exceptionMessage;

    public CoreException(Exception e) {
        super(e);
        exception = e;
    }

    public CoreException() {
    	//default exception
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }


    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    @Override
    public String getMessage() {
        if (exceptionMessage == null || exceptionMessage.equals("")) {
            return super.getMessage();
        }
        return getExceptionMessage();
    }
    /**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "CoreException [statusCode=" + statusCode + ", exception=" + exception + ", exceptionMessage="
				+ exceptionMessage + "]";
	}
}
