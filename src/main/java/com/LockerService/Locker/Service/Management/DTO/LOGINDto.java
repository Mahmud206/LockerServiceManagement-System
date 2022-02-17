package com.LockerService.Locker.Service.Management.DTO;

import lombok.Data;

@Data
public class LOGINDto {

    private String usernameOrEmail;
    private String password;
}
