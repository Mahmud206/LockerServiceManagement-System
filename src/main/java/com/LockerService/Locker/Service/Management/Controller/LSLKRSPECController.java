package com.LockerService.Locker.Service.Management.Controller;

import com.LockerService.Locker.Service.Management.DTO.LSLKRSPECDto;
import com.LockerService.Locker.Service.Management.Service.LSLKRSPECService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
