package mate.academy.security;

import mate.academy.model.User;

public interface AuthenticationProvider {
    User authenticate(Token token);

    boolean isSupporting(Class<? extends Token>[] classes);
}
