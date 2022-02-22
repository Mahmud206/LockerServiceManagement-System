package com.LockerService.Locker.Service.Management.Service.ServiceImpl;


import com.LockerService.Locker.Service.Management.DTO.LSLKRSPECDto;
import com.LockerService.Locker.Service.Management.Entity.LSLKRSPECEntity;
import com.LockerService.Locker.Service.Management.Exception.ResourceNotFoundException;
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

    @Override
    public LSLKRSPECDto createLockerSpecification(LSLKRSPECDto lslkrspecDto) {
        LSLKRSPECEntity lslkrspecEntity= mapToEntity(lslkrspecDto);
        LSLKRSPECEntity newLockerSpecification=lslkrspecRepo.save(lslkrspecEntity);
        LSLKRSPECDto LockerSpecificationResponse = mapToDTO(newLockerSpecification);
        return LockerSpecificationResponse;
    }

    @Override
    public LSLKRSPECDto getLockerSpecificationById(long LCKRID) {
        LSLKRSPECEntity lslkrspecEntity=lslkrspecRepo.findById(LCKRID).orElseThrow(() -> new ResourceNotFoundException("LSLKRSPECEntity","LCKRID",LCKRID));
        return mapToDTO(lslkrspecEntity);
    }

    @Override
    public LSLKRSPECDto updateLockerSpecificationById(LSLKRSPECDto lslkrspecDto, long LCKRID) {
        LSLKRSPECEntity lslkrspecEntity=lslkrspecRepo.findById(LCKRID).orElseThrow(() -> new ResourceNotFoundException("LSDRWRRELEntity","LCKRID",LCKRID));

        lslkrspecEntity.setLCKRCOD(lslkrspecDto.getLCKRCOD());
        lslkrspecEntity.setLCKRNAM(lslkrspecDto.getLCKRNAM());
        lslkrspecEntity.setVENCOD(lslkrspecDto.getVENCOD());
        lslkrspecEntity.setBRANDCOD(lslkrspecDto.getBRANDCOD());
        lslkrspecEntity.setNUMOFDRWR(lslkrspecDto.getNUMOFDRWR());
        lslkrspecEntity.setLCKRDES(lslkrspecDto.getLCKRDES());
        lslkrspecEntity.setREMARKS(lslkrspecDto.getREMARKS());
        lslkrspecEntity.setOPRSTAMP(lslkrspecDto.getOPRSTAMP());
        lslkrspecEntity.setOPRTIMSTAMP(lslkrspecDto.getOPRTIMSTAMP());
        lslkrspecEntity.setUPDSTAMP(lslkrspecDto.getUPDSTAMP());
        lslkrspecEntity.setUPDTIMSTAMP(lslkrspecDto.getUPDTIMSTAMP());
        lslkrspecEntity.setACTFLG(lslkrspecDto.getACTFLG());
        lslkrspecEntity.setAPPFLG(lslkrspecDto.getAPPFLG());
        lslkrspecEntity.setAPPSTAMP(lslkrspecDto.getAPPSTAMP());
        lslkrspecEntity.setAPPTIMSTAMP(lslkrspecDto.getAPPTIMSTAMP());

        LSLKRSPECEntity updateLockerSpecification=lslkrspecRepo.save(lslkrspecEntity);
        return mapToDTO(updateLockerSpecification);
    }

    @Override
    public void deleteLockerSpecificationById(long LCKRID) {
        LSLKRSPECEntity lslkrspecEntity = lslkrspecRepo.findById(LCKRID).orElseThrow(() -> new ResourceNotFoundException("LSLKRSPECEntity", "LCKRID", LCKRID));
        lslkrspecRepo.delete(lslkrspecEntity);
    }

    //Convert Entity into DTO
    private LSLKRSPECDto mapToDTO(LSLKRSPECEntity lslkrspecEntity){

        LSLKRSPECDto lslkrspecDto = mapper.map(lslkrspecEntity, LSLKRSPECDto.class);
        return lslkrspecDto;
    }

    //Convert DTO into Entity
    private LSLKRSPECEntity mapToEntity(LSLKRSPECDto lslkrspecDto){

        LSLKRSPECEntity lslkrspecEntity = mapper.map(lslkrspecDto, LSLKRSPECEntity.class);
        return lslkrspecEntity;
    }
}
