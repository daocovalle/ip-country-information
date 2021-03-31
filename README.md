# Country IP Information developer guide

#Dev Tecnologies:
* Java
* Spring Boot
* SpringJPA
* Postgres
* AWS EC2
* AWS S3
* AWS RDS

#Test tecnologies
* JUnit 5
* Mockit

## Install the necessary programs ##

* Install Java 11
* You can use gradle wrapper (gradlew) to build the projects or install apt install gradle

## Install Project ##

1. [Install Eclipse](https://www.eclipse.org/downloads/) or [Spring Tool Suite](https://spring.io/tools/sts/all) or your favorite IDE
2. If you are using Eclipse, go to *Help/Marketplace* and install Spring Tools
3. Change text file encoding to UTF-8 in Eclipse or Spring Tool Suite.
4. Download repo
	* Clone [ip-module](https://github.com/daocovalle/ip-information)

5. Install docker and docker-compose
    * In linux machine use 
	                      ```install-docker
						     apt install docker.io
						     apt install docker-compose```
## Services

1. api-gateway -> is the entry point to consume the API, here you can enable or disable paths to consume with propertie: allowd-paths
2. ip-blacklist -> Service to save a new IP or consult an IP From database in blacklists IP table [swagger](http://13.59.79.74:8090/swagger-ui/index.html)
3. ip-information -> Service with the final endpoint to user, return the information of countries, for more details check [swagger](http://13.59.79.74:8092/swagger-ui/index.html)

## Libraries

1. blacklist-library -> Is the connection client to service ip-blacklist
2. coin-information-library -> Is the connection client to rest service to consult coins: http://data.fixer.io/api/latest
3. country-information-library -> Is the connection client to rest service to consult country information: https://restcountries.eu/rest/v2/alpha/
4. ip-geolocation-library -> Is the connection client to rest service to consult geolocation of an IP: https://api.ip2country.info

__NOTE__ for more details please refers to [Architecture Diagram](https://github.com/daocovalle/ip-information/tree/main/doc/diagrams/architecture) and [Secuence Diagram](https://github.com/daocovalle/ip-information/tree/main/doc/diagrams/sequence)

## Folders

The properties are loaded to Spring using external yml located in

* /etc/mercadolibre/conf/

start script is located in path:

* /opt/mercadolibre/

current Dockerfile, docker-compose.yml are located in: 

* /opt/mercadolibre/ipinformation
* /opt/mercadolibre/api-gateaway
* /opt/mercadolibre/blacklist

current jars versions are located in:

* /opt/mercadolibre/ipinformation/build/libs
* /opt/mercadolibre/api-gateaway/build/libs
* /opt/mercadolibre/blacklist/build/libs

__Note:__  for new version use these folders or change start script:

### Database Configuration

* Install PostgreSQL
* Create database

```sql
CREATE USER mercadolibre WITH PASSWORD 'password';
CREATE DATABASE mercadolibre WITH OWNER = mercadolibre;
```
__Note:__ Replace _password_  with the values configured in dev environment (check ip-blacklist.yml).

### Run service

execute:
```start-services
/opt/mercadolibre/start.sh
```
##Check services

```check process and logs
docker ps
docker logs -f ip-blacklist
docker logs -f api-gateway
docker logs -f ip-information
```

or additional you can check the health of services and create alarms for it:

```health
    curl HOST:8090/actuator/health  #ip-blacklist
	curl HOST:8092/actuator/health  #ipinformation
```

Test service with:

```health
http://HOST:8091/country-information?ip=2.22.160.0
http://13.59.79.74:8091/country-information?ip=2.22.160.0
```
