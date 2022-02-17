package com.LockerService.Locker.Service.Management.Repository;

import com.LockerService.Locker.Service.Management.Entity.LSUSEREntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LSUserRepo extends JpaRepository<LSUSEREntity, Long> {

    Optional<LSUSEREntity> findByEmail(String email);

    Optional<LSUSEREntity> findByUserNameOrEmail(String username, String email);

    Optional<LSUSEREntity> findByUserName(String username);

    Boolean existsByUserName(String username);

    Boolean existsByEmail(String email);
}
