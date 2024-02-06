package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="roles")
public class Role{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String name;

    // One user can have many roles. And a role can be assigned to many users. 
    // mappedBy="roles" attribute indicates that 'Role' entity is not responsible for handling the relationship. 
    // The 'User' entity, which has a 'roles' field, is responsible for the relationship.
    // This means that when you save a User (as in registering), JPA will take care of saving the associated
    // Role(s) in the database. 
    @ManyToMany(mappedBy="roles")  
    private List<User> users;
}