package com.hacktiv8.loginapi.service;

import com.hacktiv8.loginapi.entity.User;
import com.hacktiv8.loginapi.model.RegisterUserRequest;
import com.hacktiv8.loginapi.repository.UserRepository;
import com.hacktiv8.loginapi.security.BCrypt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;


import java.util.Objects;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public void register(RegisterUserRequest request) {
        validationService.validate(request);

        if (userRepository.existsById(request.getKd_user())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Kode User sudah ada");
        }

        User user = new User();
        user.setKd_user(request.getKd_user());
        user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        user.setName(request.getName());

        userRepository.save(user);
    }

//    public UserResponse get(User user) {
//        return UserResponse.builder()
//                .username(user.getUsername())
//                .name(user.getName())
//                .build();
//    }
//
//    @Transactional
//    public UserResponse update(User user, UpdateUserRequest request) {
//        validationService.validate(request);
//
//        log.info("REQUEST : {}", request);
//
//        if (Objects.nonNull(request.getName())) {
//            user.setName(request.getName());
//        }
//
//        if (Objects.nonNull(request.getPassword())) {
//            user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
//        }
//
//        userRepository.save(user);
//
//        log.info("USER : {}", user.getName());
//
//        return UserResponse.builder()
//                .name(user.getName())
//                .username(user.getUsername())
//                .build();
//    }
}
