# Dependency Injection Example

__The purpouse of this example is to show how you can use dependency injection design pattern.__

## Dependency Injection defition

Dependency injection or DI simply mean, that you provide dependencies (objects, references) to objects externally. The object doesn't hold or create new objects (dependencies) by him self instead he need to be provided with object references during construction or by passing to him by setter.

Main advantage of this approach is possibility to replace dependency with other without changing the object structure. You can use dependency injection to provide object with mock service and then in production replace it with real or testing service by your choice. You can also provide object with database connection or some file resource. If the object would hold the reference inside or create it by him self then you would need to comment or change code inside to replace this dependency. That's the main reason to use some kind of dependency injection

Let's see some example:




References:

* https://en.wikipedia.org/wiki/Dependency_injection
* http://weld.cdi-spec.org/
* https://randling.wordpress.com/2011/08/15/cdi-in-java-se/

