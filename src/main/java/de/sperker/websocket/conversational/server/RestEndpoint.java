package de.sperker.websocket.conversational.server;

import de.sperker.websocket.conversational.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.Session;
import java.util.Map;


@RestController
// @Produces({MediaType.APPLICATION_JSON})
@RequestMapping(value = "/list")
public class RestEndpoint {

    @Autowired
    WebsocketEndpoint websocketEndpoint;

    private static String convertWithIteration(Map<String, Session> map) {
        StringBuilder mapAsString = new StringBuilder("{");
        for (String key : map.keySet()) {
            mapAsString.append(key + "=" + map.get(key).getId() + map.get(key).isOpen() + ", ");
        }
        mapAsString.delete(mapAsString.length()-2, mapAsString.length()).append("}");
        return mapAsString.toString();
    }

    @GetMapping
    public String getTestData() {
        User user = new User("1", "Mike");

        Map<String, Session> listUsers = websocketEndpoint.getSessionIndex();

        if(listUsers.isEmpty()) {
            return "no users connected";
        } else {
            String userList = RestEndpoint.convertWithIteration(listUsers);
            System.out.print("test data");
            System.out.print(userList);

            return userList;
        }
    }
}