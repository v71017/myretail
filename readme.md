# myRetail Spring Boot Restful application

The application is developed using spring boot application framework to manage product information to an internal data store.

## Pre-requesties

* Spring boot 2.2.3
* MongoDB

> Note: It is using  embeeded mongodb plug-in for MongoDB database.

## Step to install

1. Clone the code to local folder
* a. git clone https://github.com/v71017/myretail.git
* b. cd myretail/

* Note : Export the maven
** export M2_HOME="/Users/pvidyapati/Downloads/apache-maven-3.6.3"
** export PATH=${PATH}:${M2_HOME}/bin

* c. execute below command : 
    mvn package

2. **Run the backend app using below command

java -jar target/myretail-0.0.1-SNAPSHOT.jar

The backend server will start at <http://localhost:8080>.

3. Swagger is avaiable in the link

http://localhost:8080/swagger-ui.html#/product45controller

Examples to post data :

```bash
curl --location --request POST 'localhost:8080/products' \
--header 'Content-Type: application/json' \
--data-raw '{"id":123,"name":"product1","current_price":{"value": 11.00,"currency_code":"INR"}}'
```

```bash
curl --location --request POST 'localhost:8080/products' \
--header 'Content-Type: application/json' \
--data-raw '{"id" : 456, "name": "product2", "current_price" : {"value" : 12.00, "currency_code": "USD"}}'
```

Example to get data by id:

```bash
curl --location --request GET 'localhost:8080/products/123'
```

Example to update data:

```bash
curl --location --request PUT 'localhost:8080/products/123' \
--header 'Content-Type: application/json' \
--data-raw '{"id":123,"name":"product3","current_price" : {"value" : 22.00, "currency_code": "INR"}}'

Swagger

