package mate.academy.security;

public class UsernamePasswordAuthToken implements Token {
    private String username;
    private String password;

    public UsernamePasswordAuthToken(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getCredentials() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
