package com.LockerService.Locker.Service.Management.Service;

import com.LockerService.Locker.Service.Management.DTO.LSDRWRRELDto;

import java.util.List;

public interface LSDRWRRELService {

    LSDRWRRELDto createDrawerRelease(LSDRWRRELDto lsdrwrrelDto);
    List<LSDRWRRELDto> GetAlldrawer();
    LSDRWRRELDto getReleaseByID(long RELID);
    LSDRWRRELDto updateDrawerRelease(LSDRWRRELDto lsdrwrrelDto, long RELID);
    void deleteDrawerById(long RELID);
}
