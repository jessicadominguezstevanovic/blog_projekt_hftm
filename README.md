# blog_projekt_hftm Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

Zum starten: Projekt mit ./mvnw quarkus:dev einmal starten
Zugriffe testen:
- http://localhost:8080/hello
- http://localhost:8080/q/dev/
- http://localhost:8080/q/blog/


## Keycloak

Client secret von backend-service: Nak0wMyZLXSgre2QSrhdJhmvNr0D3j7S

Keycloak auch im Dev Mode brauchen zu können habe ich nur dank dieser Seite geschaft: https://quarkus.io/guides/security-keycloak-authorization
Ich habe noch nicht verstanden wieso er da etwas eigenes mit eigenem Realm aufbaut, statt einfach das von mir angegebene zu importieren. Ist nicht so tragisch, kann ja für dev immer wieder meins importieren. Nur etwas umständlich.

Bevor ich in die Klapse komme, weil mein Keycloak Container läuft, aber mein Quarkus container nicht laufen will mache ich hier einen Schnitt.
Fehlermeldung in Terminal

Was ich bisher gefunden habe:
    https://stackoverflow.com/questions/63224440/configuration-for-quarkus-and-keycloak-on-docker
    Frontend URL angeben
    Port 8080 verwenden?

## fat-JAR Erstellung
Erstellen von fat-JAR hat für mich mit folgendem Command nicht funktioniert:
    ./mvnw package -Dquarkus.package.type=uber-jar

Deshalb habe ich nach Quarkus doku mein application.properties File ergänzt mit folgender Zeile:
    quarkus.package.type=uber-jar
Dies hat mir eine .jar.ORIGINAL Datei erstellt in meinem Target Verzeichnis.

## Docker Image erzeugen
Beim Docker Image erzeugen achtung, ja nicht das Punkt am Ende folgendes Commands vergessen. Sonst kann man noch lange suchen wieso es nicht erzeugt wird ( . = Path):
    docker build -f src/main/docker/Dockerfile.jvm -t jessi/blog_projekt_hftm .

Was mich verwirrt: Wieso habe ich 2 images?

## Docker Image starten
docker run -i --rm -p 8080:8080 jessi/blog_projekt_hftm

*_*_*_*_*

Image kann wie folgt gestartet werden:
    docker run -i --rm -p 8080:8080 jessi/blog_projekt_hftm

## Berechtigungskonzept
Folgende Methoden sind für alle ohne Login zugänglich:
    willkommen
    blog
Folgende Methoden sind nur für eingelogte Benutzer zugänglich:
    blog post erstellen
    blog post löschen
    blog post suchen

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/blog_projekt_hftm-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides


## Provided Code

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
