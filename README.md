# Ejercicio mutantes

Brotherhood es una app para analizar adn. 

Consta de un endpoint el cual analiza si el adn recibido corresponde a un humano o un mutante y otro endpoint que devuelve estadisticas en base a los adn provistos.

Tecnologías usadas:
* Java8
* MongoDB
* Memcached
* RabbitMQ

## Cómo levantar la app

* Para levantar una instancia de la app de manera local, se debe contar con docker:
1. Bajar el archivo docker-compose.yml
2. Desde la consola y en la ruta donde se encuentra el archivo, ejecutar:
```bash
docker-compose up
```
* Para levantar la app localmente, se debe contar con docker y java8:
1. Clonar el repositorio
2. Desde la consola y en la ruta donde se encuentra el repo, ejecutar:
```bash
docker-compose up
```
3. En application.properties:
```bash
server.port=8081
#memcached.url.connection=memcached:11211
spring.rabbitmq.host=rabbitmq
memcached.url.connection=localhost:11211
```
4. bootRun de la app

## URL's

AWS Amazon:

- http://ec2-52-15-229-79.us-east-2.compute.amazonaws.com/mutant
 
 body:
 ```bash
{
"dna":["ATGCGT", "CCGTAC", "TTGTGT", "AGAGTG", "CCTCCA", "TCACTG"]
}
```
- GET - stats: http://ec2-52-15-229-79.us-east-2.compute.amazonaws.com/stats


Local:

 - POST - mutant: http://localhost:8081/mutant
 
 body:
 ```bash
{
"dna":["ATGCGT", "CCGTAC", "TTGTGT", "AGAGTG", "CCTCCA", "TCACTG"]
}
```
- GET - stats: http://localhost:8081/stats



## Especificaciones

[Examen Mercadolibre 2017 - Mutantes.pdf](https://github.com/gylopezgiles/brotherhood/blob/master/Examen%20Mercadolibre%202017%20-%20Mutantes.pdf)
