package com.LockerService.Locker.Service.Management.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class LSDRWRALLOCATDto {

    private long ALLOCATID;
    private long LCKRID;
    private long DRWRID;
    private String OPRBRANCD;
    private String BRANCD;
    private String ACTNUM;
    private String ACTTIT;
    private String ACTYPE;
    private String CUSCOD;
    private String PRDCOD;
    private String OPRMOD;
    private String SECREQ;
    private String SECPAYTYP;
    private String STATUS;
    private long SALEVAL;
    private long MARKETVAL;
    private long CAUTIONAMT;
    private long TENURE;
    private Date ALLOCATDATE;
    private Date EXPDATE;
    private String REMARKS;
    private String OPRSTAMP;
    private Date OPRTIMSTAMP;
    private String UPDATE_BY;
    private Date UPDATE_DATE;
    private String APPFLG;
    private String APPSTAMP;
    private Date APPTIMSTAMP;
    private String TRNFLG;
}
