package com.LockerService.Locker.Service.Management.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class LSCUSMASDto {
    private String CUSCOD;
    private String CUSTYP;
    private String ADDRS1;
    private String ADDrs2;
    private String CUSNMF;
    private String CUSNML;
    private String CUSNMG;
    private Date CUSDOB;
    private long CUSAGE;
    private String CITYNM;
    private String CITYCD;
    private String MOBLNO;
}
