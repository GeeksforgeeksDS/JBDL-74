package com.example.L8.controller;


import com.example.L8.config.DummyConfig;
import com.example.L8.entities.UserInfo;
import com.example.L8.models.CreateUserRequest;
import com.example.L8.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@RestController("USER_CONTROLLER_V2") // @Controller +     @ResponseBody
@Slf4j
public class UserControllerV2 implements DisposableBean {



    @Autowired
    private UserService userService;

    @Autowired
        private DummyConfig dummyConfig;

    /**
     *
     * Bean
     *    Create an object of class
     *      -->
     *      UserController dksmdk = new UserController();
     *      initializing / create a bean. (Spring does it automatically)
     *
     *
     * @throws Exception
     */

    /**
     *
     * --> when disposed off (before)
     * @throws Exception
     */

    @Override
    public void destroy() throws Exception {
        // this is generally used to shut down the executor service

    }







    /**
     *
     * CRUD
     * Create -  POST
     * read  - GET
     * update - PUT
     * delete - DELETE
     *
     *  GET , PUT , POST , DELETE , PUT , PATCH
     *
     *
     *      ----> findUserById
     *
     *      SOLID
     *
     *      S single responsibility
     *
     *                  Controller                          Service                     Repository
     *                      -------->>  (id) as input
     *                                              -----------------------------> check if any user exists with that id
     *                                        UserInfo      <----------------------------
     *                        <-----------(ok it exists)
     *                                          throw exception(it does not exists)
     *
     *
     *              (things interacting with dispatcher sevlet)
     *                                                      business logic
     *                                                                                  is a wrapper over the Dao layer / DB layer
     *
     *
     *
     *
     *
     * UserInfo userInfo = userIdToUserInfo.get(id);
     *         if(Objects.isNull(userInfo)){
     * //            return new ResponseEntity<UserInfo>(HttpStatus.NOT_FOUND);
     *             return new ResponseEntity<UserInfo>(HttpStatus.BAD_REQUEST);
     *         }
     *         return new ResponseEntity<UserInfo>(userInfo, HttpStatus.OK);
     *
     *
     *      Path Variable :
     *
     *
     *
     *
     *      Request Param :
     *
     *
     *
     *  find all the users having name starting with 'Sam'
     */

    @GetMapping(value = "/{id}")
    public UserInfo findUser(@PathVariable("id") String id){
        return userService.fetchUserInfo(id);
    }


    /**
     * Data
     *  --> genre books --> cooking , thriller ,
     *  --> author --> name ()
     *
     *
     *      ----> /libraries/{library}/books?genre=cooking&authorName=Joey
     *
     *
     *      Jubliant foods --> own dominos
     *
     *      /dominos/{dominos}/employees/{employee}/salary
     *
     * @param nameStartsWith
     * @return
     */
//    @GetMapping(value = "/")
//    public List<UserInfo> findUsers(@RequestParam("nameStartsWith") String nameStartsWith){
//        return userService.findAllTheUsersWithNameStartingWith(nameStartsWith);
//    }



    @PostMapping("/")
    public UserInfo createUser(@RequestBody CreateUserRequest request){
        log.info(" received request {} ", request);
        return userService.createUser(request);
    }


    @PostMapping("/v2/")
    public ResponseEntity<UserInfo> createUserV2(@RequestBody CreateUserRequest request){
        log.info(" received request {} ", request);
        return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);
    }

    /**
     *
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
     *
     *
     *     *  Beans created
     *  Controller absc = new Controller();
     *
     *
     *  Application context is ;
     *
     *          ----> it is same as IOC container
     *                                  ------> IOC --> inversion of control
     *                                                  ----> laymay to say IOC
     *                                                          --> we do not have to manually define the beans
     *                                                              spring takes of it and manages the lifecycle of the beans
     *
     *
     *
     *  IOC --> creation of beans
     *
     *      application
     *          HashMap<"nameOfTheBean", instanceOfBean>
     *                 <restTemplate><$$restTemplate1>
     *              // or by the name that has been specified by the developer
     *
     *
     *  2 ways to create a bean in springboot
     *
     *          --> @Component (Directly / indirectly)
     *                      class level
     *
     *                      (rest template and invoke 3rd party apis)
     *          --> @Bean
     *              method level
     *
     *
     *  create a bean and injected into application context
     *      instansitation
     *      UserController controll = new UserController()
     *
     *      inject --> Dependency Injection
     *
     *      IOC container // Application context
     *          ("UserController", Usrerb@839283);
     *
     *
     *
     *
     * @param nameStartsWith
     * @return
     */


    /**
     *  ResponseEntity && MVC
//     * @param nameStartsWith
     * @return
     */


    @GetMapping(value = "/dummy/")
    public String dummy(){
        return "<html><body> <h1 style=\"color:red\">" + UUID.randomUUID().toString() + " </h1></body></html>";
    }

    @GetMapping(value = "/dynamic/")
    public ModelAndView dynamic(){
        ModelAndView modelAndView = new ModelAndView("DynamicSample.html");
        modelAndView.addObject("name",   UUID.randomUUID().toString());
        return modelAndView;
    }

    @GetMapping(value = "/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(){
        RestTemplate restTemplate = dummyConfig.restTemplate();
        log.error(" rest Template {} ", restTemplate);
        return restTemplate.getForObject("https://picsum.photos/id/237/200/300", byte[].class);
    }


    /**
     public RestTemplate restTemplate(){
     return new RestTemplate();
     }

     10 --> how many instances of rest tempalte
     -   1
     -  5
     -   10
     - do not know .... ()
     *
     *  1 ...
     *
     */
}
