package mate.academy.security;

import mate.academy.model.User;

public interface AuthenticationManager {
    User authenticate(Token token);
}
