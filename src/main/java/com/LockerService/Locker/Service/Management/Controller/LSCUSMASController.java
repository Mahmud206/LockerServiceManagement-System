//package com.LockerService.Locker.Service.Management.Controller;
//
//import com.LockerService.Locker.Service.Management.DTO.LSCUSMASDto;
//import com.LockerService.Locker.Service.Management.Service.LSCUSMASService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//@RequestMapping("/api/LSM/CUSMAS")
//public class LSCUSMASController {
//
//    @Autowired
//    private LSCUSMASService lscusmasService;
//
//    @GetMapping("/{CUSCOD}")
//    public ResponseEntity<LSCUSMASDto> getCustomerMasterInfoByCuscod(@PathVariable(name = "CUSCOD") String CUSCOD){
//        return ResponseEntity.ok(lscusmasService.getCustomerInfoByCuscod(CUSCOD));
//
//    }
//}
