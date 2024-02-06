package com.app.serviceImpl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dto.UserDto;
import com.app.entity.Role;
import com.app.entity.User;
import com.app.persistence.RoleRepository;
import com.app.persistence.UserRepository;
import com.app.service.UserService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    // UserRepository is an interface that extends JpaRepository, which provides basic methods for performing
    // CRUD operations on User entities in the db.
    private UserRepository userRepository;  
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername());
        user.setNickname(userDto.getNickname());
        user.setPhone(userDto.getPhone());
        user.setEmail(userDto.getEmail());
        user.setSsid(userDto.getFirstSsid()+"-"+userDto.getSecondSsid());
        // encrypt the password using spring security
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Role role = roleRepository.findByName("ROLE_USER");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        // String[] str = user.getName().split(" ");
        String[] ssid = user.getSsid().split("-");
        // userDto.setFirstName(str[0]);
        // userDto.setLastName(str[1]);
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setUsername(user.getUsername());
        userDto.setNickname(user.getNickname());
        userDto.setFirstSsid(ssid[0]);
        userDto.setSecondSsid(ssid[1]);
        return userDto;
    }

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_USER");
        return roleRepository.save(role);
    }
}