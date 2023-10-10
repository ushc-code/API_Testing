package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class AllEntityResponse {
    @JsonProperty("entity")
    public ArrayList<EntityResponse> allEntity;


}
