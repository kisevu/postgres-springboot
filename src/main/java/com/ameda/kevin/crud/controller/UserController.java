package com.ameda.kevin.crud.controller;
import com.ameda.kevin.crud.dto.UserModel;
import com.ameda.kevin.crud.entity.User;
import com.ameda.kevin.crud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserModel model){
        User user = userService.createUser(model);
        if(user==null){
            return new ResponseEntity<>("user not created...",HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>("user created successfully...",HttpStatus.CREATED);
        }
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable("userId") Long userId){
        User user = userService.getUserById(userId);
        if(user==null){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() throws InterruptedException {
        return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
    }
    @GetMapping("/test")
    public ResponseEntity<?> success(){
        return new ResponseEntity<>("connection was successful",HttpStatus.OK);
    }
}
