package de.sperker.websocket.conversational.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.websocket.Session;

@AllArgsConstructor
public class AppSession {
    @Getter
    @Setter
    Session session;
    @Getter
    @Setter
    User user;
}
