package com.LockerService.Locker.Service.Management.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class LSDRWRRELDto {
    private long RELID;
    private String OPRBRANCD;
    private long CUSCOD;
    private String BRANCD;
    private String ACTYPE;
    private String OPRSTAMP;
    private Date OPRTIMSTAMP;
    private String UPDATE_BY;
    private Date UPDATE_DATE;
    private String APPFLG;
    private String APPSTAMP;
    private Date APPTIMSTAMP;
    private long LCKRID;
    private long DRWRID;
    private String ACTNUM;
    private Date RELDATE;
    private String PAYSTAT;
    private String REMARKS;
    private long DUEAMT;
}
