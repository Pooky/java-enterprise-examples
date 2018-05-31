# Java Persistance Example

> The purpouse of this example is to show you how to user persistance layer to save data to database.

Persistance layer in Java is very popular. Java is object oriented and this method allow you to persist (save) data to db and again to retrive it back using objects and object related language - something like LINQ in .NET world. 

To make connection from java to db you mainly need this three things:

* persistance config (database connection information)
* database driver
* entity manager implementation

## Persistance config

This config is located here: 

* [src/main/resources/META-INF/persistence.xml](https://github.com/Pooky/java-enterprise-examples/blob/master/persistance-example/src/main/resources/META-INF/persistence.xml)

This file is configuration file for db connection. All settings and database connection properties are set there. It's very important to have this file in right location otherwise will not be found.

## Database driver

In this example we use H2 emmbed database and we need correct driver for that. We define it as maven dependency.
```java
<dependency>
	<groupId>org.hsqldb</groupId>
	<artifactId>hsqldb</artifactId>
	<version>2.3.2</version>
</dependency>
```
If we would use MSSQL or Oracle we would use differend dependency for example this:
```java
<dependency>
    <groupId>oracle</groupId>
    <artifactId>ojdbc6</artifactId>
    <version>11.2.0.3</version>
</dependency>
```
## Entity manager implementation
Persistance is basically interface and we need some implementation. This example use Hibernate as it's engine.
```java
<dependency>
	<groupId>org.hibernate</groupId>
	<artifactId>hibernate-entitymanager</artifactId>
	<version>5.0.2.Final</version>
</dependency>
```
Alternative is for example EcliseLink or some other library
