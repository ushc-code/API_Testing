package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Addition {
    public String id;
    public String additionalInfo;
    public Integer additionalNumber;

    public Addition(String additionalInfo, Integer additionalNumber) {
        this.additionalInfo = additionalInfo;
        this.additionalNumber = additionalNumber;
    }

    @JsonCreator
    public Addition(@JsonProperty("additional_info") String additionalInfo, @JsonProperty("additional_number") Integer additionalNumber, @JsonProperty("id") String id) {
        this.additionalInfo = additionalInfo;
        this.additionalNumber = additionalNumber;
        this.id = id;
    }
}
