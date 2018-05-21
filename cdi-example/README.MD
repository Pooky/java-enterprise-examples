# Dependency Injection Example

> The purpouse of this example is to show how you can use dependency injection design pattern.

Dependency injection or DI simply mean  providing dependencies (objects, references) to objects externally. The object doesn't hold or create new objects (dependencies) by him self instead he need to be provided with object references during construction or by setters or by container.

Main advantage of this approach is possibility to replace dependencies without changing the object code or structure. 

You can use dependency injection to provide object with mock service and then in production replace it with real or testing service by your choice. You can also provide object with database connection or some file resource. If the object would hold the reference inside or create it by him self then you would need to comment or change code inside to replace this dependency. That's the main reason to use some kind of dependency injection

Let's see some example. 

First example without dependency injection. 

In code bellow we have class, which has construction and method run. During the construction the class will create new instance of the class MockObject. This is dependency for the class which is hardcoded into the code. We can't tell the class to use differend object without changing the code bellow. 



```
public class RunableApplication {

	private MockObject myObject;

	/**
	 * Constructor of the class
	 */
	public RunableApplication() {
		// We creating new instance of the bean inside of the object
		this.myObject = new MockObject(); 		
	}
	
	public void run() {

		String message = myObject.getMessage();
		System.out.println(message);

	}

}
```
 This can be fixed by many ways, we can introduce parameter in constructon, which will allow to provide reference to this class. See code bellow.

```
public class RunableApplication {

	private MockObject myObject;

	/**
	 * Constructor with pararametr
	 */
	public RunableApplication(MockObject dependency) {
		this.myObject = dependency;		
	}
	
	public void run() {

		String message = myObject.getMessage();
		System.out.println(message);

	}

}
```

This case can be very handy, when we have only few dependencies but after some time we can have five or ten dependencies, which we need to provide. For this we can use setters, to setup correct dependencies or some library, which will help us to do it. For this case there is Weld library which allow to specify what should be "injected" into objects. See code bellow

```
public class RunableApplication {

    @Inject
	private MockObject myObject;

	public void run() {

		String message = myObject.getMessage();
		System.out.println(message);

	}

}
```
In this case we don't need any constructor. The intialization of the instance is fully automated by container. You can also specify which class you want to inject by annotation or other settings which will be passed to container - usually is used beans.xml file.

**Downsides of dependency injection done by container.**

When we talking about dependency injection delegated to container we should also talk about some disadvantages which this structure hold. At first it's overhead during configuration and startup. Container needs to know where are classes located and he need to decide what will be injected and where. That's pretty heavy for configuration and many of libraries use differend way how to configure their behavior. 

Secondly, when you use container to inject your classes all classes that you use need to be injectable. In other words you can not use injection of one class and another create manually, that will lead to null pointers and errors. All classes need to be managed by container.

References:

* https://en.wikipedia.org/wiki/Dependency_injection
* http://weld.cdi-spec.org/
* https://randling.wordpress.com/2011/08/15/cdi-in-java-se/

