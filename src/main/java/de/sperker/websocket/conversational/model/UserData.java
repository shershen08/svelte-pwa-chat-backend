package de.sperker.websocket.conversational.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
public class UserData {
    @Getter
    @Setter
    User user;
    @Getter
    @Setter
    Date lastActive;
}
