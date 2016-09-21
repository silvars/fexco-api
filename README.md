FEXCO API - REST Services
================================

Project developed as a test for FEXCO company.

Goal: Develop a docker service API to query for addresses based on Their Eircode ( Irish post code ) using the third party API.

Requirements
------------

* [Java Platform (JDK) 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Apache Maven 3.x](http://maven.apache.org/)
* [Docker] (https://www.docker.com/)

Quick start ('Curl Script'.)
----------------------------

1. `mvn clean install`
2. `java -jar target/fexco-eircode-api-0.0.1.jar`
3. Go to: {your_path}/fexco-api/curl
4. Run sh curl.sh
5. For results, check {your_path}/fexco-api/curl/output.txt

If you want to ADD/REMOVE/CHANGE defined URLs, check {your_path}/fexco-api/curl/URLs.txt 

Build a tagged docker image.
----------------------------

1. `mvn package docker:build -DpushImage`
2. Go to: {your_path}/fexco-api/curl
3. run sh curl.sh
4. For results, check {your_path}/fexco-api/curl/output.txt


Change API Key
----------------------------
1. Open the file > {your_path}/fexco-api/src/main/resources/eircode.properties
2. Change the key: eircode.searchKey putting your valid APY Key.

 
Hope you enjoy!