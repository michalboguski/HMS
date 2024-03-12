package pl.michalboguski.HMS.Security;

public final class RegisterDto {
    private final String username;
    private final String password;
    
    

    public RegisterDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
