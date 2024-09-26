package com.example.L8.models;

import com.example.L8.entities.UserInfo;
import lombok.Data;

import java.util.UUID;

@Data
public class CreateUserRequest {


    String name;
    Integer phoneNumber ;
    String email;
    String address;



    public UserInfo toUserInfo(){
        return UserInfo.builder()
                .address(address)
                .email(email)
                .phoneNumber(phoneNumber)
                .name(name)
                .id(UUID.randomUUID().toString())
                .build();
    }
}
