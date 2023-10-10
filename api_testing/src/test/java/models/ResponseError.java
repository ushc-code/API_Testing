package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseError {
    @JsonCreator
    public ResponseError(@JsonProperty("error") String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String errorMessage;
}
