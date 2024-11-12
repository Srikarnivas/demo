package com.example.demo.controller;

import com.example.demo.model.Users;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Users> login(@RequestParam String username, @RequestParam String password) {
        Users user = userService.login(username, password);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/{userId}/renew")
    public ResponseEntity<Users> renewPolicy(@PathVariable Long userId) {
        Users updatedUser = userService.renewPolicy(userId);
        return ResponseEntity.ok(updatedUser);
    }
}

