package com.LockerService.Locker.Service.Management.Controller;

import com.LockerService.Locker.Service.Management.DTO.LSDRWRRELDto;
import com.LockerService.Locker.Service.Management.Service.LSDRWRRELService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/LSM/DrawerRelease")
public class LSDRWRRELController {

    @Autowired
    private LSDRWRRELService lsdrwrrelService;

    @PostMapping("/Create")
    public ResponseEntity<LSDRWRRELDto> createDRAWERRelease(@Valid @RequestBody LSDRWRRELDto lsdrwrrelDto){
        return new ResponseEntity<>(lsdrwrrelService.createDrawerRelease(lsdrwrrelDto), HttpStatus.CREATED);

    }

    @GetMapping("/get")
    public List<LSDRWRRELDto> GetRelease(){
        return lsdrwrrelService.GetAlldrawer();
    }

    @GetMapping("/{RELID}")
    public ResponseEntity<LSDRWRRELDto> getDrawerReleaseById(@PathVariable(name = "RELID") long RELID){
        return ResponseEntity.ok(lsdrwrrelService.getReleaseByID(RELID));

    }

    @PutMapping("/{RELID}")
    public  ResponseEntity<LSDRWRRELDto> updatePost(@RequestBody LSDRWRRELDto lsdrwrrelDto, @PathVariable(name = "RELID") long RELID ){
        LSDRWRRELDto DrawerResponse = lsdrwrrelService.updateDrawerRelease(lsdrwrrelDto,RELID);
        return new ResponseEntity<>(DrawerResponse, HttpStatus.OK);
    }
    
    @DeleteMapping("/{RELID}")
    public ResponseEntity<String> deleteDrawerRelease(@PathVariable(name = "RELID") long RELID){

        lsdrwrrelService.deleteDrawerById(RELID);

        return new ResponseEntity<>("Drawer Release  successfully.", HttpStatus.OK);
    }
}
