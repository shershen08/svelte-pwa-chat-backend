# Conversational Websocke Server

Starts a websocket server (JSR-356) and command line interface to communicate with connected clients.

    The server listens by default on port __8080__ but might be changed via Spring profile or arguments.

The default WS endpoint is __/api/ws/__

As a test client [Telsocket](https://github.com/lafikl/telsocket) might be used.

## Used Libraries

- spring-boot-starter-web
- spring-websocket
- spring-shell-starter

## Build & Run

Run through maven:
```
$ mvn spring-boot:run  
```

Build and run as standalone:

```
$ mvn clean package
...
$ java -jar cws.jar 
```

## Commands

The following commands are implemented.

### Clients

List all connected clients by session id.

```
clients ⏎
```

### Broadcast

Send a message as broadcast to all connected clients.

```
broadcast 'hello to all' ⏎
```

### Unicast

Send a message as unicast to a specific client.

```
unicast 0 'hello client 0' ⏎
```