package com.LockerService.Locker.Service.Management.Service.ServiceImpl;

import com.LockerService.Locker.Service.Management.DTO.LSDRWRALLOCATDto;
import com.LockerService.Locker.Service.Management.Entity.LSDRWRALLOCATEntity;
import com.LockerService.Locker.Service.Management.Repository.LSDRWRALLOCATRepo;
import com.LockerService.Locker.Service.Management.ResponsiveModel.CommonResponseModel;
import com.LockerService.Locker.Service.Management.Service.LSDRWRALLOCATService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public CommonResponseModel createDrawerAllocation(LSDRWRALLOCATDto lsdrwrallocatDto) {
        CommonResponseModel commonResponseModel = new CommonResponseModel();
        LSDRWRALLOCATEntity lsdrwrallocatEntity = lsdrwrallocatRepo.save(mapper.map(lsdrwrallocatDto, LSDRWRALLOCATEntity.class));

        if (lsdrwrallocatEntity.getALLOCATID() > 0) {
            commonResponseModel.setResponseCode(1);
            commonResponseModel.setResponseMessage("Locker Allocate Add Successfully");
            commonResponseModel.setId(lsdrwrallocatEntity.getALLOCATID());
        }

        return commonResponseModel;
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
    public CommonResponseModel deleteLSDRWRALLOCATById(long ALLOCATID) {
        CommonResponseModel commonResponseModel = new CommonResponseModel();
        Optional<LSDRWRALLOCATEntity> lsdrwrallocatEntity = lsdrwrallocatRepo.findById(ALLOCATID);
        if (!lsdrwrallocatEntity.isPresent()) {
            commonResponseModel.setResponseMessage("No Data Found "+ALLOCATID);
            return commonResponseModel;
        }
        lsdrwrallocatRepo.delete(lsdrwrallocatEntity.get());
        commonResponseModel.setResponseCode(1);
        commonResponseModel.setResponseMessage("Locker Allocate Information Delete Successfully ");
        return commonResponseModel;
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
