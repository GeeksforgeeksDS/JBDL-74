package com.example.L8.repository;

import com.example.L8.entities.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/**
 *

 Disadvantages of doing adhoc way
 - boiler plate code
 - Lot of mapping with respect to Java --> response && response to Java


 *
 */
@Repository
@Slf4j
public class UserInfoSpringJDBCRepository implements IRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public static String INSERT_USER = " insert into user_info ( email, name, address, id, phoneNumber ) values ";
    public static String INSERT_USER_PREPARED = " insert into user_info (`email`, `name`, `address`, `id`, `phoneNumber` ) values (? , ? , ?, ?, ?) ";

    @Override
    public UserInfo save(UserInfo userInfo) {
        log.info(" inside save or update with {} ", userInfo);
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("name" , userInfo.getName());
        parameterSource.addValue("id" , userInfo.getId());
        parameterSource.addValue("email" , userInfo.getEmail());
        parameterSource.addValue("address" , userInfo.getAddress());
        parameterSource.addValue("phoneNumber" , userInfo.getPhoneNumber());

        int result = namedParameterJdbcTemplate.update(" insert into user_info (`email`, `name`, `address`, `id`, `phoneNumber` )" +
                " values (:email, :name, :address, :id, :phoneNumber)", parameterSource);
        log.info("result {} ", result);
        return userInfo;
    }

    /**
     *
     public static String CREATE_TABLE = "create table if not exists user_info  (" +
     " `id` varchar(128) NOT NULL, \n" +
     " `name` varchar(128) DEFAULT NULL, \n " +
     "  `email` varchar(50) DEFAULT NULL,\n" +
     "  `address` varchar(250) DEFAULT NULL,\n" +
     "  `phoneNumber` int(10) DEFAULT 0,\n" +
     " PRIMARY KEY (`id`) \n" +
     ") ";     * @return
     */

    @Override
    public Optional<UserInfo> fetchUserInfoById(String id) {

        return Optional.of(jdbcTemplate.query("select * from user_info ", new RowMapper<UserInfo>(){
            @Override
            public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
                return UserInfo.builder()
                        .id(rs.getString("id"))
                        .name(rs.getString("name"))
                        .email(rs.getString("email"))
                        .address(rs.getString("address"))
                        .phoneNumber(rs.getInt("phoneNumber"))
                        .build();
            }
        }).get(0));
    }
}
