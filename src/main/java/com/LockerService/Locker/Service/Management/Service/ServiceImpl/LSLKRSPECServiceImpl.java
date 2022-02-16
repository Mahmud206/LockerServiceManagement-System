package com.LockerService.Locker.Service.Management.Service.ServiceImpl;

import com.LockerService.Locker.Service.Management.DTO.LSLKRSPECDto;
import com.LockerService.Locker.Service.Management.Entity.LSLKRSPECEntity;
import com.LockerService.Locker.Service.Management.Repository.LSLKRSPECRepo;
import com.LockerService.Locker.Service.Management.Service.LSLKRSPECService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LSLKRSPECServiceImpl implements LSLKRSPECService {

    private LSLKRSPECRepo lslkrspecRepo;
    private ModelMapper mapper;

    public LSLKRSPECServiceImpl(LSLKRSPECRepo lslkrspecRepo, ModelMapper mapper) {
        this.lslkrspecRepo = lslkrspecRepo;
        this.mapper = mapper;
    }


    @Override
    public List<LSLKRSPECDto> GetAllLockerInfo() {
        List<LSLKRSPECEntity> lslkrspecEntities= lslkrspecRepo.findAll();
        return lslkrspecEntities.stream().map
                (lslkrspecEntity -> mapToDTO(lslkrspecEntity)).collect(Collectors.toList());
    }

    //Convert Entity into DTO
    private LSLKRSPECDto mapToDTO(LSLKRSPECEntity lslkrspecEntity){

        LSLKRSPECDto lslkrspecDto = mapper.map(lslkrspecEntity, LSLKRSPECDto.class);
        return lslkrspecDto;
    }
}
