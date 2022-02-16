package com.LockerService.Locker.Service.Management.Service.ServiceImpl;

import com.LockerService.Locker.Service.Management.DTO.LSDRWRALLOCATDto;
import com.LockerService.Locker.Service.Management.Entity.LSDRWRALLOCATEntity;
import com.LockerService.Locker.Service.Management.Entity.LSDRWRRELEntity;
import com.LockerService.Locker.Service.Management.Exception.ResourceNotFoundException;
import com.LockerService.Locker.Service.Management.Repository.LSDRWRALLOCATRepo;
import com.LockerService.Locker.Service.Management.Service.LSDRWRALLOCATService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LSDRWRALLOCATServiceImpl implements LSDRWRALLOCATService {

    private LSDRWRALLOCATRepo lsdrwrallocatRepo;
    private ModelMapper mapper;

    public LSDRWRALLOCATServiceImpl(LSDRWRALLOCATRepo lsdrwrallocatRepo,ModelMapper mapper) {
        this.lsdrwrallocatRepo = lsdrwrallocatRepo;
        this.mapper = mapper;
    }

    @Override
    public List<LSDRWRALLOCATDto> GetAllDrawerAllocateInfo() {
        List<LSDRWRALLOCATEntity> lsdrwrallocatEntities= lsdrwrallocatRepo.findAll();
        return lsdrwrallocatEntities.stream().map
                (lsdrwrallocatEntity -> mapToDTO(lsdrwrallocatEntity)).collect(Collectors.toList());
    }

    @Override
    public LSDRWRALLOCATDto getDrawerAllocateByAccountNo(String ACTNUM) {
        LSDRWRALLOCATEntity lsdrwrallocatEntity=lsdrwrallocatRepo.findByACTNUM(ACTNUM);
        return mapToDTO(lsdrwrallocatEntity);
    }

    //Convert Entity into DTO
    private LSDRWRALLOCATDto mapToDTO(LSDRWRALLOCATEntity lsdrwrallocatEntity){

        LSDRWRALLOCATDto lsdrwrallocatDto = mapper.map(lsdrwrallocatEntity, LSDRWRALLOCATDto.class);
        return lsdrwrallocatDto;
    }
}
