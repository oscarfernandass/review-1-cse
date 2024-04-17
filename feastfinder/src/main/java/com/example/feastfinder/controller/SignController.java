package com.example.feastfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.feastfinder.model.Signup;
import com.example.feastfinder.service.SignService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/sign")
public class SignController {

    @Autowired
    private SignService signService;

    @PostMapping("/signup")
    public String signUp(@RequestBody Signup signup) {
        Signup sign = signService.getUser(signup.getEmailId());
        if (sign == null) {
            signService.signup(signup);
            return "Signed up successfully";
        }
        return "EmailId already exists, please use another EmailId";
    }

    @GetMapping("/login")
    public String login(@RequestParam String emailId, @RequestParam String password) {
        Signup log = signService.loginCheck(emailId, password);
        if (log == null) {
            return "Invalid Email Id or password";
        }
        return "Login Successful";
    }
    @PutMapping("update/{username}")
    
    public String putMethodName(@PathVariable("username") String userName, @RequestBody String newPassword) {
        Signup updated=signService.update(userName, newPassword);
        if(updated==null){
            return "update invalid";
        }
        return "Update successfull";
    }
}
