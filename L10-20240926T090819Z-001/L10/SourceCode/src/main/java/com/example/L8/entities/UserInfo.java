package com.example.L8.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Builder
@Entity
public class UserInfo {

    @Id
    String id = UUID.randomUUID().toString();
    String name;
    Integer phoneNumber ;
    String email;
    String address;

}
