package com.LockerService.Locker.Service.Management.Utils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


public class PasswordEncoderGenerator {
    public static void main(String[] args){
        PasswordEncoder passwordEncoder =new BCryptPasswordEncoder();
       System.out.println(passwordEncoder.encode("123456"));
    }
}
