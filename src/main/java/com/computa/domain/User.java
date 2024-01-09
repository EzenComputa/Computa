package com.computa.domain;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class User {

    @Id
    private String id;
    private String password;
    private String nickname;
    private String name;
    private String email;
    private String ssid;
    private String address;

    // isAdmin is a boolean and default is false
    @Column(columnDefinition = "boolean default 0")
    private boolean isAdmin;

    // registerDate's default value is the current date
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date registerDate;

    // Getters and setters...
}
