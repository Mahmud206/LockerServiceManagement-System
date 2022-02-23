package com.LockerService.Locker.Service.Management.Controller;

import com.LockerService.Locker.Service.Management.DTO.LSDRWRRELDto;
import com.LockerService.Locker.Service.Management.ResponsiveModel.CommonResponseModel;
import com.LockerService.Locker.Service.Management.Service.LSDRWRRELService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/LSM/DrawerRelease")
public class LSDRWRRELController {

    @Autowired
    private LSDRWRRELService lsdrwrrelService;
/*
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/Create")
    public ResponseEntity<LSDRWRRELDto> createDRAWERRelease(@Valid @RequestBody LSDRWRRELDto lsdrwrrelDto){
        return new ResponseEntity<>(lsdrwrrelService.createDrawerRelease(lsdrwrrelDto), HttpStatus.CREATED);

    }
*/
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/Create")
    public CommonResponseModel createDRAWERRelease(@Valid @RequestBody LSDRWRRELDto lsdrwrrelDto){
        return lsdrwrrelService.createDrawerRelease(lsdrwrrelDto);
    }


    @GetMapping("/get")
    public List<LSDRWRRELDto> GetRelease(){
        return lsdrwrrelService.GetAlldrawer();
    }


    @GetMapping("/{RELID}")
    public ResponseEntity<LSDRWRRELDto> getDrawerReleaseById(@PathVariable(name = "RELID") long RELID){
        return ResponseEntity.ok(lsdrwrrelService.getReleaseByID(RELID));

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{RELID}")
    public  ResponseEntity<LSDRWRRELDto> updatePost(@RequestBody LSDRWRRELDto lsdrwrrelDto, @PathVariable(name = "RELID") long RELID ){
        LSDRWRRELDto DrawerResponse = lsdrwrrelService.updateDrawerRelease(lsdrwrrelDto,RELID);
        return new ResponseEntity<>(DrawerResponse, HttpStatus.OK);
    }
/*
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{RELID}")
    public ResponseEntity<String> deleteDrawerRelease(@PathVariable(name = "RELID") long RELID){

        lsdrwrrelService.deleteDrawerById(RELID);

        return new ResponseEntity<>("Drawer Release  successfully.", HttpStatus.OK);
    }

 */
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{RELID}")
    private CommonResponseModel deleteDrawerRelease(@PathVariable(name = "RELID") long RELID){
        return lsdrwrrelService.deleteDrawerById(RELID);
    }

}
