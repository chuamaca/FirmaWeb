
# Proyecto Firma Electronica Entorno WEB

El objetivo principal de este proyecto es diseñar e implementar un sistema web de firma electrónica.


## Librerias usadas

#### *1. Maven Springboot*
##### 1.1. Repositorio Servicio API REST
  https://github.com/chuamaca/WSFirmaDigital

###### Servicio
```http
  POST /pki/firma
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `data` | `string` | **Required**. Formato de archivo PDF en Base64 |
| `nombre` | `string` | **Required**. Nombre de Archivo |

##### 1.2 Repositorio Servicio JAR.
  (https://github.com/chuamaca/JarFirmaDigital)

##

##### *2. Servlets y JSP*
###### 2.1. Aplicacion Web
  Plataforma de entorno WEB para la Administracion y gestion de Firmas electronicas.

##

#### *3. Lombok*
  Lombok es una librería para Java que proporciona anotaciones y funciones para reducir la cantidad de código boilerplate

#### *4. Apache Poi (Descargar Archivos Excel)*
  proporciona bibliotecas Java puras para leer y escribir archivos en formatos de Microsoft Office, como Word, PowerPoint y Excel.



