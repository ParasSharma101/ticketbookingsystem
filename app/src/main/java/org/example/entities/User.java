package org.example.entities;
import java.util.*;
public class User {
    private String name;
    private String hashedPassword;
    private List<Ticket> tickets_Booked;
    private String userId;

    public String getName(){
        return name;
    }

    public String getHashedPassword()
    {
        return hashedPassword;
    }
}
