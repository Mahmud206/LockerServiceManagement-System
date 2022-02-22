package com.LockerService.Locker.Service.Management.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class LSLKRSPECDto {

    private long LCKRID;
    private String LCKRCOD;
    private String LCKRNAM;
    private String VENCOD;
    private String BRANDCOD;
    private long NUMOFDRWR;
    private String LCKRDES;
    private String REMARKS;
    private String OPRSTAMP;
    private Date OPRTIMSTAMP;
    private String UPDSTAMP;
    private Date UPDTIMSTAMP;
    private String ACTFLG;
    private String BOKFLG;
    private String APPFLG;
    private String APPSTAMP;
    private Date APPTIMSTAMP;
}
