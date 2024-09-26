package com.example.L8.entities;



import java.util.UUID;


/**

 CREATE TABLE `user_info_v2` (
   `id` varchar(128) NOT NULL,
    `name` varchar(128) DEFAULT NULL,
    `email` varchar(50) DEFAULT NULL,
    `address` varchar(250) DEFAULT NULL,
    `phoneNumber` int DEFAULT '0'
 ) ;


 *
 *
 */
public class UserInfoV2 {

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
