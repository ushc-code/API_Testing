package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Entity {
    @JsonProperty("addition")
    public Addition addition;
    @JsonProperty("important_numbers")
    public int[] importantNumbers;
    @JsonProperty("title")
    public String title;
    @JsonProperty("id")
    public String id;
    @JsonProperty("verified")
    public Boolean verified;


    public Entity(Addition addition, int[] importantNumbers, String title, Boolean verified) {
        this.addition = addition;
        this.importantNumbers = importantNumbers;
        this.title = title;
        this.verified = verified;
    }


}
