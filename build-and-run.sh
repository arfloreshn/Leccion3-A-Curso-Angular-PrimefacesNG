#!/bin/bash
LABEL=$(date +'%Y%m%d-%H%M%S')
mvn clean package && docker build -t com.cine.hn/cines:$LABEL .
docker rm -f cines || true && docker run -it -p 8080:8080 -p 4848:4848 --name cines com.cine.hn/cines:$LABEL

