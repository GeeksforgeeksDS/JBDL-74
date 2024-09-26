package com.example.L8.repository;

import com.example.L8.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MyRepository extends JpaRepository<UserInfo, String> {


    // no implementation of the methods

    List<UserInfo> findUserInfoByNameLikeAndAddressContains(String abc, String addressSubsequence);




}
