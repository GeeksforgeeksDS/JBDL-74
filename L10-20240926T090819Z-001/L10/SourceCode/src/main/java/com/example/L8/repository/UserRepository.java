package com.example.L8.repository;

import com.example.L8.entities.UserInfo;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements InitializingBean, IRepository {
    // in memory db
    HashMap<String, UserInfo> userIdToUserInfo = new HashMap<>();

    /**
     *
     * --> once the instantiated
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        UserInfo u1 = new UserInfo();
        u1.setName("Hey");
        UserInfo u2 = new UserInfo();
        u2.setName("I");
        UserInfo u3 = new UserInfo();
        u3.setName("was");
        UserInfo u4 = new UserInfo();
        u4.setName("doing");

        userIdToUserInfo.put(u1.getId(), u1);
        userIdToUserInfo.put(u2.getId(), u2);
        userIdToUserInfo.put(u3.getId(), u3);
        userIdToUserInfo.put(u4.getId(), u4);


    }


    @Override
    public UserInfo save(UserInfo userInfo) {
        return null;
    }

    @Override
    public Optional<UserInfo> fetchUserInfoById(String id){
       return Optional.of(userIdToUserInfo.get(id));
    }



    public List<UserInfo> fetchAllUsersWithNamesStartsWith(String starts){
        return userIdToUserInfo.values().stream().filter( info -> {
           return info.getName().startsWith(starts);

        }).collect(Collectors.toList());
    }

}
