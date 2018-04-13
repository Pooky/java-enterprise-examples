Servlet Example 1.0
=========================
In this example you can find basic Servlet configuration and usage.
There is also JSP example, filtering requests, listener and showcase of configuration
used by web.xml or by annotation, which allow to ommit most of xml functionality.

How to install:
====================

* Download Tomcat 8 - https://tomcat.apache.org/download-80.cgi#8.5.29
* Unzip to folder and run by /bin/catalina.sh run
* Compile this project from folder by command: "mvn package" or "mvn install" 

 - (If you missing maven, install and setup maven for command line) https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html

* Copy ServletExample-1.0.war from /target folder to %TOMCAT%/webapps
* See command line output, when Tomcat will deploy application
* Go to http://localhost:8080/ServletExample-1.0/

Main parts
==================

Folder: src/main/java
Package: org.examples.servlets

 * HomeController.java - controller which can server content to user depending on params 
 * LoggingFilter.java - filter which record every request made to the server
 * Dispatcher.java - Default controller, which will grab aby not mapped request
 * Listener.java - Startup and shutdown listener, which can be used to made some pre-start and post-start operation
 * MainServlet.java - Servlet mapped by web.xml (it's same as HomeController only differend approach)

Folder: src/main/webapp

 * js/main.js - javascript included into page
 * jsp/welcomePage.jsp - directly used JSP page which doesn't need any controller
 * index.jsp - default index
 * WEB-INF/web.xml - web.XML file for configuration of web application



