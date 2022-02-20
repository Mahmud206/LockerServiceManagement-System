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

    @PostMapping("/Allocate")
    public ResponseEntity<LSDRWRALLOCATLDto> createDrawerAllocation(@RequestBody LSDRWRALLOCATLDto lsdrwrallocatDto){
        return new ResponseEntity<>(lsdrwrrelService.createDrawerAllocation(lsdrwrallocatDto), HttpStatus.CREATED);
    }

    @PutMapping("/{ACTNUM}")
    public ResponseEntity<LSDRWRALLOCATLDto> updateDrawerAllocation(@RequestBody LSDRWRALLOCATLDto lsdrwrallocatDto, @PathVariable(name = "ACTNUM") String ACTNUM){
        LSDRWRALLOCATLDto lsdrwrrelResponse = lsdrwrrelService.updateDrawerAllocation(lsdrwrallocatDto, ACTNUM);
        return new ResponseEntity<>(lsdrwrrelResponse, HttpStatus.OK);
    }
    @DeleteMapping("/{ACTNUM}")
    public ResponseEntity<String> deleteLSDRWRALLOCATLById(@PathVariable(name="ACTNUM") String ACTNUM){
        lsdrwrrelService.deleteLSDRWRALLOCATLById(ACTNUM);
        return new ResponseEntity<>("Locker entity deleted successfully.", HttpStatus.OK);
    }


}
