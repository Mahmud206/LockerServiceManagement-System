package com.LockerService.Locker.Service.Management.Controller;

import com.LockerService.Locker.Service.Management.DTO.LSLKRSPECDto;
import com.LockerService.Locker.Service.Management.Service.LSLKRSPECService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/LSM/Locker")
public class LSLKRSPECController {

    @Autowired
    private LSLKRSPECService lslkrspecService;


    @GetMapping("/Get")
    public List<LSLKRSPECDto> GetAllLocker(){
        return lslkrspecService.GetAllLockerInfo();
    }

    @GetMapping("/{LCKRID}")
    public ResponseEntity<LSLKRSPECDto> getLockerSpecificationInfoById(@PathVariable(name = "LCKRID") long LCKRID){
        return ResponseEntity.ok(lslkrspecService.getLockerSpecificationById(LCKRID));

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{LCKRID}")
    public  ResponseEntity<LSLKRSPECDto> updatePost(@RequestBody LSLKRSPECDto lslkrspecDto, @PathVariable(name = "LCKRID") long LCKRID ){
        LSLKRSPECDto lslkrspecDtoResponse = lslkrspecService.updateLockerSpecificationById(lslkrspecDto,LCKRID);
        return new ResponseEntity<>(lslkrspecDtoResponse, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{LCKRID}")
    public ResponseEntity<String> deleteDrawerRelease(@PathVariable(name = "LCKRID") long LCKRID){

        lslkrspecService.deleteLockerSpecificationById(LCKRID);

        return new ResponseEntity<>("Drawer Release  successfully.", HttpStatus.OK);
    }
}
