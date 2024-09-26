package com.example.L8.service;

import com.example.L8.entities.UserInfo;
import com.example.L8.exceptions.UserNotFoundException;
import com.example.L8.models.CreateUserRequest;
import com.example.L8.repository.IRepository;
import com.example.L8.repository.MyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService {

    /**
     *  in the application context
     *      <name , $$instance>
     *      <userInfoMySqlRepository, $$userInfoMySqlRepository>
     *          <userRepository, $$userInfoMySqlRepository></>
     *
     *
     */
//    @Qualifier(value = "userInfoSpringJDBCRepository")
//    @Autowired
//    private IRepository userInfoMySqlRepository;
    @Autowired
    private MyRepository userInfoMySqlRepository;

    /**
     *  in order to create an instance using constructor
     *
     *  User Repository is required
     *      --> true
     *      --> false
     *
     *
     * UserService s = new UserService(UserRepository repo);
     *
     * @param repository
     */


    /**
     *
     * UserInfo userInfo = userIdToUserInfo.get(id);
     *         if(Objects.isNull(userInfo)){
     * //            return new ResponseEntity<UserInfo>(HttpStatus.NOT_FOUND);
     *             return new ResponseEntity<UserInfo>(HttpStatus.BAD_REQUEST);
     *         }
     *         return new ResponseEntity<UserInfo>(userInfo, HttpStatus.OK);
     *
     *
     */
    public UserInfo fetchUserInfo(String id){
        log.info("insider user service :: fetching userbyId {} ", id );
        Optional<UserInfo> userInfo = userInfoMySqlRepository.findById(id);
        if(userInfo.isEmpty()){
             throw new UserNotFoundException("User Not Found");
        }
        return userInfo.get();
    }

    public UserInfo createUser(CreateUserRequest userRequest){
        UserInfo userInfo = userRequest.toUserInfo();
        log.info(" userInfo {} ", userInfo);
        return userInfoMySqlRepository.save(userInfo);
    }



    /**
     * // preffered
     *  LOG level
     *      --> different levels at which information is loggeed at
     *   StringBuilder
     *   it concatinating
     *     d =  a.append(b).append(c)
     *
     *
     *  // not preffered
     *  System.out.println(a + b + c);
     *  d = a + b + c
     *
     *
     *
     * @param starts
     * @return
     */

//    public List<UserInfo> findAllTheUsersWithNameStartingWith(String starts){
//        log.info("insider user service :: fetching findAllTheUsersWithNameStartingWith {} ", starts );
//        return repository.fetchAllUsersWithNamesStartsWith(starts);
//    }


}
