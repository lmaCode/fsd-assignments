package com.lipengwei.fsd.controller;

import com.lipengwei.fsd.entity.TUser;
import com.lipengwei.fsd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<TUser> findByEmail(@PathVariable(name = "email", required=true) String email){
        TUser tUser = userService.findByEmail(email);
        return ResponseEntity.ok(tUser);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody TUser tUser){
        userService.save(tUser);
        return ResponseEntity.ok().build();
    }
}
