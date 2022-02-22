package com.LockerService.Locker.Service.Management.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class LSDRAWERDto {
    private long DRWRID;
    private String DRWRCOD;
    private long LCKRID;
    private String DRWRTYP;
    private String DIMENTION;
    private long NUMOFKEY;
    private String CHARGEGL;
    private String VATGL;
    private String SECURITYGL;
    private String CHARGEPRD;
    private Date EFFDATE;
    private Date STARTDATE;
    private Date ENDDATE;
    private String REMARKS;
    private String OPRSTAMP;
    private Date OPRTIMSTAMP;
    private String UPDATE_BY;
    private Date UPDATE_DATE;
    private String ACTFLG;
    private String BOKFLG;
    private String APPFLG;
    private String APPSTAMP;
    private Date APPTIMSTAMP;
}
