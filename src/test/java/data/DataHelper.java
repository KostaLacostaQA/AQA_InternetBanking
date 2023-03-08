package data;

import com.github.javafaker.Faker;
import lombok.Value;

public class DataHelper {

    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo insertAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getInvalidAuthInfo() {
        Faker faker = new Faker();
        return new AuthInfo(faker.name().username(), faker.internet().password());
    }
}

