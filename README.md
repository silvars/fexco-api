FEXCO API - REST Services
================================

Project developed as a test for FEXCO company.

Goal: Develop a docker service API to query for addresses based on Their Eircode ( Irish post code ) using the third party API.

Requirements
------------
* [Java Platform (JDK) 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Apache Maven 3.x](http://maven.apache.org/)

Quick start
-----------
1. `mvn clean install`
2. `java -jar target/fexco-eircode-api-0.0.1.jar`

Quick start
3. Go to: {your_path}/fexco-api
4. `curl -X POST -d '{ "id": "test_id", "password": "test_password" }' http://localhost:8080/user`
5. Refresh the page