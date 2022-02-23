package com.LockerService.Locker.Service.Management.Service.ServiceImpl;

import com.LockerService.Locker.Service.Management.DTO.LSDRWRRELDto;
import com.LockerService.Locker.Service.Management.Entity.LSDRWRRELEntity;
import com.LockerService.Locker.Service.Management.Exception.ResourceNotFoundException;
import com.LockerService.Locker.Service.Management.Repository.LSDRWRRELRepo;
import com.LockerService.Locker.Service.Management.ResponsiveModel.CommonResponseModel;
import com.LockerService.Locker.Service.Management.Service.LSDRWRRELService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class LSDRWRRELServiceImpl implements LSDRWRRELService {

    private LSDRWRRELRepo lsdrwrrelRepo;
    private ModelMapper mapper;

    public LSDRWRRELServiceImpl(LSDRWRRELRepo lsdrwrrelRepo, ModelMapper mapper) {
        this.lsdrwrrelRepo = lsdrwrrelRepo;
        this.mapper = mapper;
    }

    @Override
    public CommonResponseModel createDrawerRelease(LSDRWRRELDto lsdrwrrelDto) {
/*
        LSDRWRRELEntity lsdrwrrelEntity=mapToEntity(lsdrwrrelDto);
        lsdrwrrelEntity.setOPRBRANCD("A01");
        lsdrwrrelEntity.setBRANCD("D12");
        lsdrwrrelEntity.setCUSCOD(012565);
        lsdrwrrelEntity.setACTYPE("S01");
        lsdrwrrelEntity.setOPRSTAMP("D");
        //lsdrwrrelEntity.setOPRTIMSTAMP(2022/02/09);
        lsdrwrrelEntity.setUPDATE_BY("S");
        //lsdrwrrelEntity.setUPDATE_DATE();
        lsdrwrrelEntity.setAPPFLG("S");
        lsdrwrrelEntity.setAPPSTAMP("S");
        //lsdrwrrelEntity.setAPPTIMSTAMP();
        LSDRWRRELEntity newRelease=lsdrwrrelRepo.save(lsdrwrrelEntity);

        //convert entity to DTO
        LSDRWRRELDto ReleaseResponse = mapToDTO(newRelease);
        return ReleaseResponse;
        */
        CommonResponseModel commonResponseModel = new CommonResponseModel();
        LSDRWRRELEntity lsdrwrrelEntity = lsdrwrrelRepo.save(mapper.map(lsdrwrrelDto, LSDRWRRELEntity.class));

        if (lsdrwrrelEntity.getRELID() > 0) {
            commonResponseModel.setResponseCode(1);
            commonResponseModel.setResponseMessage("Drawer Release Save Successfully");
            commonResponseModel.setId(lsdrwrrelEntity.getRELID());
        }

        return commonResponseModel;


    }

    @Override
    public List<LSDRWRRELDto> GetAlldrawer() {
        List<LSDRWRRELEntity> lsdrwrrelEntities= lsdrwrrelRepo.findAll();
        return lsdrwrrelEntities.stream().map
                (lsdrwrrelEntity -> mapToDTO(lsdrwrrelEntity)).collect(Collectors.toList());
    }

    @Override
    public LSDRWRRELDto getReleaseByID(long RELID) {
        LSDRWRRELEntity lsdrwrrelEntity=lsdrwrrelRepo.findById(RELID).orElseThrow(() -> new ResourceNotFoundException("LSDRWRRELEntity","RELID",RELID));
        return mapToDTO(lsdrwrrelEntity);
    }

    @Override
    public LSDRWRRELDto updateDrawerRelease(LSDRWRRELDto lsdrwrrelDto, long RELID) {
        LSDRWRRELEntity lsdrwrrelEntity=lsdrwrrelRepo.findById(RELID).orElseThrow(() -> new ResourceNotFoundException("LSDRWRRELEntity","RELID",RELID));

        lsdrwrrelEntity.setRELID(lsdrwrrelDto.getRELID());
        lsdrwrrelEntity.setLCKRID(lsdrwrrelDto.getLCKRID());
        lsdrwrrelEntity.setDRWRID(lsdrwrrelDto.getDRWRID());
        lsdrwrrelEntity.setACTNUM(lsdrwrrelDto.getACTNUM());
        lsdrwrrelEntity.setRELDATE(lsdrwrrelDto.getRELDATE());
        lsdrwrrelEntity.setPAYSTAT(lsdrwrrelDto.getPAYSTAT());
        lsdrwrrelEntity.setREMARKS(lsdrwrrelDto.getREMARKS());
        lsdrwrrelEntity.setDUEAMT(lsdrwrrelDto.getDUEAMT());

        LSDRWRRELEntity updateRelease=lsdrwrrelRepo.save(lsdrwrrelEntity);
        return mapToDTO(updateRelease);
    }

    @Override
    public CommonResponseModel deleteDrawerById(long RELID) {
        CommonResponseModel commonResponseModel = new CommonResponseModel();
        Optional<LSDRWRRELEntity> lsdrwrrelEntity = lsdrwrrelRepo.findById(RELID);
        if (!lsdrwrrelEntity.isPresent()) {
            commonResponseModel.setResponseMessage("No Data Found "+RELID);
            return commonResponseModel;
        }
        lsdrwrrelRepo.delete(lsdrwrrelEntity.get());
        commonResponseModel.setResponseCode(1);
        commonResponseModel.setResponseMessage("Drawer Release Info delete Successfully ");
        return commonResponseModel;
    }

    private LSDRWRRELDto mapToDTO(LSDRWRRELEntity lsdrwrrelEntity){

        LSDRWRRELDto lsdrwrrelDto = mapper.map(lsdrwrrelEntity, LSDRWRRELDto.class);
        return lsdrwrrelDto;
    }

    private LSDRWRRELEntity mapToEntity(LSDRWRRELDto lsdrwrrelDto){

        LSDRWRRELEntity lsdrwrrelEntity = mapper.map(lsdrwrrelDto, LSDRWRRELEntity.class);
        return lsdrwrrelEntity;
    }
}
