# README

## How to run

- Build the war

`mvn clean package`

- Build a docker image

`docker build -t rest .`

- Docker run

`docker run -p 8080:8080 rest` 

- Test

`curl -X POST http://<the docker machine's IP>:8080/messages -H "Content-Type: application/json" -d '{"user":"foo", "message": "bar"}'`


## How to get docker machine's IP

Just open a Docker Quickstart Terminal, it will tell you which IP is.

