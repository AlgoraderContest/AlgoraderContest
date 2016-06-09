package de.inefficient.algoradercontest.server.transport.response;

import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by samuel on 10.02.16.
 *
 * @author samuel
 * @version 0.1
 */
public class ACErrorResponse extends ACResponse {
    private Map<String, String> errors;

    public ACErrorResponse() {
        this(null, null);
    }

    public ACErrorResponse(String message) {
        this(message, null);
    }

    public ACErrorResponse(BindingResult result) {
        this(null, result);
    }

    public ACErrorResponse(String message, BindingResult result) {
        super(false, message);
        errors = new HashMap<>();
        if (result != null) {
            result.getFieldErrors().forEach(error -> addError(error.getField(), error.getDefaultMessage()));
            result.getGlobalErrors().forEach(error -> addError(error.getObjectName(), error.getDefaultMessage()));
        }
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public List<String> getErrorsAsList() {
        return new ArrayList<>(errors.values());
    }

    public boolean addError(String field, String message) {
        if (errors.containsKey(field)) {
            return false;
        }
        return errors.put(field, message) == null;
    }

    public boolean have(String field) {
        return errors.containsKey(field);
    }

    public String get(String field) {
        return errors.get(field);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }
}