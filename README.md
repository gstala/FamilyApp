## Family app ##
 
 Test application for Inteca

## Prerequisites ##
- Installed [Docker](https://www.docker.com/)
- Installed [Maven](https://maven.apache.org/)

## Building and running
1. Go to project folder and build project using :
 ```bash
 mvn clean package
 ```
 2. Run container with database.
  ```bash
docker run -d --name db -e MYSQL_ROOT_PASSWORD=rootpassword -e MYSQL_DATABASE=family -e MYSQL_USER=admin -e MYSQL_PASSWORD=admin mysql:5.6
 ```
 3. Run container with spring boot application
  ```bash
docker run -d --name backend -p 8080:8080 --link db:db inteca/family-backend
 ```
 4. Run container with angular 
   ```bash
docker run -d --name frontend --link backend:backend -p 80:80 inteca/family-frontend
 ```
 5. Go to [localhost:80](http://localhost:80)
 
