package de.sperker.websocket.conversational.server;

import de.sperker.websocket.conversational.model.AppSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class RestEndpoint {

    @Autowired
    WebsocketEndpoint websocketEndpoint;

    private static String convertWithIteration(Map<String, AppSession> map) {
        StringBuilder mapAsString = new StringBuilder("");
        for (String key : map.keySet()) {
            mapAsString.append(map.get(key).getUser().toString() + ", status: " + map.get(key).getSession().isOpen() + "; ");
            //mapAsString.append(key + " >> name: " + map.get(key).getUser().getUsername() + ", status: " + map.get(key).getSession().isOpen() + "; ");
        }
        // mapAsString.delete(mapAsString.length()-2, mapAsString.length());
        return mapAsString.toString();
    }

    @PostMapping(value = "/profile")
    public ResponseEntity<String> getTestData(@RequestParam String name, @RequestParam String id) {

        Map<String, AppSession> listUsers = websocketEndpoint.getSessionIndex();

        if(listUsers.containsKey(id)) {
            listUsers.get(id).getUser().setUsername(name);
            return new ResponseEntity<>("profile updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("incorrect id", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/users")
    public ResponseEntity<String> getUsersList() {

        Map<String, AppSession> listUsers = websocketEndpoint.getSessionIndex();

        if(listUsers.isEmpty()) {
            return new ResponseEntity<>("no users connected", HttpStatus.OK);
        } else {
            String userList = RestEndpoint.convertWithIteration(listUsers);
            return new ResponseEntity<>(userList, HttpStatus.OK);
        }
    }
}