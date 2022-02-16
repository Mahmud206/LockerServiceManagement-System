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
        name = "LSDRWRALLOCAT"
)
public class LSDRWRALLOCATEntity {
    @Id
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
