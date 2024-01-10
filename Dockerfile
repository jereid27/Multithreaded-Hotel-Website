FROM ubuntu:latest
LABEL authors="User"

COPY /Users/User/IdeaProjects/d387-advanced-java/target/D387_sample_code-0.0.2-SNAPSHOT.jar app.jar


ENTRYPOINT ["java", "-jar", "/app.jar"]