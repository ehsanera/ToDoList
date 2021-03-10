FROM openjdk:8-jre-alpine

ENV SERVER_PORT=80

EXPOSE 80
WORKDIR /data
ADD ./build/libs/ .
CMD ["java", "-cp", "./*", "todolist.MainKt"]
