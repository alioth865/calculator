# Calculator Service POC
Para solucionar esta prueba tecnica tengo pensado hacer uso de dos tecnicas
conocidas como API FIRST y TDD.
Para los concepto de API Fist usaremos OpenApi 3 y para autogenerar las clases 
usaremos OpenApI Plugin.

Pasos para generar el proyecto
- Ir a la carpeta lib
- Ejecutar el comando maven: mvn install:install-file -Dfile=tracer-1.0.0.jar -DgroupId=io.corp.calculator -DartifactId=tracer -Dversion=1.0.0 -Dpackaging=jarmvn install:install-file -Dfile=tracer-1.0.0.jar -DgroupId=io.corp.calculator -DartifactId=tracer -Dversion=1.0.0 -Dpackaging=jar
- Run command  mvn package

Pasos para lanzar el servicio
- Ir a la carpeta target
- java -jar calculator-0.0.1-SNAPSHOT.jar

Api Specification
http://localhost:8080/swagger-ui.html

Para parar el servicio
Ctrl + C


