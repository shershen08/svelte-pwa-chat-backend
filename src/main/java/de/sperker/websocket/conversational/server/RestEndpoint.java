package de.sperker.websocket.conversational.server;

import de.sperker.websocket.conversational.model.AppSession;
import de.sperker.websocket.conversational.model.User;
import de.sperker.websocket.conversational.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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
            return new ResponseEntity<>("Profile updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Incorrect profile id", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<UserData>> getUsersList() {

        Map<String, AppSession> listUsers = websocketEndpoint.getSessionIndex();
        List<UserData> userList = Collections.emptyList();

        if(listUsers.isEmpty()) {
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } else {
            userList = listUsers.values().stream()
                    .map(x -> new UserData(x.getUser(), x.getLastActive()))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(userList, HttpStatus.OK);
        }
    }
}