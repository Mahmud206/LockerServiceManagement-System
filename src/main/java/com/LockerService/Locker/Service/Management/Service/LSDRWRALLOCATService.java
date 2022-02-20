package com.LockerService.Locker.Service.Management.Service;


import com.LockerService.Locker.Service.Management.DTO.LSDRWRALLOCATDto;

import java.util.List;

public interface LSDRWRALLOCATService {

    List<LSDRWRALLOCATDto> GetAllDrawerAllocateInfo();

    LSDRWRALLOCATDto getDrawerAllocateByAccountNo(String ACTNUM);

    LSDRWRALLOCATDto updateDrawerAllocation(LSDRWRALLOCATDto lsdrwrallocatDto,String ACTNUM);

    void deleteLSDRWRALLOCATById(String ACTNUM);

    LSDRWRALLOCATDto createDrawerAllocation( LSDRWRALLOCATDto lsdrwrallocatDto);

}
