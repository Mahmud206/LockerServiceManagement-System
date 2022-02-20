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

    public Long getSALEVAL() {
        return SALEVAL;
    }
    public void setSALEVAL(Long SALEVAL) {
        this.SALEVAL = SALEVAL;
    }
    public Long getALLOCATID() {
        return ALLOCATID;
    }
    public void setALLOCATID(Long ALLOCATID) {
        this.ALLOCATID = ALLOCATID;
    }
    public Long getMARKETVAL() {
        return MARKETVAL;
    }
    public void setMARKETVAL(Long MARKETVAL) {
        this.MARKETVAL = MARKETVAL;
    }
       public Long getCAUTIONAMT() {
        return CAUTIONAMT;
    }

    public void setCAUTIONAMT(Long CAUTIONAMT) {
        this.CAUTIONAMT = CAUTIONAMT;
    }

    public String getBRANCD() {
        return BRANCD;
    }

    public void setBRANCD(String BRANCD) {
        this.BRANCD = BRANCD;
    }

    public String getACTNUM() {
        return ACTNUM;
    }
    public void setACTNUM(String ACTNUM) {
        this.ACTNUM = ACTNUM;
    }

    public String getACTTIT() {
        return ACTTIT;
    }

    public void setACTTIT(String ACTTIT) {
        this.ACTTIT = ACTTIT;
    }

    public String getCUSCOD() {
        return CUSCOD;
    }

    public void setCUSCOD(String CUSCOD) {
        this.CUSCOD = CUSCOD;
    }

    public String getPRDCOD() {
        return PRDCOD;
    }

    public void setPRDCOD(String PRDCOD) {
        this.PRDCOD = PRDCOD;
    }

    public String getREMARKS() {
        return REMARKS;
    }

    public void setREMARKS(String REMARKS) {
        this.REMARKS = REMARKS;
    }
    public Date getALLOCATDATE() {
        return ALLOCATDATE;
    }

    public void setALLOCATDATE(Date ALLOCATDATE) {
        this.ALLOCATDATE = ALLOCATDATE;
    }
    public Date getEXPDATE() {
        return EXPDATE;
    }

    public void setEXPDATE(Date EXPDATE) {
        this.EXPDATE = EXPDATE;
    }

}
