package org.example.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.*;

public class Train {
    private String trainId;
    private String trainNo;
    private String departure_Time;
    private String arrival_Time;
    private List<List<Boolean>> seats;
}
