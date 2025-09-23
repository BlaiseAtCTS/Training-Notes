# Docker
Docker file: template to build image.
Docker compose: to manage multiple container for microservices.
```
FROM {image}:{tag} --> cached layer 1 (like httpd:2.4) --> apache v2.4

WORKDIR /app --> the directory where to run all the commands after this

RUN apk add python3 --> installs things when image is building

CMD ['google.com'] --> executes when container is running. adds additioanl parameters to ENTRYPOINT.

ENTRYPOINT ["ping", "-c", "5"] --> executes when container is running. eg. running the webserver is gonna be the main command, so run it using ENTRYPOINT, if webserver crashes, container stops.

COPY . /var/www/html/
(or)
ADD --> automatically extracts tar files. supports remote url (but dont use it, as it doesnt support connection dropouts)

EXPOSE 80
```

docker image ls
docker image rm {image-id}
docker image rm $(docker image ls -aq) --> delete (-q (quiet) show only container id) (-a (all) shows all containers including stopped ones)
docker container ls (or) ps
docker container stop {image-id}
docker container stop $(docker container ls -aq)
docker container prune --> remove all stopped containers

docker image build . -t myImage:1 ('.' means build context - where its building from)
docker image build -f Dockerfile.prod . -t myCustomImage:1 --> -f to give custom name for Dockerfile
docker image tag myImage:1 myImage:2 --> change tag name
docker container run -p 8080:80 myImage:2 (or) myImage

docker container run -p 8080:80 myImage:1 --> 8080: its the port to open in host, 80 is port to open in container (if you dont specify -p it will use port 80 of host)
docker container run -p 8080:80 --name=mywebserv myImage:1 --> custom name. docker assigns random name by default
docker container run -d -P 80 myImage:1 --> -P chooses random port to open in host. -d is detached mode(runs in background)

Volume Mounts: docker container run -p 8080:80 -v /Users/donbo/Documents/Docker/website:/usr/local/apache2/htdocs myWebServer:1
Any change u make in files will be reflected to image.

Logging in to the container: Eg. if you want to login to the linux container: 
docker container exec -it {container-id} /bin/bash (-i (interactive mode) received messages from container, -t(terminal) send keyboard input to container), /bin/bash is the command to execute.