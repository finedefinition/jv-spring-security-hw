package mate.academy.security;

import mate.academy.model.User;

public class FbAuthProvider implements AuthenticationProvider {
    @Override
    public User authenticate(Token token) {
        return null;
    }

    @Override
    public boolean isSupporting(Class<? extends Token>[] classes) {
        for (Class<? extends Token> tokenClass : classes) {
            if (tokenClass.equals(FbAuthToken.class)) {
                return true;
            }
        }
        return false;
    }
}
