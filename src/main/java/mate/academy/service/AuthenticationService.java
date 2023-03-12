package mate.academy.service;

import javax.naming.AuthenticationException;
import mate.academy.model.User;

public interface AuthenticationService {
    User login(String login, String password) throws AuthenticationException;
}
