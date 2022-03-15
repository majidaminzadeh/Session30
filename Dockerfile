FROM openjdk:8
EXPOSE 8091
ADD target/docker-test.jar docker-test.jar
ENTRYPOINT ["java", "-jar", "/docker-test.jar"]
