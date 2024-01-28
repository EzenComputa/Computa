package com.computa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter  // if a var is called 'first_name', getter/setter will be 'getFirst_name'/'setFirst_name'
@Setter
@NoArgsConstructor // public User() {}
@AllArgsConstructor // public User(all field) {all field arguments}
@Entity
@Builder
@Table(name="users")
public class User{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String username;

    @Column(nullable=false, unique=true)
    private String nickname;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false)
    private String phone;

    @Column(nullable=false)
    private String password;

    @Column(nullable=false)
    private String ssid;

    // user report count
    @Column(nullable = false)
    private int reportcount;

    // fetch = FetchType.EAGER attribute means that when a User is loaded, JPA will also load its Roles. 
    // cascade = CascadeType.ALL attribute means that any changes made to the User will also be made to its Roles.
    // The @JoinTable annotation defines the table that will be used to manage the Many-To-Many relationship.
    // The name="users_roles" attribute specifies the name of this table.
    // The joinColumns attribute specifies the column in the user_roles table that represents Users and 
    // the inverseJoinColumns attribute specifies the column in the user_roles table that represents Roles.
    // The roles field is a List<Role>, which means that it can hold multiple Role objects. 
    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="users_roles",
            joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
    private List<Role> roles = new ArrayList<>();


    /* ----------------------------------------------------------------------------------- */

    
}