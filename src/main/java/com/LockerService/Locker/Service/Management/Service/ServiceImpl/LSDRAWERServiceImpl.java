package com.LockerService.Locker.Service.Management.Service.ServiceImpl;

import com.LockerService.Locker.Service.Management.DTO.LSDRAWERDto;
import com.LockerService.Locker.Service.Management.DTO.LSLKRSPECDto;
import com.LockerService.Locker.Service.Management.Entity.LSDRAWEREntity;
import com.LockerService.Locker.Service.Management.Entity.LSLKRSPECEntity;
import com.LockerService.Locker.Service.Management.Repository.LSDRAWERRepo;
import com.LockerService.Locker.Service.Management.Service.LSDRAWERService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LSDRAWERServiceImpl implements LSDRAWERService {

    private LSDRAWERRepo lsdrawerRepo;
    private ModelMapper mapper;

    public LSDRAWERServiceImpl(LSDRAWERRepo lsdrawerRepo, ModelMapper mapper) {
        this.lsdrawerRepo = lsdrawerRepo;
        this.mapper = mapper;
    }

    @Override
    public List<LSDRAWERDto> GetAllDrawerInfo() {
        List<LSDRAWEREntity> lsdrawerEntities= lsdrawerRepo.findAll();
        return lsdrawerEntities.stream().map
                (lsdrawerEntity -> mapToDTO(lsdrawerEntity)).collect(Collectors.toList());
    }

    //Convert Entity into DTO
    private LSDRAWERDto mapToDTO(LSDRAWEREntity lsdrawerEntity){

        LSDRAWERDto lsdrawerDto = mapper.map(lsdrawerEntity, LSDRAWERDto.class);
        return lsdrawerDto;
    }
}
