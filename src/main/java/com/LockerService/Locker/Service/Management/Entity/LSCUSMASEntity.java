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
@Table(name="LSCUSMAS", schema="LOCKER")
public class LSCUSMASEntity {

    @Id
    private String CUSCOD;
    private String CUSTYP;
    private String ADDRS1;
    private String ADDrs2;
    private String CUSNMF;
    private String CUSNML;
    private String CUSNMG;
    private Date CUSDOB;
    private long CUSAGE;
    private String CITYNM;
    private String CITYCD;
    private String MOBLNO;
}
