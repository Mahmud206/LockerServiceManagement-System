package com.LockerService.Locker.Service.Management.Controller;

import com.LockerService.Locker.Service.Management.DTO.LSDRWRALLOCATDto;
import com.LockerService.Locker.Service.Management.DTO.LSDRWRRELDto;
import com.LockerService.Locker.Service.Management.Service.LSDRWRALLOCATService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/LSM/DrawerAllocate")
public class LSDRWRALLOCATController {

    @Autowired
    private LSDRWRALLOCATService lsdrwrallocatService;

    @GetMapping("/Get")
    public List<LSDRWRALLOCATDto> GetAllDrawerAllocate(){
        return lsdrwrallocatService.GetAllDrawerAllocateInfo();
    }

    @GetMapping("/{ACTNUM}")
    public ResponseEntity<LSDRWRALLOCATDto> getDrawerAllocateByAccountNumber(@PathVariable(name = "ACTNUM") String ACTNUM){
        return ResponseEntity.ok(lsdrwrallocatService.getDrawerAllocateByAccountNo(ACTNUM));
    }
}
