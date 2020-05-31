package de.sperker.websocket.conversational.model;

import lombok.Getter;
import lombok.Setter;

public class Message {
    @Getter
    @Setter
    String message;
    @Getter
    @Setter
    String username;
}
