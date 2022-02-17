package com.LockerService.Locker.Service.Management.Repository;

import com.LockerService.Locker.Service.Management.Entity.LSROLEEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LSROLERepo extends JpaRepository<LSROLEEntity, Long> {
    Optional<LSROLEEntity> findByName(String name);
}
