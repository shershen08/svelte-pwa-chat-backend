package de.sperker.websocket.conversational.business;

import java.io.IOException;
import java.util.Set;

public interface SocketBoundary {
    Set<String> getClients();
    void sendMessageToClients(String message);
    void sendMessageToClient(String clientId, String message) throws IOException;
}
