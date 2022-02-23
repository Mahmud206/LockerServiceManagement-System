package com.LockerService.Locker.Service.Management.Service;

import com.LockerService.Locker.Service.Management.DTO.LSLKRSPECDto;
import com.LockerService.Locker.Service.Management.ResponsiveModel.CommonResponseModel;

import java.util.List;

public interface LSLKRSPECService {

    List<LSLKRSPECDto> GetAllLockerInfo();

    CommonResponseModel createLockerSpecification(LSLKRSPECDto lslkrspecDto);

    LSLKRSPECDto getLockerSpecificationById(long LCKRID);

    LSLKRSPECDto updateLockerSpecificationById(LSLKRSPECDto lslkrspecDto, long LCKRID);

    CommonResponseModel deleteLockerSpecificationById(long LCKRID);
}
