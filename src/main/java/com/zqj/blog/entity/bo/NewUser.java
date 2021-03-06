package com.zqj.blog.entity.bo;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class NewUser {

    @NotEmpty(message = "user name is empty")
    @Pattern(regexp = "^[A-Za-z0-9]{3,12}$")
    private String userName;

    @NotEmpty(message = "password is empty")
    @Pattern(regexp = "^[A-Za-z0-9]{8,20}$")
    private String password;

    @Email(message = "wrong email format")
    private String email;

}
