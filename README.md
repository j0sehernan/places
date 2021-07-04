# Places
Actualmente la aplicación está conectada a Postgresql, pero basta con descomentar
```
Archivo application.properties
------------------------------
spring.datasource.url=jdbc:h2:mem:testdb

Archivo build.gradle.kts
------------------------------
runtimeOnly("com.h2database:h2")
```
y comentar las líneas
```
Archivo application.properties
------------------------------
spring.datasource.url=jdbc:postgresql://host:5432/places
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.username=homestead
spring.datasource.password=secret

Archivo build.gradle.kts
------------------------------
implementation("org.postgresql:postgresql")
```

## Servicios 🚀
A continuación se listan los llamados a los servicios probados en ambiente local

### Create User
```
curl --location --request POST 'http://localhost:8080/api/tyba/users' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=8F4A64E96AF9ABB78FC6B9C83CDD2BF3' \
--data-raw '{
    "first_name": "Gael",
    "last_name": "Quispe",
    "email": "gael@gmail.com",
    "password": "secret"
}'
```

### List Users
```
curl --location --request GET 'http://localhost:8080/api/tyba/users' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic Z2FlbEBnbWFpbC5jb206c2VjcmV0' \
--header 'Cookie: JSESSIONID=7DE081B10C7CBD8CBA1D4413AEB77D86'
```

### List Places
```
curl --location --request GET 'http://localhost:8080/api/tyba/places?type=restaurant&lat=-8.0991459&lng=-79.0493547&radius=10000' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=7DE081B10C7CBD8CBA1D4413AEB77D86' \
--data-raw '{
    "first_name": "Gael",
    "last_name": "Quispe",
    "email": "gael@gmail.com",
    "password": "secret"
}'
```

### List Transactions
```
curl --location --request GET 'http://localhost:8080/api/tyba/transactions' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic Z2FlbEBnbWFpbC5jb206c2VjcmV0' \
--header 'Cookie: JSESSIONID=7DE081B10C7CBD8CBA1D4413AEB77D86'
```

### Logout
```
curl --location --request GET 'http://localhost:8080/api/tyba/logout' \
--header 'Content-Type: application/json' \
```
