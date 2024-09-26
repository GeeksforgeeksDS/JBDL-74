package com.example.demo.controller;


import com.example.demo.request.UserInfo;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;


/**
 *
 *     public static void main(String[] args) throws IOException {
 *
 *
 *         server.createContext("/helloWorld", new HttpHandler() {
 *             @Override
 *             public void handle(HttpExchange exchange) throws IOException {
 *                 String responseMessage = "Hi ... inside handle exchange - " + Thread.currentThread().getName();
 *
 *                 exchange.sendResponseHeaders(200, responseMessage.length());
 *                 OutputStream responseBody = exchange.getResponseBody();
 *                 responseBody.write(responseMessage.getBytes(StandardCharsets.UTF_8));
 *             }
 *         });

 *     }
 *
 *
 *
 */
@Controller
@RestController
public class UserController implements InitializingBean {
    /**
     *      MVC
     *          (Model)     View    Controller
     *
     *
     *      ----> persisting data in db
     *              (id, user_name, user_email)
     *
     *              --> find user by id
     *                  select * from user where id = ? provided by the application
     *
     *
     *     IDEMPOTENCY -
     *              Performing same operation multiple times --> same output is obtained
     *
     *              Idempotent method
     *                  DELETE
     *                  PUT
     *                  GET
     *
     *              non idempotent methods --> idempotent
     *                 -> POST
     *                 -> PATCH
     *
     *
     *
     *
     */

    // in memory db
    HashMap<String, UserInfo> userIdToUserInfo = new HashMap<>();



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


    /**
     *
     * Get Mapping
     *          --> GET
     *                  --> fetches data from repository / data source / hashmap in our case
     *
     * @return
     */
    @GetMapping(name = "{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
// older way    @RequestMapping("/helloWorld", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<UserInfo> findUserInfoById(@PathVariable("id") String id){
        UserInfo userInfo = userIdToUserInfo.get(id);
        if(Objects.isNull(userInfo)){
//            return new ResponseEntity<UserInfo>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<UserInfo>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<UserInfo>(userInfo, HttpStatus.OK);
    }



    @PostMapping(name = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
// older way    @RequestMapping("/helloWorld", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<UserInfo> insertUser(@RequestBody UserInfo userInfo){
        UserInfo persistedUser = userIdToUserInfo.get(userInfo.getId());
        if(Objects.nonNull(persistedUser)){
            return new ResponseEntity<UserInfo>(HttpStatus.BAD_REQUEST);
        }
        userIdToUserInfo.put(userInfo.getId(), userInfo);
        return new ResponseEntity<UserInfo>(HttpStatus.OK);
    }


    @DeleteMapping(name = "{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserInfo> deleteUser(@PathVariable String id){
        UserInfo persistedUser = userIdToUserInfo.remove(id);
        if(Objects.isNull(persistedUser)){
            return new ResponseEntity<UserInfo>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<UserInfo>(persistedUser,HttpStatus.OK);
//        return new ResponseEntity<UserInfo>(HttpStatus.NO_CONTENT);
    }


    @GetMapping(name = "/users/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserInfo>> fetchAllUser(){
        return new ResponseEntity<List<UserInfo>>((List<UserInfo>) userIdToUserInfo.values(), HttpStatus.OK);
    }


    HashMap<String , Boolean> idempotencyKeyToPresent = new HashMap<>();

    // here it is post
    public void server2(int hit, String opponentId, String idempotencyKey){
        // get current health of opponent --> get it from DB
        Boolean isFound = idempotencyKeyToPresent.getOrDefault(idempotencyKey, false);
        if(isFound){
            return;
        }

        UserInfo opponent = userIdToUserInfo.get(opponentId);
        if(Objects.nonNull(opponent)){
            // throw exception or do certain stuff
        }
        opponent.setHealth(opponent.getHealth() - hit);
        userIdToUserInfo.put(opponentId, opponent);
        idempotencyKeyToPresent.put(idempotencyKey, false);
    }


    /**
     *
     *
     *
     *      ----> server 1      --->                             -                                       --------\\                  idempotencyKeyToPresent(12345, proceseed)
     *                                                                                                          \\      DB
     *                                                                                                          //
     *      ---> server 2       --->                                                                   --------//
     *
     *
     * @param hit
     * @param opponentId
     * @param idempotencyKey
     */



    public void server1(int hit, String opponentId, String idempotencyKey){
        // get current health of opponent --> get it from DB
        Boolean isFound = idempotencyKeyToPresent.getOrDefault(idempotencyKey, false);
        if(isFound){
            return;
        }

        UserInfo opponent = userIdToUserInfo.get(opponentId);
        if(Objects.nonNull(opponent)){
            // throw exception or do certain stuff
        }
        opponent.setHealth(opponent.getHealth() - hit);
        userIdToUserInfo.put(opponentId, opponent);
        idempotencyKeyToPresent.put(idempotencyKey, false);
    }


}
