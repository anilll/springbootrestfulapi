package com.freedom.financial.network.springbootrestapi.exceptions;

public class BusinessException extends BaseException {

    private static final long serialVersionUID = 3851422888009039664L;

    
    public BusinessException(String errorCode, Exception ex, String[] params) {
    	super(errorCode, ex, params);
    }
    
    public BusinessException(String errorCode, String message, Exception ex) {
    	super(errorCode, message, ex);
    }

    public BusinessException(String errorCode, String message) {
        super(errorCode, message, null);
    }

    public BusinessException(String errorCode, String[] params) {
        super(errorCode, null, params);
    } 
    
    public BusinessException(String errorCode,  Exception ex) {
        super(errorCode, ex, null);
    }
}
