package top.sob.auth.spring.bean;

import lombok.Data;

@Data
public class User {
    long id;

    String username;

    String password;

    Object type;
}
