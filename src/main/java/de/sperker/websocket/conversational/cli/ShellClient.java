package de.sperker.websocket.conversational.cli;

import de.sperker.websocket.conversational.business.CliBoundary;
import de.sperker.websocket.conversational.business.SocketBoundary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.IOException;
import java.util.Set;

@ShellComponent
public class ShellClient implements CliBoundary {

    @Autowired
    private SocketBoundary socketBoundary;

    @ShellMethod("Send message to all clients")
    public void broadcast(@ShellOption String msg) {
        this.socketBoundary.sendMessageToClients(msg);
    }

    @ShellMethod("Send message to a defined client")
    public void unicast(@ShellOption String id, @ShellOption String msg) throws IOException {
        this.socketBoundary.sendMessageToClient(id, msg);
    }

    @ShellMethod("Get client ids")
    public Set<String> clients() {
        return this.socketBoundary.getClients();
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}
