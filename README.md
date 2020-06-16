# Backend for svelte-pwa-chat 

Java/Spring service to provide websocket base chat API. Also has endpoint to update user profile details and list all users.

Complimentary frontend code: https://github.com/shershen08/svelte-pwa-chat

## Usage

Build: `mvn build`

Start: `java -jar target/cws.jar`

App will start on port 8080 (can be adjusted in .properties file)

## API

Connect to websocket: `/api/ws`

List users: `/api/users`

Set username : POST `/api/profile`

Swagger URL: `/api/swagger-ui.html`


## Forked from

Forked from https://github.com/hsperker/conversational-websocket-server
