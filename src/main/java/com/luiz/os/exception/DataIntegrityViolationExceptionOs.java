package com.luiz.os.exception;

public class DataIntegrityViolationExceptionOs extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DataIntegrityViolationExceptionOs(String message) {
        super(message);
    }

    public DataIntegrityViolationExceptionOs(String message, Throwable cause) {
        super(message, cause);
    }
}
