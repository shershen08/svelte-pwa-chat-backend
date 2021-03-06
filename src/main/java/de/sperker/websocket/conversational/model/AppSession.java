package de.sperker.websocket.conversational.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.websocket.Session;
import java.util.Date;

@AllArgsConstructor
public class AppSession {
    @Getter
    @Setter
    Session session;
    @Getter
    @Setter
    User user;
    @Getter
    @Setter
    Date lastActive;
}
