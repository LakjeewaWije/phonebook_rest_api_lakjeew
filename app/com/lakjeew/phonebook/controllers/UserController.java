package com.lakjeew.phonebook.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.lakjeew.phonebook.dao.UserDao;
import com.lakjeew.phonebook.dao.impl.UserDaoimpl;
import com.lakjeew.phonebook.models.User;
import com.lakjeew.phonebook.services.UserService;
import com.lakjeew.phonebook.services.impl.UserServiceImpl;
import com.lakjeew.phonebook.util.JsonServiceUtil;
import com.lakjeew.phonebook.util.ResponseWrapper;
import play.Logger;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

public class UserController extends Controller{

    @Inject
    private ObjectMapper objectMapper;

    @Inject
    private UserService userService;
    /**
     * Save user to databases from the request(Use hard coded user)
     * @return user saved in the database
     */
    @BodyParser.Of(BodyParser.Json.class)
    public Result addUser(){
        JsonNode jsonNode = request().body().asJson();

        User userToAdd = null;

        try {
            userToAdd = objectMapper.treeToValue(jsonNode, User.class);


            UserService userService = new UserServiceImpl();

            User addUser = userService.addUser(userToAdd);

            return ok("user added");


        } catch (JsonProcessingException e) {
            Logger.error(e.getMessage());
            return badRequest("Not a json");
        }

//        User usertosave = new User();
//        usertosave.setuFirstname("jon");
//        usertosave.setuLasttname("van");
//        usertosave.setuEmail("333@gmail.com");
//        usertosave.setuPassword("323");
//        usertosave.setuPhoneno("12155121");
//
//        UserDao userDao = new UserDaoimpl();
//
//        User addedUser = userDao.addUser(usertosave);
//        return ok("successfully added");

    }

    /**
     * This is to update user in database
     * @return updated user in the database
     */
    @BodyParser.Of(BodyParser.Json.class)
    public Result updateUser(){
        JsonNode jsonNode = request().body().asJson();

        User userToUpdate = null;

        try {
            userToUpdate = objectMapper.treeToValue(jsonNode, User.class);

            UserService userService = new UserServiceImpl();

            User updatedUser = userService.updateUser(userToUpdate);

            return ok("user Updated");


        } catch (JsonProcessingException e) {
            Logger.error(e.getMessage());
            return badRequest("Not a json");
        }
    }
    /**
     *  This is to delete user from database
     * @return Deleted user
     */
    public Result deleteUser(long idToDelete){

        User deletedUser = userService.deleteUser(idToDelete);

        if (deletedUser == null){
            return badRequest(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("No user for the id", null)));
        }

        return ok(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("User deleted", deletedUser)));

    }
}
