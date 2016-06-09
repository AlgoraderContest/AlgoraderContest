package de.inefficient.algoradercontest.server.core.validation;

import de.inefficient.algoradercontest.server.core.service.ACUserService;
import de.inefficient.algoradercontest.server.transport.request.ACRegisterUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static java.util.Arrays.stream;

/**
 * Created by samuel on 09.02.16.
 * @author samuel
 * @version 0.1
 */
@Component
public class ACRegisterUserRequestValidator implements Validator {
    /*
     * validation constants
     */
    private static final int MINIMAL_PASSWORD_LENGTH = 8;
    private static final String[] PASSWORD_COMPLEXITY_PATTERS = {".*[a-z]+.*", ".*[A-Z]+.*", ".*[0-9]+.*"};
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$";
    private static final String DEFAULT_ERROR_CODE = null;

    /*
     * message constants
     */
    private static final String USERNAME_EMPTY = "Der Username darf nicht leer sein!";
    private static final String USERNAME_IN_USE = "Dieser Username wird leider schon verwendet!";
    private static final String PASSWORD_EMPTY = "Das Passwort muss mindestens 8 Zeichen lang sein!";
    private static final String PASSWORD_TOO_WEAK = "Das Passwort muss Groß- und Keinbuchstaben, sowie Zahlen enthalten!";
    private static final String PASSWORDS_DO_NOT_MATCH = "Die Passwörter stimmen nicht überein!";
    private static final String EMAIL_EMPTY = "Die E-Mail darf nicht leer sein!";
    private static final String EMAIL_NOT_VALID = "Diese E-Mail ist nicht gültig!";

    /*
     * field constants
     */
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String PASSWORD2 = "password2";
    private static final String EMAIL = "email";

    @Autowired
    private ACUserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return ACRegisterUserRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ACRegisterUserRequest request = (ACRegisterUserRequest) target;
        validateUsername(request.getUsername(), errors);
        validatePassword(request.getPassword(), errors);
        validatePassword2(request.getPassword(), request.getPassword2(), errors);
        validateEmail(request.getEmail(), errors);
    }

    private void validateUsername(String username, Errors errors) {
        if (StringUtils.isEmpty(username)) {
            errors.rejectValue(USERNAME, DEFAULT_ERROR_CODE, USERNAME_EMPTY);
            return;
        }
        if (userService.getUserDetailsByUsername(username).isPresent()) {
            errors.rejectValue(USERNAME, DEFAULT_ERROR_CODE, USERNAME_IN_USE);
        }
    }

    private void validatePassword(String password, Errors errors) {
        if (StringUtils.isEmpty(password) || password.length() < MINIMAL_PASSWORD_LENGTH) {
            errors.rejectValue(PASSWORD, DEFAULT_ERROR_CODE, PASSWORD_EMPTY);
            return;
        }
        if (!stream(PASSWORD_COMPLEXITY_PATTERS).allMatch(pattern -> password.matches(pattern))) {
            errors.rejectValue(PASSWORD, DEFAULT_ERROR_CODE, PASSWORD_TOO_WEAK);
        }
    }

    private void validatePassword2(String password, String password2, Errors errors) {
        if (password != null && !password.equals(password2)) {
            errors.rejectValue(PASSWORD2, DEFAULT_ERROR_CODE, PASSWORDS_DO_NOT_MATCH);
        }
    }

    private void validateEmail(String email, Errors errors) {
        if (StringUtils.isEmpty(email)) {
            errors.rejectValue(EMAIL, DEFAULT_ERROR_CODE, EMAIL_EMPTY);
            return;
        }
        if (!email.matches(EMAIL_PATTERN)) {
            errors.rejectValue(EMAIL, DEFAULT_ERROR_CODE, EMAIL_NOT_VALID);
        }
    }
}
