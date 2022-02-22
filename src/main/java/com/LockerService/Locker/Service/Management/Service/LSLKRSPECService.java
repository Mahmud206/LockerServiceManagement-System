package com.LockerService.Locker.Service.Management.Service;

import com.LockerService.Locker.Service.Management.DTO.LSLKRSPECDto;

import java.util.List;

public interface LSLKRSPECService {

    List<LSLKRSPECDto> GetAllLockerInfo();

    LSLKRSPECDto createLockerSpecification(LSLKRSPECDto lslkrspecDto);

    LSLKRSPECDto getLockerSpecificationById(long LCKRID);

    LSLKRSPECDto updateLockerSpecificationById(LSLKRSPECDto lslkrspecDto, long LCKRID);

    void deleteLockerSpecificationById(long LCKRID);
}
