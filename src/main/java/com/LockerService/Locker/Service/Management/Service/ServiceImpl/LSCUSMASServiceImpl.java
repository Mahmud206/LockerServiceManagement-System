//package com.LockerService.Locker.Service.Management.Service.ServiceImpl;
//
//import com.LockerService.Locker.Service.Management.DTO.LSCUSMASDto;
//import com.LockerService.Locker.Service.Management.Entity.LSCUSMASEntity;
//import com.LockerService.Locker.Service.Management.Repository.LSCUSMASRepo;
//import com.LockerService.Locker.Service.Management.Service.LSCUSMASService;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class LSCUSMASServiceImpl implements LSCUSMASService {
//
//    @Autowired
//    private LSCUSMASRepo lscusmasRepo;
//
//    @Autowired
//    private ModelMapper mapper;
//
//    @Override
//    public LSCUSMASDto getCustomerInfoByCuscod(String CUSCOD) {
//        LSCUSMASEntity lscusmasEntity=lscusmasRepo.findByCUSCOD(CUSCOD);
//        return mapToDTO(lscusmasEntity);
//    }
//
//    //Convert Entity into DTO
//    private LSCUSMASDto mapToDTO(LSCUSMASEntity lscusmasEntity){
//
//        LSCUSMASDto lscusmasDto = mapper.map(lscusmasEntity, LSCUSMASDto.class);
//        return lscusmasDto;
//    }
//}
