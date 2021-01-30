# Problem Statement With Sample I/O :

![alt text](https://raw.githubusercontent.com/pulkitent/super-market-billing/master/problemStatement.png)

# What are the company's expectations
1. There must be a way to supply the application with the input data via text file

2. The application must run

3. Clear identification of domain entities and their relations with appropriate object modeling

4. Clear and logical separation of responsibilities - (emphasis on single responsibility)

5. Functionality should not be dumped in a single class, method or file (God class)

6. Clean Code (Proper Naming Conventions, Readable and self documenting code, avoid redundant commenting)

7. Easy to understand, not too complex code (something which can be extended by any other person) and of course functional completion

8. Atomicity and Coverage of Unit Tests

# Rules they want you to follow:

You should not use any external libraries to solve this problem, but you can use external libraries or tools for building 
or testing purposes. Specifically, you can use unit-testing libraries or build tools available for your chosen 
language (e.g., JUnit, Ant, NUnit, Rspec, Rake, etc.).

They assess a number of things including the design aspect of your solution and your object-oriented programming skills. 
While these are small problems, They expect you to submit what you believe is production-quality code; code that you’d be
able to run, maintain and evolve. You don’t need to gold plate your solution, however we are looking for something 
more than a bare-bones algorithm.

# In depth info on what the company is actually looking for

They are looking for people who can write code that has flexibility built in, by adhering to the principles of Object
Oriented Development, and have the ability to deal with the real-life constraints / trade-offs while designing a system.

It is important to note that they are not looking for a GUI and they are not assessing you on the capabilities around
code required to do the I/O. The focus is on the overall design. So, while building a solution, it would be nicer if
input to the code is provided either via unit tests or a file. Using command line (for input) can be tedious and
difficult to test, so it is best avoided. Following is a list of things to keep in mind, before you submit your code :

1. Is behaviour of an object distinguished from its state and is the state encapsulated?

2. Have you applied SOLID principles to your code?

3. Have you applied principles of YAGNI and KISS (additional info here)?

4. Have you looked at basic refactoring to improve design of your code?

5. Finally, and foremost, are the principles applied in a pragmatic way.

Simplicity is the strongest of the trait of a piece of code. However, easily written code may not necessarily be simple
code.

# Getting started (Run the application)

Go to SuperMarketBillingApp.java and run the main method (no need to give inputs from console)
and check output on console

(PS: No specific reason to make this project on Gradle)

# Things I tried to follow :

1. Tried to create all the required domain entities/models as per problem statement

2. Tried not to break encapsulation by avoiding getters & setters (as much as possible)

3. Tried to have immutable state with value objects (as much as possible) so as to avoid concurrency issues (Thread
   safety)

4. Tried to have readable methods & variables naming so as to clear the intention
   (4 rules of simple design).

6. Tried to avoid code duplication by refactoring/reusing duplicate code (DRY)
   but still code duplication can be improved if given more time

7. Didn't make un-necessary interfaces as per YAGNI principles because for now I don't feel the need for the same (Yes,
   I am aware of this principle also - "Program to interfaces rather than concrete implementation")

# Things I could have done/improved if given more time :

1. TDD with 100% code coverage

3. Level of indentation can be further reduced in some methods by breaking them into smaller methods

4. Encapsulation of behaviour in some classes can be further improved
