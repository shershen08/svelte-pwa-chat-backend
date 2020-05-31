package de.sperker.websocket.conversational.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class User {
    @Getter
    @Setter
    String id;
    @Getter
    @Setter
    String username;
}
