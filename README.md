# Dto-Dao

Este repositorio contiene una implementación del patrón **DTO-DAO** en Java, utilizando Spring Framework para la gestión de la persistencia de datos. Este patrón ayuda a separar la lógica de acceso a datos (DAO) de los objetos de transferencia de datos (DTO), facilitando la escalabilidad y el mantenimiento del código.

## Estructura del Proyecto

El proyecto está organizado en varias capas que representan diferentes aspectos de la arquitectura:

- **DTO**: Contiene clases de objetos de transferencia de datos que representan la información que se va a transferir entre el cliente y el servidor.
- **DAO**: Contiene las interfaces y clases que implementan la lógica de acceso a datos.
- **Service**: Incluye la lógica de negocio que interactúa con los DAO para realizar operaciones sobre los DTO.
- **Controller**: Maneja las solicitudes HTTP y dirige las operaciones a los servicios correspondientes.

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal.
- **Spring Boot**: Framework para simplificar el desarrollo de aplicaciones en Java.
- **Spring Data JPA**: Para facilitar la interacción con la base de datos.
