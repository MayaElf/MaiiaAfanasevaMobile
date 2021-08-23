package properties;

import entity.User;

public class UserProperties {
    private static final String USERNAME = "Ivan";
    private static final String EMAIL = "ivan@mail.ru";
    private static final String PASSWORD = "qwerty123";

    public User getUser() {
        return new User(EMAIL, USERNAME, PASSWORD);
    }
}
