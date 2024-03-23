insert into ime.question (category, skill, question, answer)
values  ('JAVA', 'EASY', 'Can you change the value of a string?', 'No, a string is immutable.  When you change the value of a string a new string object is actually created.'),
        ('JAVA', 'EASY', 'What is a deadlock?', '- Deadlock - two or more threads wait forever for a lock or resource held by another thread.
- thread-1 needs lock-1 & lock-2
- thread-2 needs lock-2 & lock-1'),
        ('JAVA', 'EASY', 'Can you explain what a string buffer and string builder is?', '- Both are mutable
- StringBuffer
	- Synchronized (thread safe)
	- slower
- StringBuilder
	- Not Synchronized (NOT thread safe)
	- faster'),
        ('JAVA', 'EASY', 'Can you change the value of a string?', 'No, a string is immutable.  When you change the value of a string a new string object is actually created.'),
        ('JAVA', 'HARD', 'What is a deadlock?', '- Deadlock - two or more threads wait forever for a lock or resource held by another thread.
- thread-1 needs lock-1 & lock-2
- thread-2 needs lock-2 & lock-1'),
        ('JAVA', 'MEDIUM', 'Can you explain what a string buffer and string builder is?', '- Both are mutable
- StringBuffer
	- Synchronized (thread safe)
	- slower
- StringBuilder
	- Not Synchronized (NOT thread safe)
	- faster'),
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
        ('JAVA', 'MEDIUM', 'Compare and contrast HashMap vs Hashtable', '- HashMap is not synchronized and therefore not threadsafe but is faster than Hashtable. HashMap allows 1 null key and many null values.
- Hashtable is synchronized and therefore thread safe but is slower than HashMap. Hashtable does not allow a null key or value.'),
        ('JAVA', 'MEDIUM', 'What is an enum?', '- An enum is a special type that a programmer can define for a collection of constants. It is a special type of Java class.
- You should use an enum when there is a finite number of possible values for a field or parameter.
- You can also use an enum for code re-use so you don''t have to define the value over and over when it''s used.'),
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
        ('JAVA', 'MEDIUM', 'Explain the Comparable interface.', 'You implement the Comparable interface if you want to sort a pojo.  You would then implement the compareTo method which returns positive number if the current object is greater then passed in object and negative number for the reverse of that.  Return zero if the objects are equal.');
