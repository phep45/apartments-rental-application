package pl.hal.ara.webapp.exception;

import java.util.Map;


public class InvalidUserDataException extends RuntimeException {

    private Map<String, String> errors;

    public InvalidUserDataException(Map<String, String> errors) {
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
