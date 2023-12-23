package com.ameda.kevin.crud.service;

import com.ameda.kevin.crud.dto.UserModel;
import com.ameda.kevin.crud.entity.User;
import com.ameda.kevin.crud.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Thread.sleep;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    @CacheEvict(value = "users", allEntries = true)
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
    @Cacheable(value = "users")
    public List<User> getAllUsers() throws InterruptedException {
        sleep(1);
        System.out.println("invoked and fetching entries...");
        return userRepository.findAll();
    }
}
