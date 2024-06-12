## Projeto uShorter (Encurtador de URL)

### Visão geral

Este projeto é um aplicativo URL Shortener construído usando uma arquitetura moderna de microsserviços. O aplicativo permite que os usuários encurtem URLs e rastreiem contagens de acesso. Os principais componentes deste aplicativo incluem:

- **NoSQL Database**: Apache Cassandra
- **API Gateway**: Spring Cloud Gateway
- **Service Discovery**: Spring Eureka Discovery
- **Backend**: Spring Boot
- **Frontend**: Ionic e Angular
- **Web Server**: Nginx

### Estrutura do projeto

### Requisitos.

- Java 21 OpenJDK
- Maven
- Node.js 20.14.0
- Cassandra
- Docker
- IntelliJ IDEA (STS, VS code)
- Nginx

Obs: todos os serviços estão em docker.

### Começando

#### Configurando a base de dados

### Executando a aplicação

#### Executando em Docker

1. Builde todas as imagens para rodar o serviço e crie a rede.

```bash
docker compose build
docker network create shared_network
```

2. Inicie o banco de dados

```bash
docker compose up cassandra
```

Após isso é necessário criar

```sh
docker exec -it cassandra cqlsh`
```

```sql
CREATE KEYSPACE IF NOT EXISTS ushort
WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

USE ushort;

CREATE TABLE IF NOT EXISTS tinyurl (
    code text PRIMARY KEY,
    originalURL text,
    creationDate timestamp
);

CREATE TABLE IF NOT EXISTS access_count (
    request_identifier TEXT,
    access_timestamp TIMESTAMP,
    code TEXT,
    PRIMARY KEY ((request_identifier), code)
) WITH CLUSTERING ORDER BY (code DESC);
```

3. Inicie o service discovery

   ```bash
    docker compose up eureka-server
   ```

4. Inicie o API Gateway

```bash
    docker compose up gateway-server
```

5. Inicie o back-end

```bash
    docker compose up ushorter
```

6. Inicie o front-end

```bash
    docker compose up ushortng
```

#### API back-end

Variaveis de ambiente:

```
CASSANDRA_KEYSPACE_NAME: The name of the Cassandra keyspace (e.g., url_shortener).
CASSANDRA_LOCAL_DATACENTER: The name of the local datacenter for Cassandra (e.g., datacenter1).
CASSANDRA_POINTS: The contact points for Cassandra (e.g., localhost).
CASSANDRA_PORT: The port number for Cassandra (e.g., 9042).
CASSANDRA_USER: The username for Cassandra authentication.
CASSANDRA_PASSWORD: The password for Cassandra authentication.
CASSANDRA_SCHEMA_ACTION: The schema action for Cassandra (e.g., create).
APP_PORT: The port number for the application (e.g., 8080).
EUREKA_CLIENT_ENABLED: Enable Eureka client (e.g., true).
EUREKA_SERVER_URL: The URL of the Eureka server.
APP_CORS_HEADERS: Allowed CORS headers (e.g., Content-Type,Authorization).
APP_CORS_ORIGINS: Allowed CORS origins (e.g., http://localhost:8100).
APP_CORS_METHODS: Allowed CORS methods (e.g., GET,POST,PUT,DELETE).
```

#### API Gateway

Variaveis de ambiente:

```

APP_PORT: The port number for the application (e.g., 8080).
EUREKA_CLIENT_ENABLED: Enable Eureka client (e.g., true).
EUREKA_SERVER_URL: the URL of the eureka server
USHORT_BACK_ADDRESS: The URL of the back-end.
GATEWAY_CORS_HEADERS: Allowed CORS headers (e.g., Content-Type,Authorization).
GATEWAY_CORS_ORIGINS: Allowed CORS origins (e.g., http://localhost:8100).
GATEWAY_CORS_METHODS: Allowed CORS methods (e.g., GET,POST,PUT,DELETE).
```

#### Discovery Server

Variaveis de ambiente:

```

UDISCOVERY_PORT: The port number for the application (e.g., 8080).
EUREKA_CLIENT_ENABLED: Enable Eureka client (e.g., true).
EUREKA_SERVER_HOSTNAME: the name of instance
USHORT_BACK_ADDRESS: The URL of the back-end.
EUREKA_SERVER_URL: the URL of the eureka server.
```

### Licensa

This project is licensed under the MIT License.

---
