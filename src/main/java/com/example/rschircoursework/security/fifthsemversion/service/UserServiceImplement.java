package com.example.rschircoursework.security.fifthsemversion.service;

import com.example.rschircoursework.exception.BadInputParametersException;
import com.example.rschircoursework.model.dao.IUserRepository;
import com.example.rschircoursework.model.entity.User;
import com.example.rschircoursework.model.enumerations.RoleType;
import com.example.rschircoursework.security.fifthsemversion.dto.UserRegisterRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Primary
public class UserServiceImplement implements UserService {
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${manager-token}")
    private String secretManagerToken;


    @Override
    public Optional<User> findUser(Long id) {
        var user =  userRepository.findById(id);
        if(user != null){
            return user;
        }
        throw new
                UsernameNotFoundException("User not exist with id :" +id);
    }

    @Override
    public String addNewUser(UserRegisterRequest registerRequest) {
        var first_check = userRepository.findUserByUsername(registerRequest.getName());
        var second_check = userRepository.findUserByEmail(registerRequest.getEmail());
        System.out.println(first_check);
        System.out.println(second_check);
        if (first_check == null && second_check.equals(Optional.empty())){
            RoleType role = defineUserRole(registerRequest.getManagerToken());
            User user = new User();
            user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
            user.setEmail(registerRequest.getEmail());
            user.setUsername(registerRequest.getName());
            user.setRole(role.name());
            userRepository.save(user);
            System.out.println(userRepository.findUserByUsername(registerRequest.getName()));
            return "OK";
        }
        else if (first_check != null && second_check.equals(Optional.empty())){
            return "NAME";
        }
        else if(first_check == null && !second_check.equals(Optional.empty())){
            return "EMAIL";
        }
        return "ERROR";
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user =  userRepository.findUserByUsername(username);
        System.out.println(user.getUsername());
        System.out.println(user.getRole());
        if(user != null){
            return user;
        }
        throw new
                UsernameNotFoundException("User not exist with name :" +username);
    }

    private RoleType defineUserRole(String managerToken) {
        if (managerToken == null) {
            return RoleType.USER;
        } else if (managerToken.equals(secretManagerToken)) {
            return RoleType.ADMIN;
        } else {
            throw new BadInputParametersException("Token is invalid");
        }
    }
}
