package com.example.demo.request;


import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class UserInfo {
    String id = UUID.randomUUID().toString();
    String name;
    int health = 100;
}
