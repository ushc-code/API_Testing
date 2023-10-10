package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class EntityResponse {
    public Addition addition;
    public ArrayList<Integer> importantNumbers;
    public String title;
    public String id;
    public Boolean verified;

    @JsonCreator
    public EntityResponse(@JsonProperty("addition") Addition addition, @JsonProperty("important_numbers") ArrayList<Integer> importantNumbers, @JsonProperty("title") String title, @JsonProperty("id") String id, @JsonProperty("verified") Boolean verified) {
        this.addition = addition;
        this.importantNumbers = importantNumbers;
        this.title = title;
        this.id = id;
        this.verified = verified;

    }
    public String toString(EntityResponse entityResponse) {
        return "{" + entityResponse + "}";
    }
}
