package com.LockerService.Locker.Service.Management.Controller;

import com.LockerService.Locker.Service.Management.DTO.LSDRWRALLOCATDto;
import com.LockerService.Locker.Service.Management.ResponsiveModel.CommonResponseModel;
import com.LockerService.Locker.Service.Management.Service.LSDRWRALLOCATService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
/*
    @PostMapping("/Allocate")
    public ResponseEntity<LSDRWRALLOCATDto> createDrawerAllocation(@RequestBody LSDRWRALLOCATDto lsdrwrallocatDto){
        return new ResponseEntity<>(lsdrwrallocatService.createDrawerAllocation(lsdrwrallocatDto), HttpStatus.CREATED);
    }
*/
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/Allocate")
    public CommonResponseModel addLocation(@RequestBody LSDRWRALLOCATDto lsdrwrallocatDto) {
        return lsdrwrallocatService.createDrawerAllocation(lsdrwrallocatDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{ACTNUM}")
    public ResponseEntity<LSDRWRALLOCATDto> updateDrawerAllocation(@RequestBody LSDRWRALLOCATDto lsdrwrallocatDto, @PathVariable(name = "ACTNUM") String ACTNUM) {
        LSDRWRALLOCATDto lsdrwrrelResponse = lsdrwrallocatService.updateDrawerAllocation(lsdrwrallocatDto, ACTNUM);
        return new ResponseEntity<>(lsdrwrrelResponse, HttpStatus.OK);
    }
/*    @DeleteMapping("/{ACTNUM}")
    public ResponseEntity<String> deleteLSDRWRALLOCATLById(@PathVariable(name="ACTNUM") String ACTNUM){
        lsdrwrallocatService.deleteLSDRWRALLOCATById(ACTNUM);
        return new ResponseEntity<>("Locker entity deleted successfully.", HttpStatus.OK);
    }*/

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{ALLOCATID}")
    private CommonResponseModel deleteLSDRWRALLOCATLById(@PathVariable(name="ALLOCATID") long ALLOCATID){
        return lsdrwrallocatService.deleteLSDRWRALLOCATById(ALLOCATID);
    }

}
