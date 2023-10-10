package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Entity {
    public Addition addition;
    @JsonProperty("important_numbers")
    public int[] importantNumbers;
    public String title;
    public String id;
    public Boolean verified;


    public Entity(Addition addition, int[] importantNumbers, String title, Boolean verified) {
        this.addition = addition;
        this.importantNumbers = importantNumbers;
        this.title = title;
        this.verified = verified;
    }
}
