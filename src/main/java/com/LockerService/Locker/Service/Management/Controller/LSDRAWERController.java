package com.LockerService.Locker.Service.Management.Controller;

import com.LockerService.Locker.Service.Management.DTO.LSDRAWERDto;
import com.LockerService.Locker.Service.Management.Service.LSDRAWERService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/LSM/Drawer")
public class LSDRAWERController {

    @Autowired
    private LSDRAWERService lsdrawerService;

    @GetMapping("/Get")
    public List<LSDRAWERDto> GetAllDrawer(){
        return lsdrawerService.GetAllDrawerInfo();
    }
}
