package com.LockerService.Locker.Service.Management.Repository;

import com.LockerService.Locker.Service.Management.Entity.LSDRWRALLOCATEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LSDRWRALLOCATRepo extends JpaRepository<LSDRWRALLOCATEntity,Long> {

    LSDRWRALLOCATEntity findByACTNUM(String ACTNUM);
}
