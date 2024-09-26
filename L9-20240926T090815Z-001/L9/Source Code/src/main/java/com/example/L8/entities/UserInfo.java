package com.example.L8.entities;


import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Builder
public class UserInfo {
    /**
     *  not an Integer which is auto increment
     *  but UUID here
     *
     *
     */
    String id = UUID.randomUUID().toString();


    String name;
    /**
     *
     * phoneNumber to be integer
     *  not a string
     *
     *      Index with integer outperforms index with string even if the values contained are same -
     *
     */
    Integer phoneNumber ;
    String email;
    String address;

}
