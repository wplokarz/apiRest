package org.example.pojoClasses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Board {

    @JsonProperty
    private String boardID;

    @JsonProperty
    private String name;

    public Board (String boardID, String name) {
        this.boardID = boardID;
        this.name = name;
    }

}
