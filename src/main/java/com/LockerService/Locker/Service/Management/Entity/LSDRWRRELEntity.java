package com.LockerService.Locker.Service.Management.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LSDRWRREL")
public class LSDRWRRELEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
