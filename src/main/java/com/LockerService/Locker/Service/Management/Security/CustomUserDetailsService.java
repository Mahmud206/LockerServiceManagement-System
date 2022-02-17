package com.LockerService.Locker.Service.Management.Security;

import com.LockerService.Locker.Service.Management.Entity.LSROLEEntity;
import com.LockerService.Locker.Service.Management.Entity.LSUSEREntity;
import com.LockerService.Locker.Service.Management.Repository.LSUserRepo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private LSUserRepo lsUserRepo;

    public CustomUserDetailsService(LSUserRepo lsUserRepo) {
        this.lsUserRepo = lsUserRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        LSUSEREntity user = lsUserRepo.findByUserNameOrEmail(usernameOrEmail,usernameOrEmail)
                .orElseThrow(()->new UsernameNotFoundException("username not found with username or email:"+ usernameOrEmail));

        return new org.springframework.security.core.userdetails
                .User(user.getEmail(),user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection< ?extends GrantedAuthority> mapRolesToAuthorities(Set<LSROLEEntity> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
