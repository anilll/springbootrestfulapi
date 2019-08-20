package com.freedom.financial.network.springbootrestapi.exceptions;

public abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = -7562185606641302357L;

    private String errorCode;

    private String defaultMessage;

    private String[] params;

    public BaseException(String errorCode, Exception ex, String[] params) {
        super(ex);
        this.errorCode = errorCode;
        this.params = params;
    }
    
    public BaseException(String errorCode, String message, Exception ex) {
        super(ex);
        this.errorCode = errorCode;
        this.defaultMessage = message;
    }

    @Override
    public String getMessage() {
        return defaultMessage;
    }

    public void setMessage(String message) {
        this.defaultMessage = message;
    }
    public String[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
