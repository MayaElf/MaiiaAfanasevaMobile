package properties;

import entity.User;

import java.util.Locale;
import java.util.ResourceBundle;

public class UserProperties {
    private static String username;
    private static String email;
    private static String password;

    public UserProperties() {
        Locale locale = new Locale("en", "US");
        ResourceBundle rb = ResourceBundle.getBundle("nativeTest", locale);
        username = rb.getString("username");
        email = rb.getString("email");
        password = rb.getString("password");
    }

    public User getUser() {
        return new User(email, username, password);
    }
}
