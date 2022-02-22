package com.LockerService.Locker.Service.Management.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "LSALLOCATSEC"
)
public class LSALLOCATSECEntity {
    @Id
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
