package com.LockerService.Locker.Service.Management.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
