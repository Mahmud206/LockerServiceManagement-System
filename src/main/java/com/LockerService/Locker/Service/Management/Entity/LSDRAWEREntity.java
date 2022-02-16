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
@Table(name = "LSDRAWER")
public class LSDRAWEREntity {
    @Id
    private long DRWRID;
    private String DRWRCOD;
    private String DRWRTYP;
}
