package main.java.by.makavchik.model;

public class UserNew {
    private String login;
    private byte [] password;

    public UserNew( String login, byte[] password) {

        this.login = login;
        this.password = password;
    }

    public UserNew() {
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }



    public String getLogin() {
        return login;
    }

    public byte[] getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserNew{" +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
