package com.example.L8.repository;

import com.example.L8.entities.UserInfo;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Optional;

/**
 * mysql
 *
 public static void main(String[] args) throws SQLException {
 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
 Statement statement = connection.createStatement();
 statement.execute("create table sample_info ( id int(10) primary key , " +
 " user_role varchar(50) default null ," +
 " name varchar(20) default  null )");
 } *
 */
@Repository
@Slf4j
public class UserInfoMysqlRepository implements InitializingBean , IRepository{

    @Autowired
    Connection connection;

    /**
     String id = UUID.randomUUID().toString();
     String name;
     Integer phoneNumber ;
     String email;
     String address;
     *
     */
    public static String CREATE_TABLE = "create table if not exists user_info  (" +
            " `id` varchar(128) NOT NULL, \n" +
            " `name` varchar(128) DEFAULT NULL, \n " +
            "  `email` varchar(50) DEFAULT NULL,\n" +
            "  `address` varchar(250) DEFAULT NULL,\n" +
            "  `phoneNumber` int(10) DEFAULT 0,\n" +
            " PRIMARY KEY (`id`) \n" +
            ") ";




    public static String INSERT_USER = " insert into user_info ( email, name, address, id, phoneNumber ) values ";

    public static String INSERT_USER_PREPARED = " insert into user_info (`email`, `name`, `address`, `id`, `phoneNumber` ) values (? , ? , ?, ?, ?) ";



    @Override
    public void afterPropertiesSet() throws Exception {
        Statement statement = connection.createStatement();
        log.info(" CREATE {} " , CREATE_TABLE);
        statement.execute(CREATE_TABLE);

    }

    /**
     *
     INSERT INTO user_info (email, name, address, id, phoneNumber)
     VALUES ('joeynofood@yopmail.com', 'Joey', 'Central Park | Friends', 'f272db67-9a8f-4af5-a7d6-bacae4d3fbf7', '12345323');
     *
     *
     * @param userInfo
     * @return
     */
    @SneakyThrows
    @Override
    public UserInfo saveOrUpdate(UserInfo userInfo){
        log.info(" inside save or update with {} ", userInfo);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(INSERT_USER);
        stringBuilder.append(" ( '").append(userInfo.getEmail()).append("' , '")
                .append(userInfo.getName()).append("' , '")
                .append(userInfo.getAddress()).append("' , '")
                .append(userInfo.getId()).append("' , ")
                .append(userInfo.getPhoneNumber())
                .append(" ) ");
        log.info(" SQL statement {} ", stringBuilder.toString());
        Statement statement = connection.createStatement();
        int result = statement.executeUpdate(stringBuilder.toString());
        log.info("result {} ", result);
        return userInfo;
        /**
         * normal statement
         *
         *
         * prepared statement
         *
         *
         */
    }


    /** (`email`, `name`, `address`, `id`, `phoneNumber` )
     *
     INSERT INTO user_info (email, name, address, id, phoneNumber)
     VALUES ('joeynofood@yopmail.com', 'Joey', 'Central Park | Friends', 'f272db67-9a8f-4af5-a7d6-bacae4d3fbf7', '12345323');
     *
     * @return
     * @throws SQLException
     */
    public UserInfo saveOrUpdatePrepared(UserInfo userInfo) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_PREPARED);
        preparedStatement.setString(1, userInfo.getEmail());
        preparedStatement.setString(2, userInfo.getName());
        preparedStatement.setString(3, userInfo.getAddress());
        preparedStatement.setString(4, userInfo.getId());
        preparedStatement.setInt(5, userInfo.getPhoneNumber());
        int result = preparedStatement.executeUpdate();
        log.info("result {} ", result);
        return userInfo;
    }


    @Override
    @SneakyThrows
    /**
     *     /** (`email`, `name`, `address`, `id`, `phoneNumber` )
     */
    public Optional<UserInfo> fetchUserInfoById(String id) {
        String FETCH_USER_BY_ID = " select * from user_info where id='" + id + "'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(FETCH_USER_BY_ID);
        if (resultSet.next()){
            return Optional.of(UserInfo.builder()
                    .email(resultSet.getString("email"))
                    .name(resultSet.getString("name"))
                    .address(resultSet.getString("address"))
                    .id(resultSet.getString("id"))
                    .phoneNumber(resultSet.getInt("phoneNumber"))
                    .build());
        }
        return Optional.empty();
    }
}
