package com.example.L8.repository;

import com.example.L8.entities.UserInfo;
import lombok.SneakyThrows;

import java.util.Optional;

public interface IRepository {
    @SneakyThrows
    UserInfo saveOrUpdate(UserInfo userInfo);

    Optional<UserInfo> fetchUserInfoById(String id);
}
