package com.LockerService.Locker.Service.Management.ResponsiveModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponseModel {
    private long id;
    private int responseCode;
    private String responseMessage;
}
