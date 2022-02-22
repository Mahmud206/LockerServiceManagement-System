package com.LockerService.Locker.Service.Management.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class LSALLOCATSECDto {

    private long SECID;
    private long ALLOCATID;
    private String CUSCOD;
    private String BRANCD;
    private String ACTYPE;
    private String ACTNUM;
    private String ISLIEN;
    private String SECNO;
    private String SECTIT;
    private long SERNUM;
    private String SECTYP;
    private long MARGIN;
    private long REMAINAMT;
    private long CURBAL;
    private String ACSTAT;
    private String LIENST;
    private String ISSUCCESS;
    private String REMARKS;
    private String STATUS;
    private String OPRSTAMP;
    private Date OPRTIMSTAMP;
    private String UPDATE_BY;
    private Date UPDATE_DATE;
}
