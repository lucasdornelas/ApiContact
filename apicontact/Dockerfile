FROM openjdk:8-jre-alpine

MAINTAINER Lucas Dornelas <lmdornelas@gmail.com>

ADD ./target/api-contact-0.0.1-SNAPSHOT.jar /app.jar

ENV SPRING_PROFILES_ACTIVE=local

CMD java $JAVA_OPTS \
-Dserver.address=0.0.0.0 \
-Dserver.port=$PORT \
-Dspring.profiles.active=$SPRING_PROFILES_ACTIVE \
-jar /app.jarean
