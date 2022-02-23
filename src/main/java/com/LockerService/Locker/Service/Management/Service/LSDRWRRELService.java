package com.LockerService.Locker.Service.Management.Service;

import com.LockerService.Locker.Service.Management.DTO.LSDRWRRELDto;
import com.LockerService.Locker.Service.Management.ResponsiveModel.CommonResponseModel;

import java.util.List;

public interface LSDRWRRELService {

    CommonResponseModel createDrawerRelease(LSDRWRRELDto lsdrwrrelDto);

    List<LSDRWRRELDto> GetAlldrawer();

    LSDRWRRELDto getReleaseByID(long RELID);

    LSDRWRRELDto updateDrawerRelease(LSDRWRRELDto lsdrwrrelDto, long RELID);

    void deleteDrawerById(long RELID);

    /*
    CommonResponseModel deleteDrawerById(long RELID);
     */
}
