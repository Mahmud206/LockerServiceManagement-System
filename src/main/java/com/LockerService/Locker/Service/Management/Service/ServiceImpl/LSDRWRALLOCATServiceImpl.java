package com.LockerService.Locker.Service.Management.Service.ServiceImpl;

import com.LockerService.Locker.Service.Management.DTO.LSDRWRALLOCATDto;
import com.LockerService.Locker.Service.Management.Entity.LSDRWRALLOCATEntity;
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


    @Override
    public LSDRWRALLOCATDto createDrawerAllocation(LSDRWRALLOCATDto lsdrwrallocatDto) {
        LSDRWRALLOCATEntity lsdrwrallocatEntity= mapToEntity(lsdrwrallocatDto);
        LSDRWRALLOCATEntity newlsdrwrrel=lsdrwrallocatRepo.save(lsdrwrallocatEntity);
        LSDRWRALLOCATDto lsdrwrrelResponse = mapToDTO(newlsdrwrrel);
        return lsdrwrrelResponse;
    }

    @Override
    public LSDRWRALLOCATDto updateDrawerAllocation(LSDRWRALLOCATDto lsdrwrallocatDto,String ACTNUM) {
         LSDRWRALLOCATEntity lsdrwrallocatEntity= lsdrwrallocatRepo.findByACTNUM(ACTNUM);
        lsdrwrallocatEntity.setACTTIT(lsdrwrallocatDto.getACTTIT());
        lsdrwrallocatEntity.setACTYPE(lsdrwrallocatDto.getACTYPE());
        lsdrwrallocatEntity.setACTNUM(lsdrwrallocatDto.getACTNUM());
        lsdrwrallocatEntity.setCUSCOD(lsdrwrallocatDto.getCUSCOD());
        lsdrwrallocatEntity.setPRDCOD(lsdrwrallocatDto.getPRDCOD());
        lsdrwrallocatEntity.setSALEVAL(lsdrwrallocatDto.getSALEVAL());
        lsdrwrallocatEntity.setMARKETVAL(lsdrwrallocatDto.getMARKETVAL());
        lsdrwrallocatEntity.setCAUTIONAMT(lsdrwrallocatDto.getCAUTIONAMT());
        lsdrwrallocatEntity.setALLOCATDATE(lsdrwrallocatDto.getALLOCATDATE());
        lsdrwrallocatEntity.setEXPDATE(lsdrwrallocatDto.getEXPDATE());
        lsdrwrallocatEntity.setREMARKS(lsdrwrallocatDto.getREMARKS());
         LSDRWRALLOCATEntity updateDrawerAllocation = lsdrwrallocatRepo.save(lsdrwrallocatEntity);
         return mapToDTO(updateDrawerAllocation);
    }
    @Override
    public void deleteLSDRWRALLOCATById(String ACTNUM) {
        LSDRWRALLOCATEntity lsdrwrallocatEntity= lsdrwrallocatRepo.deleteByACTNUM(ACTNUM);
        lsdrwrallocatRepo.delete(lsdrwrallocatEntity);
    }


    //Convert Entity into DTO
    private LSDRWRALLOCATDto mapToDTO(LSDRWRALLOCATEntity lsdrwrallocatEntity){

        LSDRWRALLOCATDto lsdrwrallocatDto = mapper.map(lsdrwrallocatEntity, LSDRWRALLOCATDto.class);
        return lsdrwrallocatDto;
    }

    private LSDRWRALLOCATEntity mapToEntity(LSDRWRALLOCATDto lsdrwrallocatDto){

        LSDRWRALLOCATEntity lsdrwrallocatEntity = mapper.map(lsdrwrallocatDto, LSDRWRALLOCATEntity.class);
        return lsdrwrallocatEntity;
    }

}
