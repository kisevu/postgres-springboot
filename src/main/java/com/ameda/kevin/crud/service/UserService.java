package com.ameda.kevin.crud.service;

import com.ameda.kevin.crud.dto.UserModel;
import com.ameda.kevin.crud.entity.User;
import com.ameda.kevin.crud.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public User  createUser(UserModel model) {
        var user = User.builder()
                .name(model.getName())
                .age(model.getAge())
                .county(model.getCounty())
                .gender(model.getGender())
                .build();
        return userRepository.save(user);
    }

    public User  getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }
}
