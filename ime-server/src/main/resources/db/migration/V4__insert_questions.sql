insert into ime.question (category, skill, question, answer)
values  ('JAVA', 'EASY', 'Can you change the value of a string?', 'No, a string is immutable.  When you change the value of a string a new string object is actually created.'),
        ('JAVA', 'EASY', 'Can you explain what a string buffer and string builder is?', '- Both are mutable
- StringBuffer
	- Synchronized (thread safe)
	- slower
- StringBuilder
	- Not Synchronized (NOT thread safe)
	- faster'),
        ('JAVA', 'EASY', 'Can you explain what a string buffer and string builder is?', '- Both are mutable
- StringBuffer
	- Synchronized (thread safe)
	- slower
- StringBuilder
	- Not Synchronized (NOT thread safe)
	- faster'),
        ('JAVA', 'EASY', 'Can you change the value of a string?', 'No, a string is immutable.  When you change the value of a string a new string object is actually created.'),
        ('JAVA', 'HARD', 'What is a Race Condition?', 'Two threads try to modify the same data at the same time.'),
        ('JAVA', 'HARD', 'What does Synchronized mean?', 'Allows only one thread at a time to modify shared data.'),
        ('JAVA', 'MEDIUM', 'What is serialize and deserialize?', '- serialize converts the state of an object into a byte stream
- deserialize converts a byte stream into an object with state'),
        ('JAVA', 'MEDIUM', 'What is a factory pattern?', 'Creates objects of several related classes without specifying the exact object created
Example: Shape interface
  - Factory method that takes number of sides.  If 3 passed in returns triangle, if 4 square, etc.
Example: File interface
  - Returns file based on extension'),
        ('JAVA', 'MEDIUM', 'What is the difference between a checked and unchecked exception?', 'Checked Exception
  - Checked at compile time
  - Must provide try-catch
  - Compile time error if not try-catch
  - Examples (IOException & ClassNotFoundException)
Unchecked Exception (Runtime)
  - Unchecked (checked at runtime)
  - No try-catch needed
  - No compile error
  - All unchecked exceptions are descended from Runtime Exception
  - Examples (NullPointerException & ArrayIndexOutOfBounds)'),
        ('JAVA', 'EASY', 'What is a concrete class?', '- Create an instance of by using new keyword
- It''s a full implementation
- All methods are implemented.
'),
        ('JAVA', 'EASY', 'What are the types of access modifiers (access specifier) for methods (key words)? HINT: They all start with ''p''', '- public
- protected
- package-private
- private
'),
        ('JAVA', 'MEDIUM', 'What does the static keyword mean for a variable?', 'The static keyword in Java means that the variable or function is shared between all instances of that class as it belongs to the type, not the actual objects themselves. So if you have a variable:
private static int i = 0;
and you increment it ( i++ ) in one instance, the change will be reflected in all instances.'),
        ('JAVA', 'EASY', 'Define class', 'A class is a blueprint from which individual objects are created. A class contains fields and methods.'),
        ('JAVA', 'EASY', 'What value is returned for all class constructors?', 'Class constructors don’t have a return type. 😃
    - Bonus Question: Why don’t constructors have a return type?
        - Because the constructor is not called directly by your code, it''s called by the memory allocation and object initialization code in the runtime.'),
        ('JAVA', 'MEDIUM', 'What is a local variable, an instance variable and a class variable? Contrast some of the differences between them? When would you use an instance variable as opposed to a local variable? When would you use a class variable?', '- Local variables are defined inside methods, constructors or blocks. They will be declared and initialized within the method and destroyed when the method has completed.
- Instance variables are defined within a class but outside any method. These variables are instantiated when the class is loaded.
- Class variables are declared within a class, outside any method with the static keyword.'),
        ('JAVA', 'EASY', 'What is a constructor?', '- Constructor is just like a method that is used to initialize the state of an object.
- It is invoked at the time of object creation.
- Every class has a constructor whether you write one or not.'),
        ('JAVA', 'EASY', 'Is a constructor inherited?', 'No'),
        ('JAVA', 'MEDIUM', 'What is the difference between JVM, JRE, and JDK?', '- JVM is an acronym for Java Virtual Machine. It is a specification. It is an abstract machine which provides the runtime environment in which java byte code can be executed.
- JRE is an acronym for Java Runtime Environment. It is the implementation of the JVM.
- JDK is an acronym for Java Development Kit. It physically exists. It contains JRE + development tools'),
        ('JAVA', 'EASY', 'What is the default value of local variables?', 'Local variables are not initialized to any default value, neither primitives nor object references.

Verify this!!!'),
        ('JAVA', 'EASY', 'What will be the initial value of an object reference for an instance variable?', 'Null'),
        ('JAVA', 'EASY', 'What is super in Java?', 'It is a keyword that refers to the immediate parent object.'),
        ('JAVA', 'MEDIUM', 'What is Exception handling and why would you use it?', 'Mechanism for handling runtime errors (mainly checked exceptions).'),
        ('JAVA', 'MEDIUM', 'Does Java support multiple inheritance?', 'No, but Java does support implementing multiple interfaces.'),
        ('JAVA', 'MEDIUM', 'What is the difference between Method overriding and overloading?', '- Method overriding is changing the behavior of a parent method in a child method
- Method overloading is having multiple methods in the same class that accept different parameters'),
        ('JAVA', 'MEDIUM', 'Compare and contrast a String vs StringBuilder vs StringBuffer', '- A String is immutable. If you change the value of a String a new String is created in memory.
- A StringBuilder is mutable but is not thread safe. StringBuilder is faster than StringBuffer
- A StringBuffer is mutable and is thread safe. StringBuffer is synchronized and therefore thread safe but slower than StringBuilder.'),
        ('JAVA', 'EASY', 'What is a deadlock?', 'A deadlock is when two or more threads wait forever for a lock or resource held by another thread.
For Example:
- thread-1 needs lock-1 & lock-2
- thread-2 needs lock-2 & lock-1'),
        ('JAVA', 'MEDIUM', 'Compare and contrast HashMap vs Hashtable', '- HashMap is not synchronized and therefore not threadsafe but is faster than Hashtable. HashMap allows 1 null key and many null values.
- Hashtable is synchronized and therefore thread safe but is slower than HashMap. Hashtable does not allow a null key or value.'),
        ('JAVA', 'MEDIUM', 'What is an enum?', '- An enum is a special type that a programmer can define for a collection of constants. It is a special type of Java class.
- You should use an enum when there is a finite number of possible values for a field or parameter.
- You can also use an enum for code re-use so you don''t have to define the value over and over when it''s used.'),
        ('JAVA', 'MEDIUM', 'What is a deadlock?', '- Deadlock - two or more threads wait forever for a lock or resource held by another thread.
- thread-1 needs lock-1 & lock-2
- thread-2 needs lock-2 & lock-1'),
        ('JAVA', 'MEDIUM', 'What are java streams? Describe what you know about them.', '- Streams are wrappers around a data source
- Makes bulk processing convenient and fast
- They use lambda expressions (functional programming)
- Does not store data
- Never modifies the underlying data source'),
        ('JAVA', 'MEDIUM', 'What are the 3 processes you can do on a stream?', 'Look this up...'),
        ('JAVA', 'MEDIUM', 'What are some things you can do with a stream (what are some methods)?', '- forEach
- Map
- Collect
- Filter
- findFirst
- allMatch, anyMatch, noneMatch
- count
- sorted
'),
        ('JAVA', 'MEDIUM', 'Explain the Comparable interface.', 'You implement the Comparable interface if you want to sort a pojo.  You would then implement the compareTo method which returns positive number if the current object is greater then passed in object and negative number for the reverse of that.  Return zero if the objects are equal.'),
        ('JAVA', 'MEDIUM', 'What is the difference between an Interface and an Abstract class?  When would you use one over the other?', '- abstract vs interface keyword for defining
- extend vs implements keyword for implementing
- abstract classes can have methods with implementation and interfaces can not
- abstract classes can have constructors where interfaces can not
- you can not instantiate either one
- a subclass can extend only one abstract class but can implement multiple interfaces
- abstract classes have all the features of a normal class except they can’t be instantiated
- interfaces can only have public static final constants and method declarations'),
        ('JAVA', 'MEDIUM', 'What are some exception handling best practices?', '- Clean up resources in a Finally block
- Catch specific exceptions
- Catch the most specific first
- If you throw an exception make the message as descriptive as possible
- Don''t catch Throwable
- Never ignore exceptions
- Try not to log and re-throw (doesn''t add anything)
- Sometimes it''s good to wrap and throw your own custom exception'),
        ('OOP', 'EASY', 'What are some common terms that describe Object Oriented Programming?', '- Inheritance
- Abstraction
- Encapsulation
- Polymorphism'),
        ('OOP', 'EASY', 'What is an Object?', 'An object contains properties and methods that operate on those properties.'),
        ('OOP', 'EASY', 'What are Classes?', 'A class is a template from which new objects are created.  They contain the properties and methods.'),
        ('OOP', 'EASY', 'What is inheritance?', '- This is the principle that one class can inherit the attributes and methods of another class.  You can have a car class that has common attributes like two axels and 4 wheels.  If you create a Lexus class that inherits from the Car class it will already have these attributes.
- The biggest advantage of this is code re-usability'),
        ('OOP', 'EASY', 'What is abstraction?', '- Abstraction is the concept of handling complexity by hiding unnecessary details.  The calling object doesn''t care how the answer is derived, it only cares that it does what it says it''s going to do.  We make coffee but we don''t care how the coffee machine does it we just want a cup of coffee.
- Unnecessary details are hidden from the users.  Keeps things simple'),
        ('OOP', 'EASY', 'What is encapsulation?', '- The practice of bundling attributes that store state of the object with a set of methods that use these attributes.
- Can also be called information hiding, which hides internal state of an object.'),
        ('OOP', 'EASY', 'What is polymorphism?', '- Polymorphism literally means many-forms.  In Java this is the concept that objects of different types can be accessed through the same interface.
- In our application we have a FileHandler interface and many FileHandler implementations.  We have one for Excel, Json, Text etc.  The interface has a read method which each implementation has to implement.
- Method overloading is another type of polymorphism.  We do this a lot with constructors to pass in varying numbers of parameters.'),
        ('SPRING', 'EASY', 'What are some different ways to inject beans?', '- Constructor - private final and pass into constructor
- Field - private @Autowired
- Setter - recommended if bean is not required'),
        ('SPRING BOOT', 'EASY', 'Can you list some Spring annotations that you typically use in your applications?', '- @Component - generic stereotype annotation
- @Controller -
- @Service
- @Repository - encapsulates storage, retrieval and search of collection of objects'),
        ('SPRING', 'EASY', 'What is Dependency Injection?', 'Objects are not created manually, they are created by an IoC container.'),
        ('MICROSERVICES', 'EASY', 'What are some of the key components or ideas that make a component a microservice?', '- Single responsibility
- Communicate via simple API''s & Queue
- Deployed independently of other components
- Scale independently of other components
- Version your API''s for upgrade purposes
- Service Discovery'),
        ('REST', 'EASY', 'What are some common HTTP Status Codes?', '- 200 - OK
- 201 - Created
- 400 - Bad Request
- 401 - Unauthorized
- 403 - Forbidden (server understood the request but is refusing to fulfill it)
- 404 - Not Found
- 418 - I''m a teapot
- 500 - Internal Server Error
- 502 - Bad Gateway
- 503 - Service Unavailable'),
        ('REST', 'EASY', 'What are some things that make up a REST service?', '- Request Headers
- Request Body
- Resources
- Status Code
- Method Verb'),
        ('REST', 'EASY', 'Compare URI vs URL.', '- uri - Uniform Resource Identifier
- url - Uniform Resource Locator'),
        ('REST', 'MEDIUM', 'What are some elements of a good REST implementation (best practices)?', '- consistent path or uri
- input validated
- no sensitive data through url
- authentication
- correct http error response codes
- use message format consistency'),
        ('SQL', 'EASY', 'What are some different types of joins?', '- Inner join
- Left join
- Right join
- Full join
- Self join'),
        ('SQL', 'EASY', 'What is an inner join?', 'Retrieves records that have matching values in both tables.'),
        ('SQL', 'EASY', 'What is a left outer join?', 'Retrieves all records from first table and matched records from second table.'),
        ('SQL', 'EASY', 'What is a right outer join?', 'Retrieves all records from the second table and matched records from the first table'),
        ('SQL', 'EASY', 'What is a full outer join?', 'Retrieves all records where there is a match in either the left or right table'),
        ('SQL', 'EASY', 'What is a self join?', 'Need definition...'),
        ('DESIGN PATTERNS', 'EASY', 'What is a singleton?', '- Only one instance exists throughout the application.
- Private constructor with static method to getInstance()'),
        ('DESIGN PATTERNS', 'EASY', 'What is a factory method?', '- Creates objects of several related classes without specifying exact object created
Example:
   - Shape interface
   - Factory method that takes number of sides.  If 3 passed in returns triangle, if 4 square, etc.'),
        ('DESIGN PATTERNS', 'EASY', 'What is an abstract factory?', 'Provides an interface for creating families of related or dependent objects without specifying their concrete classes.'),
        ('DESIGN PATTERNS', 'EASY', 'What is the builder pattern?', '- Constructs complex objects using step-by-step approach.
- Static inner class called Builder
- Inner class takes required fields in constructor
- Optional fields are set with fluent design that returns Builder
- Final step is to call build which instantiates the outer class and returns it'),
        ('ANGULAR', 'EASY', 'What is Angular?', '- A TypeScript-based open source web application framework.
- Developed by Google
- Used for building front-end web-based applications'),
        ('ANGULAR', 'EASY', 'What is string interpolation?', '- Interpolation refers to embedding expressions into marked up text
- By default, interpolation uses the double curly braces {{ and }} as delimiters
- <h3>Current customer: {{ currentCustomer }}</h3>
- <p>{{title}}</p>
- <div><img alt="item" src="{{itemImageUrl}}"></div>'),
        ('ANGULAR', 'EASY', 'What is event binding?', '- Event binding lets you listen for and respond to user actions such as keystrokes, mouse movements, clicks, and touches
- This syntax consists of a target event name within parentheses to the left of an equal sign, and a quoted template statement to the right
- <button (click)="onSave()">Save</button>'),
        ('ANGULAR', 'EASY', '- What makes a component?  What does every component contain? (3 things)', '- Template - the UI or view in html
- Class - properties & methods in typescript
- Metadata - additional data (directive)'),
        ('ANGULAR', 'EASY', 'What do pipes do?', 'To format data in the view'),
        ('ANGULAR', 'EASY', 'An NgModule contains declarations and imports.  What goes in declarations and imports?', '- Declarations contains our directives, components and pipes
- Imports contains directives, components and pipes from other sources such as Angular or third parties'),
        ('ANGULAR', 'EASY', 'What are @Input() and @Output() used for?', '- They are both decorators
- Both are functions
- @Input() used to pass a value from the parent to the child component
- @Output() uses property binding and event binding to pass data from the child to the parent'),
        ('ANGULAR', 'EASY', 'Do you know what a safe navigation operator is?', '- Use a ? after an object to prevent null or undefined errors in templates
- {{product?.productName}}
- {{product?.supplier?.productName}}'),
        ('ANGULAR', 'EASY', 'What are the 4 types of Data Binding?', '- Interpolation: {{pageTitle}}
- Property Binding: <img [src]=''product.imageUrl''>
- Event Binding: <button (click)=''toggleImage()''>
- Two-Way Binding: <input [(ngModel)]=''listFilter'' />'),
        ('ANGULAR', 'MEDIUM', 'What is property binding?  How is it different from string interpolation?', '- Property binding in Angular helps you set values for properties of HTML elements or directives
- Property binding moves a value in one direction, from a component''s property into a target element property
- To bind to an element''s property, enclose it in square brackets,  []
- <img alt="item" [src]="itemImageUrl">'),
        ('ANGULAR', 'EASY', 'What is two way binding?', '- Two-way binding gives components in your application a way to share data
- Use two-way binding to listen for events and update values simultaneously between parent and child components
- Angular''s two-way binding syntax is a combination of square brackets and parentheses, [()]
- The [()]syntax combines the brackets of property binding, [], with the parentheses of event binding, ()
- <app-sizer [(size)]="fontSizePx"></app-sizer>'),
        ('ANGULAR', 'EASY', 'What is a template?  What does it contain?', 'The template is the html'),
        ('ANGULAR', 'EASY', 'What are two ways to define a template for a component?', '- template: which contains the html tags right in the component.  Have to use back ticks.
- templateUrl: which defines the html file that contains the html tags'),
        ('ANGULAR', 'MEDIUM', 'What are lifecycle hooks and can you name a few?', '- Angular components go through a lifecycle from the time they are created until they are destroyed.  Angular hooks provide ways to tap into these phases.
- Lifecycle hook methods
	- ngOnInit() - initializes the component
	- ngOnChanges() - when an input property changes
	- ngOnDestroy() - Called right before Angular destroys the component
	- ngDoCheck() -
	- ngAfterContentInit() -
	- ngAfterContentChecked() -
	- ngAfterViewInit() - after view or child view is initialized
	- ngAfterViewChecked() - '),
        ('ANGULAR', 'EASY', 'What are some different decorators?', '- @Component
- @Pipe'),
        ('ANGULAR', 'EASY', 'What is the Angular CLI', '- Command Line Interface
- ng starts every command
- Used on the command line'),
        ('SPRING', 'MEDIUM', 'What are the 6 Bean scopes?', '- singleton (default)
- request
- session
- application
- websocket
To specify scope use the @Scope annotation'),
        ('JAVA', 'MEDIUM', 'What are the features of an Interface?', 'And interface is a template that contains only the signature of methods. The signature of a method consists of the numbers of parameters, the type of parameter (value, reference, or output), and the order of parameters. And interface has no implementation on its own, because it contains only the definition of methods without any method body. And interface is defined using the interface keyword. Moreover, you cannot instantiate an interface. The various features of an interface are as follows:
•	An interface is used to implement multiple inheritance in code. This feature of an interface is quite different from that of abstract classes, because a class cannot derive the features of more than one class, but can easily implement multiple interfaces.
•	It defines a specific set of methods and their arguments.
•	Variables in interface must be declared as public, static, and final, while methods must be public and abstract.
•	A class implementing an interface must implement all of its methods.
•	An interface can drive for more than one interface.
'),
        ('DEVOPS', 'MEDIUM', 'What are the differences between Continuous Integration, Continuous Delivery, and Continuous Deployment?', '•	Developers practicing continuous integration, merge their changes back to the main branch as often as possible. By doing so, you avoid the integration. Hell that usually happens when people wait for release day to merge their changes into the release branch.
•	Continuous delivery is an extension of continuous integration to make sure that you can release new changes to your customers quickly in a sustainable way. This means that on top of having automated your testing, you also have automated your release process and you can deploy your application at any point of time by clicking on a button.
•	Continuous deployment goes one step further than continuous delivery. With this practice, every change that passes all stages of your production pipeline is released your customers. There’s no human intervention, and only a field test will prevent a new change to be deployed to production.
'),
        ('JAVA', 'MEDIUM', 'What are the differences between == and equals?', '1) == will never throw a NullPointerException
   enum Color { BLACK, WHITE };

   Color nothing = null;
   if (nothing == Color.BLACK)   // runs fine
   if (nothing.equals(Color.BLACK));  // throws NullPointerException

2) == is subject to type compatibility check at compile time

   enum Color { BLACK, WHITE };
   enum Position { LEFT, RIGHT };

   if (Color.BLACK.equals(Position.LEFT));   // compiles fine
   if (Color.BLACK == Position.LEFT);   // Doesn''t compile'),
        ('JAVA', 'MEDIUM', 'What do the ... dots in the method parameters mean?  For instance if you have this:
   public void myMethod(String... strings) {
      // implementation
   }', 'That feature is called varargs and it means that function can receive multiple String arguments.  For example you could do this with it:
   for (String theString : strings) {
   }'),
        ('SPRING', 'MEDIUM', 'What is a Spring IoC container?', 'The spring IoC creates the objects, wires them together, configures them, and manages their complete lifecycle from creation till destruction. The spring container uses dependency injection (DI) to manage the components that make up an application.'),
        ('JAVA', 'MEDIUM', 'What is the structure of the Java Heap?', 'The JVM has a heap that is the runtime data area from which memory for all classes instances and arrays are allocated. It is created at the JVM start-up. Heap memory for objects is reclaimed by an automatic memory management system which is known as a garbage collector. Heap memory consists of live and dead objects. Live objects are accessible by the application and will not be subject to garbage collections. Dead objects are those which will never be accessible by the application, but have not been collected by the garbage collector, yet. Such objects occupy the heap memory space until they are eventually collected by the garbage collector.'),
        ('JAVA', 'MEDIUM', 'What is the volatile keyword useful for?', 'Volatile has semantics for memory, visibility. Basically, the value of a volatile field becomes visible to all readers (other threads in particular) after a right operation completes on it. Without volatile, readers, could see some non-updated value.'),
        ('SPRING', 'MEDIUM', 'What is Controller in Spring framework?', 'Controllers provide access to the application behavior that you typically define through a service interface. Controllers interpret user input and transform it into a model that is represented to the user by the view. Spring implements a controller in a very abstract way, which enables you to create a wide variety of controllers.'),
        ('JAVA', 'MEDIUM', 'What is a JavaBean exactly?', 'Basically a JavaBean follows the following standards:
•	It is a serializable object. Meaning it implements the java.io.serializableinterface.
•	It has properties whose getters and setters are just methods with certain names
•	It has a public zero or constructor, so it can be created at wheel and configured by setting its properties
There is no syntactic difference between a job or being in another class – a class is a JavaBean if it follows the standards
'),
        ('JAVA', 'MEDIUM', 'What is the difference between fail-fast and fail-safe for Iterators?', 'The iterators fail – safe property works with the clone of the underlying collection and pass, it is not affected by any modification in the collection. All the collection classes in Java.until package or fail fast, while the collection classes in Java.util.concurrent or fail Dash safe fail fast iterators throw a concurrent modification exception while fail Dash safe iterator never throws such an exception.'),
        ('JAVA', 'MEDIUM', 'What is the JIT?', 'The JIT is the JVM''s mechanish by which it can optimize code at runtime.

JIT means just in time. It is a central feature of any JVM. Among other optimizations, it can perform code inlining, lock coercing or lock eliding, escape analysis, etc.

The main benefit of the JIT is on the programmers side: code should be written, so that it just works; if the code can be optimized at runtime, more often than not, the JIT will find a way.
'),
        ('JAVA', 'HARD', 'Explain the Builder Design Pattern.', 'Need answer...'),
        ('JAVA', 'HARD', 'Is a null check needed before calling instanceof?', 'No.  It will just return false if the object is null.'),
        ('MICROSERVICES', 'HARD', 'What are the pros and cons of a Microservice Architecture?', 'Pros
•	Freedom to use different technologies
•	Each microservice focuses on a single responsibility
•	Supports individual deployable units
•	Allows frequent software releases
•	Ensures security of each service
•	Multiple services can be developed and deployed in parallel


Cons
•	Harder to troubleshoot
•	Remote calls can cause a delay
•	Increased efforts for configuration
•	Difficult to maintain transaction safety
•	Tough to track data across boundaries
•	Difficult to code between services
'),
        ('OOP', 'HARD', 'What is Coupling in OOP?', 'This is when modules are dependent on each other.  Coupling refers to the level of dependency between two software modules.  Two modules are highly dependent on each other if you make a change in one and that causes you to have to make a change in the other.  Loose Coupling is always preferred.

Inversion of Control and Dependency Injection are some techniques for getting loose coupling between modules.'),
        ('JAVA', 'HARD', 'What is the difference between Serial and Throughput Garbage collector?', 'The throughput garbage collector uses a parallel version of the young generation collector, and is meant to be used with applications that have medium to large data sets. On the other hand, the serial collector is usually adequate for most small applications (those requiring heaps of up to approximately 100 MB on modern processors).'),
        ('JAVA', 'HARD', 'Why is char[] preferred over String for passwords?', 'A String is subject to the garbage collector, however with a char[] you can overwrite the data at any time.'),
        ('ANGULAR', 'EASY', 'What is a Routing Guard in Angular?', 'Angular''s route guards are interfaces which can tell the router whether or not it should allow navigation to a requested route.  They make this decision by looking for a true or false return value from a class which implements the given guard interface.

There are 5 different types of guards and each of them is called in a particular sequence.  The guards are:
•	CanActivate
•	CanActivateChild
•	CanDeactivate
•	CanLoad
•	Resolve'),
        ('ANGULAR', 'EASY', 'What is a Module, and what does it contain?', 'And angular module is a set of angular basic building blocks like components, directives, services, etc. An app can have more than one module. A module can be created using the @ngModule decorator.'),
        ('JAVA', 'HARD', 'What are the benefits of using Multithreading?', '•	Allow the program to run continuously even if a part of it is blocked.
•	Improve performance as compared to traditional parallel programs that use multiple processes.
•	Allows to write effective programs that utilize maximum CPU time
•	Improves the responsiveness of complex applications or programs.
•	Increase use of CPU resources and reduce costs of maintenance.
•	Saves time and parallelism tasks.
•	If an exception occurs in a single thread, it will not affect other threads as threads are independent.
•	Less resource-intensive than executing multiple processes at the same time.
'),
        ('JAVA', 'HARD', 'What is a Thread in Java?', 'Threads are basically the lightweight and smallest unit of processing that can be managed independently by a scheduler. Threads are referred to as parts of a process that simply let a program execute efficiently with other parts or threads of the process at the same time. Using threads, one can perform complicated tasks in the easiest way. It is considered the simplest way to take advantage of multiple CPUs available in a machine. They share the common address space and are independent of each other.'),
        ('JAVA', 'HARD', 'What''s the difference between a thread and process?', 'Thread: It simply refers to the smallest units of the particular process. It has the ability to execute different parts (referred to as thread) of the program at the same time.

Process: It simply refers to a program that is in execution i.e., an active program. A process can be handled using PCB (Process Control Block).

Thread	Process
It is a subset of a subunit of a process.	It is a program in execution containing multiple threads.
In this, inter-thread communication is faster, less expensive, easy and efficient because threads share the same memory address of the process they belong to. 	In this, inter-process communication is slower, expensive, and complex because each process has different memory space or address.,
These are easier to create, lightweight, and have less overhead. 	These are difficult to create, heavyweight, and have more overhead.
It requires less time for creation, termination, and context switching.	It requires more time for creation, termination, and context switching.
Processes with multiple threads use fewer resources.	Processes without threads use more resources.
Threads are parts of a process, so they are dependent on each other but each thread executes independently.	Processes are independent of each other.
There is a need for synchronization in threads to avoid unexpected scenarios or problems.	There is no need for synchronization in each process.
They share data and information with each other. 	They do not share data with each other.

'),
        ('JAVA', 'HARD', 'What are the wait() and sleep() methods?', 'wait(): As the name suggests, it is a non-static method that causes the current thread to wait and go to sleep until some other threads call the notify () or notifyAll() method for the object’s monitor (lock). It simply releases the lock and is mostly used for inter-thread communication. It is defined in the object class, and should only be called from a synchronized context.

sleep(): As the name suggests, it is a static method that pauses or stops the execution of the current thread for some specified period. It doesn’t release the lock while waiting and is mostly used to introduce pause on execution. It is defined in thread class, and no need to call from a synchronized context.  '),
        ('JAVA', 'HARD', 'Explain the meaning of the deadlock and when it can occur?', 'Deadlock, as the name suggests, is a situation where multiple threads are blocked forever. It generally occurs when multiple threads hold locks on different resources and are waiting for other resources to complete their task.

For example two threads are blocked forever.  Thread 1 is holding Object 1 but needs object 2 to complete processing whereas Thread 2 is holding Object 2 but needs object 1 first. In such conditions, both of them will hold lock forever and will never complete tasks.'),
        ('JAVA', 'HARD', 'Explain volatile variables in Java?', 'A volatile variable is basically a keyword that is used to ensure and address the visibility of changes to variables in multithreaded programming. This keyword cannot be used with classes and methods, instead can be used with variables. It is simply used to achieve thread-safety. If you mark any variable as volatile, then all the threads can read its value directly from the main memory rather than CPU cache, so that each thread can get an updated value of the variable.'),
        ('JAVA', 'HARD', 'How do threads communicate with each other?', 'Threads can communicate using three methods i.e., wait(), notify(), and notifyAll().'),
        ('JAVA', 'HARD', 'Can two threads execute two methods (static and non-static concurrently)?', 'Yes, it is possible. If both the threads acquire locks on different objects, then they can execute concurrently without any problem.'),
        ('JAVA', 'HARD', 'What will happen if we don''t override the thread class run() method?', 'Nothing will happen if we don’t override the run() method. The compiler will not show any error. It will execute the run() method of thread class and we will just not get any output because the run() method is with an empty implementation.'),
        ('JAVA', 'HARD', 'Is it possible for each thread to have its own stack in multithreaded programming?', 'Yes. In multithreaded programming, each thread maintains its own separate stack area in memory because each thread is independent of each other rather than dependent.'),
        ('JAVA', 'HARD', 'Is it possible to call the run() method directly to start a new thread?', 'No, it''s not possible to start a thread. You need to call the start() method to create a new thread otherwise run method won''t create a new thread. Calling the run() method it will behave like a normal method and not start a new thread.'),
        ('JAVA', 'HARD', 'Explain context switching.', 'Context switching is an important feature of multithreading. It is the process of switching the CPU from one thread or process to another one. It allows multiple processes to share the same CPU. In context switching, the state of a thread or process is stored so that the execution of the thread can be resumed later if required.'),
        ('JAVA', 'HARD', 'How can we achieve thread safety in Java?', 'There are several ways to achieve thread, safety in Java – synchronization, atomic, concurrent classes, implementing concurrent, lock, interface, using volatile keyword, using immutable classes and thread, safe classes.'),
        ('JAVA', 'HARD', 'What is more preferred - Synchronized method or Synchronized block?', 'Synchronized block is the more preferred way because it doesn’t lock the object, synchronized methods lock the object.  If there are multiple synchronization blocks in the class, even though they are not related, it will stop them from executing and put them in wait state to get the lock on object.'),
        ('JAVA', 'HARD', 'What do you mean by the ThreadLocal variable in Java?', 'ThreadLocal variables are special kinds of variables created and provided by the Java ThreadLocal class. These variables are only allowed to be read and written by the same thread. Two threads cannot see each other’s ThreadLocal variable, so even if they execute the same code, then there won''t be any race condition and the code will be thread-safe.'),
        ('JAVA', 'HARD', 'What is a race condition?', 'A Race condition is a problem which occurs in the multithreaded programming when various threads execute simultaneously accessing a shared resource at the same time. The proper use of synchronization can avoid the Race condition.');
