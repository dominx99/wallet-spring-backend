FROM maven:3.8.3-openjdk-17 as maven

WORKDIR /app
COPY ./target/wallet-0.0.1-SNAPSHOT.jar /app
