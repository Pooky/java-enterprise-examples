Simple Servlet technology example
========================================
Servlet (really terrible name like) is basically the most simple interface in communication with WEB interface.
When computer make request to WebServer, there is some software/service/container which catch this request and server response.
This request could be file, image, folder or something else. The container need to somehow process this and server response back to client.

If we wan't to generate content dynamicly on server, we have to use some language which will do it. We have several options:

Server 		| Language
--------------------------------------------
Apache		| PHP, Perl, Python, Ruby, Rails
MS Server	| Asp.net
Tomcat 7 	| Java (Servlet, JSP)

In this case, Tomcat 7 is not really WebServer (or HTTP server) but Servlet and JSP Container which is fully complaint with Java Servlet specification.
There is many versions, which have differend features, each version of Tomcat supports differend one. 


Servlet history
===============================
+=============+================+====================+=============================================================================+
|   VERSION   |      DATE      |   JAVA EE / JDK    |                             FEATURES / CHANGES                              |
+=============+================+====================+=============================================================================+
| Servlet 4.0 | September 2017 | JavaEE 8           | HTTP/2                                                                      |
+-------------+----------------+--------------------+-----------------------------------------------------------------------------+
| Servlet 3.1 | May 2013       | JavaEE 7           | Non-blocking I/O, HTTP protocol upgrade mechanism                           |
+-------------+----------------+--------------------+-----------------------------------------------------------------------------+
| Servlet 3.0 | December 2009  | JavaEE 6, JavaSE 6 | Pluggability, Ease of development, Async Servlet, Security, File Uploading  |
+-------------+----------------+--------------------+-----------------------------------------------------------------------------+
| Servlet 2.5 | September 2005 | JavaEE 5, JavaSE 5 | Requires JavaSE 5, supports annotation                                      |
+-------------+----------------+--------------------+-----------------------------------------------------------------------------+
| Servlet 2.4 | November 2003  | J2EE 1.4, J2SE 1.3 | web.xml uses XML Schema                                                     |
+-------------+----------------+--------------------+-----------------------------------------------------------------------------+
| Servlet 2.3 | August 2001    | J2EE 1.3, J2SE 1.2 | Addition of Filter                                                          |
+-------------+----------------+--------------------+-----------------------------------------------------------------------------+
| Servlet 2.2 | August 1999    | J2EE 1.2, J2SE 1.2 | Becomes part of J2EE, introduced independent web applications in .war files |
+-------------+----------------+--------------------+-----------------------------------------------------------------------------+
| Servlet 2.1 | November 1998  | Unspecified        | First official specification, added RequestDispatcher, ServletContext       |
+-------------+----------------+--------------------+-----------------------------------------------------------------------------+
| Servlet 2.0 |                | JDK 1.1            | Part of Java Servlet Development Kit 2.0                                    |
+-------------+----------------+--------------------+-----------------------------------------------------------------------------+
| Servlet 1.0 | June 1997      |                    |                                                                             |
+-------------+----------------+--------------------+-----------------------------------------------------------------------------+