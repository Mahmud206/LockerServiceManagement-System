package com.LockerService.Locker.Service.Management.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "LSUSERS" , uniqueConstraints = {@UniqueConstraint(columnNames = {"userName"}),
        @UniqueConstraint(columnNames = {"email"})
})
public class LSUSEREntity {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String name;
    private String userName;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "LSUserRoles",
            joinColumns = @JoinColumn(name = "userId",referencedColumnName = "id")
            , inverseJoinColumns = @JoinColumn(name = "roleId",referencedColumnName = "id"))
    private Set<LSROLEEntity> roles;
}
