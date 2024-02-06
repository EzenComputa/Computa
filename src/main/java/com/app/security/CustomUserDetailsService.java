package com.app.security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.entity.Role;
import com.app.entity.User;
import com.app.persistence.UserRepository;

import java.util.Collection;
import java.util.stream.Collectors;

// When annotating CustomUserDetailsService with @Service, it tells Spring that this class is a bean
// and should be managed by the Spring container.
// In other words, when using @Autowired UserDetailsService in SpringSecurity.java, Spring's Dependency Injection
// can automatically wire the CustomUserDetailsService bean into the SpringSecurity class.
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(/*String email*/ String username) throws UsernameNotFoundException {
        // User user = userRepository.findByEmail(email);
        User user = userRepository.findByUsername(username);

        // if (user != null) {
        //     return new org.springframework.security.core.userdetails.User(user.getEmail(),
        //             user.getPassword(),
        //             mapRolesToAuthorities(user.getRoles()));
        // }else{
        //     throw new UsernameNotFoundException("Invalid username or password.");
        // }

        // only if using CustomUserDetails settings
        // if (user != null) {
        //     return new CustomUserDetails(user, mapRolesToAuthorities(user.getRoles()));
        // } else {
        //     throw new UsernameNotFoundException("Invalid username or password.");
        // }

        // if not using CustomUserDetails settings
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getUsername(),
                    user.getPassword(),
                    mapRolesToAuthorities(user.getRoles()));
        }else{
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }

    // mapRolesToAuthorities() method converts a collection of Role objects into a collection of GrantedAuthority objects.
    private Collection < ? extends GrantedAuthority> mapRolesToAuthorities(Collection <Role> roles) {

        // Starts a stream from the roles collection. A stream in Java is a sequence of elements that can be processed in parallel or sequentially.
        // Uses the map operation to transform each Role object in the stream into a SimpleGrantedAuthority object.
        // The SimpleGrantedAuthority class is a concrete implementation of GrantedAuthority interface provided by Spring Security.
        // It represents an authoriy granted to an authentication object. The role.getName() method is called to get the name of the
        // role, which is used as the authority for the SimpleGrantedAuthority object.
        Collection < ? extends GrantedAuthority> mapRoles = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName())) 
                .collect(Collectors.toList()); 
                // Collects the transformed objects into a list. Collectors.toList() method is a collector that 
                // accumulates the input elements into a new list.
        return mapRoles;
    }
}