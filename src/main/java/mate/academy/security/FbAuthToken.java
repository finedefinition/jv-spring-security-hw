package mate.academy.security;

public class FbAuthToken implements Token {
    private String authUrl;

    public FbAuthToken(String authUrl) {
        this.authUrl = authUrl;
    }

    @Override
    public String getCredentials() {
        return authUrl;
    }

    @Override
    public String getUsername() {
        return null;
    }
}
