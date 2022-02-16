package com.LockerService.Locker.Service.Management.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class LSDRWRALLOCATDto {
    private long ALLOCATID;
    private String ACTNUM;
    private String ACTTIT;
    private String ACTYPE;
    private String  CUSCOD;
    private String PRDCOD;
    private long SALEVAL;
    private long MARKETVAL;
    private long  CAUTIONAMT;
    private Date ALLOCATDATE;
    private Date EXPDATE;
    private String REMARKS;
}
