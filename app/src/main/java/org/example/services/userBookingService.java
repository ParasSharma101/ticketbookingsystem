package org.example.services;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.User;
import org.example.util.UserServiceUtil;


import java.util.*;
import java.io.File;
import java.io.IOException;
public class userBookingService {
    private User user;
    private List<User> userList;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final String USERS_PATH = "../localDb/users.json";
    public userBookingService(User user) throws IOException
    {
        this.user = user;
        File users = new File(USERS_PATH);
        userList = objectMapper.readValue(users, new TypeReference<List<User>>() {});
    }

    public Boolean loginUser(){
        Optional<User> foundUser = userList.stream().filter(user1 -> {
            return user1.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(), user1.getHashedPassword());
        }).findFirst();
        return foundUser.isPresent();
    }

    public Boolean signUp(User user1)
    {
        try{
            userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        }
        catch(IOException e){
            return Boolean.FALSE;
        }
    }

    private void saveUserListToFile() throws IOException {
        File usersFile = new File(USERS_PATH);
        objectMapper.writeValue(usersFile, userList);
    }



}
