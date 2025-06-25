# Laboratory Sale Service transaction

## Description
This personal project aims to demonstrate how database transactions behave using Spring Boot and ORM (JPA/Hibernate). It focuses on practical scenarios where the absence of transactional boundaries causes inconsistent data states.



## Architecture

This project uses a modular structure:
- **Product** and **Stock** are related via FK.
- Only one exposed endpoint exists: `/api/v1/sale/create`
- `Product` is preloaded via Liquibase migrations.


## Client HTTP test Request

Currently, I am using [Bruno](https://www.usebruno.com/) to test my request, but you can use any client http

### Example of payload

```bruno
{
  "customer": "jhon.doe",
  "items": [
    {
      "product": {
        "productId": 1,
        "price": 100
      },
      "quantity": 1
    }
  ]
}

```

### collection

Also, You can import the collection, it is located in this path.

```cmd
cd ./ecommerce-sale-service
```

choose file **bruno.json**
exporting using your favorite client HTTP





## Running locally


### Before running

> **Note:** Must create a network using docker

```bash
docker network create backend-net
```

> **Note:** Must Compile Java and generate Java File

Must located in this path

```maven
cd sale-service/
mvn clean install
```

### Steps for running

Located in this path

```cmd
cd docker-compose
```

> **Linux:** 
Set the needs allow.


```sh
chmod +x start.sh
```

> **Note:** Should execute this script


```sh
./start.sh
```

