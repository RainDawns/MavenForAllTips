package com.raindown.model;

import lombok.*;


/**
 * @author: RainDown
 * @date: 2023/4/8 17:05
 * @version: 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDO {

    private String userId;

    private String userName;

    private String phoneNumber;

    private String deptId;




}
