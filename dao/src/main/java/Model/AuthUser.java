package Model;

public class AuthUser {
    private Long id;
    private String login;
    private String password;
    private ROLE role;

    public AuthUser(Long id, String login, String password, ROLE role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public AuthUser( String login, String password, ROLE role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public AuthUser() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }

    public enum ROLE {
        USER, ADMIN, UNKNOWN
    }


    @Override
    public String toString() {
        return "AuthUser{" + "id=" + id + ", login='" + login + '\'' + ", password='" + password + '\'' + ", role=" + role + '}';
    }
}
