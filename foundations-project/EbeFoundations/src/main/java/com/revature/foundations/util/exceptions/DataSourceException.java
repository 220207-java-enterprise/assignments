package com.revature.foundations.util.exceptions;

public class DataSourceException extends RuntimeException {

    public DataSourceException(Throwable cause) {
        super("An exception occurred while communicating with the datasource.", cause);
    }

    public DataSourceException(String message) {
        super(message);
    }

    public DataSourceException(String message, Throwable cause) {
        super(message, cause);
    }

}
