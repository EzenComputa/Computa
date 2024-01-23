package com.computa.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto
{
    private Long id;

    @NotEmpty
    private String name;

    // @NotEmpty
    // private String firstName;
    
    // @NotEmpty
    // private String lastName;

    @NotEmpty(message = "Username should not be empty")
    private String username;

    @NotEmpty(message = "Nickname should not be empty")
    private String nickname;
    
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;
    
    @NotEmpty(message = "Phone number should not be empty")
    @Pattern(regexp="^[0-9]{11}$",message = "Must be 11 digits")
    private String phone;

    @NotEmpty(message = "Password should not be empty")
    private String password;

    @NotEmpty(message = "ssid should not be empty")
    @Pattern(regexp="^[0-9]{6}$",message = "Must be 6 digits")
    private String firstSsid;

    @NotEmpty(message = "ssid should not be empty")
    @Pattern(regexp="^[0-9]{7}$",message = "Must be 7 digits")
    private String secondSsid;
}