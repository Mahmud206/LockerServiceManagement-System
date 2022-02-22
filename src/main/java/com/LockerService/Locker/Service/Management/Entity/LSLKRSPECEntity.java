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
        name = "LSLKRSPEC"
)
public class LSLKRSPECEntity {

    @Id
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
