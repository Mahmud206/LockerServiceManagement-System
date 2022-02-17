package com.LockerService.Locker.Service.Management.Controller;

import com.LockerService.Locker.Service.Management.DTO.JWTAUTHRESPONSEDto;
import com.LockerService.Locker.Service.Management.DTO.LOGINDto;
import com.LockerService.Locker.Service.Management.DTO.SIGNUPDto;
import com.LockerService.Locker.Service.Management.Entity.LSROLEEntity;
import com.LockerService.Locker.Service.Management.Entity.LSUSEREntity;
import com.LockerService.Locker.Service.Management.Repository.LSROLERepo;
import com.LockerService.Locker.Service.Management.Repository.LSUserRepo;
import com.LockerService.Locker.Service.Management.Security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class LSAUTHController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private LSUserRepo lsUserRepo;

    @Autowired
    private LSROLERepo lsroleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<JWTAUTHRESPONSEDto> authenticateUser(@RequestBody LOGINDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // get token form tokenProvider
        String token = tokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JWTAUTHRESPONSEDto(token));
    }

    @PostMapping("/signup")
    private ResponseEntity<?> registerUser(@RequestBody SIGNUPDto signupDto){

        //Add Check For User Name exist in DB or not
        if(lsUserRepo.existsByUserName(signupDto.getUsername())){
            return new ResponseEntity("User Name is Already Taken!",HttpStatus.BAD_REQUEST);
        }

        // add check for email exist in DB or not
        if(lsUserRepo.existsByEmail(signupDto.getEmail())){
            return new ResponseEntity<>("Email is already Taken!",HttpStatus.BAD_REQUEST);
        }

        LSUSEREntity user = new LSUSEREntity();
        user.setName(signupDto.getName());
        user.setUserName(signupDto.getUsername());
        user.setEmail(signupDto.getEmail());
        user.setPassword(passwordEncoder.encode(signupDto.getPassword()));


        LSROLEEntity roles = lsroleRepo.findByName("ROLE_USER").get();
        user.setRoles(Collections.singleton(roles));

        lsUserRepo.save(user);

        return new ResponseEntity<>("User Registered Successfully!",HttpStatus.OK);
    }
}
