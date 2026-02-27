# SER316-S26A-acanceln-DesignPatterns



#### Project Overview:

- **Brief description of your chosen domain (Pet Shelter)**: 

_My domain, Pet Shelter, features a pet shelter management application. This app will be able to store animals and staff from the shelter, and control the various states they are in._





#### Planned Design Patterns:

- **Which two design patterns you plan to implement and why**:

_I will implement the Factory and state patterns to fulfill the requirements outlined below._

_Factory will help create objects such as different animals and staff with standardized parameters._

_State will allow a clean switch between the states an object would be in. EX: animal is available, or is injured._




#### Integration Strategy

- **High-level explanation of how you envision these patterns working together**:

_Factory will create standardized objects, and the State will control the behavior._




#### Requirements Focus:

- **List which 6+ functional requirements you plan to fulfill**:

_R1.a Start with at least 5 animals and track basic attributes (ID, species, age, health status)._

_R1.b New animals can arrive during the simulation (stray, surrender, transfer)._

_R1.c Maintain a simple status for each animal (e.g., intake, available, pending, adopted)._

_R2.a Define at least two staff roles (e.g., veterinarian, technician, counselor)._

_R2.b Each staff member has a capacity and can be assigned to animals or tasks._

_R2.c Staff availability can change over time (simple shift or on/off availability)._

_R4.a Provide basic care actions (feeding, cleaning, exercise, or socialization)._

#### Requirements fulfilled:

I completed requirements: R1.a, R1.b, R1.c, R2.a, R2.b, R2.c

I created factories for both animals and staff objects with specializations.
At the beginning of the simulation I had 5 animals created and in the shelter, fulfilling R1.a.
Similarly, every cycle/day the simulation ran a new animal arrived fulfilling R1.b.


My staff factory creates the three staff roles veterinarian, technician, counselor fulfilling R2.a.
Additionally, each staff has animals assigned and tasks that they each do differently which update
the _state_ of the animal. Fulfilling: R2.a, and R2.b.

Also, Technicians, Veterinarians and Counselors change shifts every Wednesday, Thursday, and Fridays respectively.
Fulfilling R2.c.


Animals have different states corresponding to the state their adoption process is in.

Example: if an animal just arrived then they are in the _Intake State_, 
if they are adopted then they are in the _adopted_ state and out of the shelter.
Fulfilling R1.c.




#### Concerns/Questions:

- **Any concerns or open questions about your approach**:

_What is the best way to start this?_

# Demonstration Video
[Video](https://youtu.be/kaSG19jqb2o) - _Demonstration video of the project._

## Design Justification and Process Documentation

### Pattern Selection Rationale:

I chose the _**Factory**_ and **_State_** patterns from the GoF Design patterns. 

These patterns are a good fit for my project because they work together and,
solve the problem of fulfilling some of the requirements as the design is intended to be implemented.

The factory pattern solves the problem of creating objects from the same class,
with different values and internal implementations. 
In the pet shelter domain the factory pattern creates new Animal objects with the proper values and respective actions.

The State patter solves the problem of keeping track which state the object is in and,
which action they need to take at the moment. 

In the pet shelter domain, the state pattern keeps track of which state the animal is in within the adoption process. 
So, if an animal is adopted then they are in the adopted state, where they are no longer in the shelter.

### Trade-off Analysis:

I considered the Builder Pattern instead of the Factory pattern, because as a user the builder pattern is more flexible.

The downside, was that in this project the program had to produce the simulation through logs,
so interaction was not possible; therefore,
I chose factory for automation and to have a standard creation of animalk with the same template, but different actions.

I considered the Strategy Pattern instead of the State pattern,
because I could have the animal/staff action change depending on different conditions.

But I decide the State patter would be better because it would track the phases the animal would be in,
and select the appropriate action.

### Test Code Coverage

My code coverage on Jacoco is 63%. (Did not exclude main and getters/setters)

### Design Evolution and Process:

The biggest change was deciding I was going to implement requirement R2.b instead of R4.a. 

I made this change because as I was creating the staff class,
I realized it made sense for the staff to guide the animal through the adoption process,
so the Staff would have to have animals assigned to interact.

A challenging experience was deciding "how" to implement the pattern because,
some sources had abstract classes and others had interfaces. (I am not experienced with either)

The biggest challenge with the two patterns working together is how to pass references without exposing internal system.

If I could start over, I would create even just a rough design to visualize how the design pattern would work together.
During the project I was still figuring out how the patterns should be implemented,
so I was confused on how to extend the interface.

PS: I did not do any sketches. I just brainstormed for a long time, until I saw a path. 
Working with patterns was tricky, since I was deciding "Is this the correct way to implement the pattern?"

### Challenges Faced:
– Describe specific difficulties you encountered
– Explain how you overcame them
– Be honest - this shows learning and problem-solving skills!

I already explained some challenges I had during the Design process above, but I will share another challenge.

When doing the project I think I spent too much time with extra classes, 
like I did not have to create 7 different concrete factories. 

So I think I should have focused my attention elsewhere, 
because I really wanted to incorporate a third pattern, the strategy patter, 
since I think it would complement the state pattern.

Another obstacle was the way I had my files structured. I do not have a good system and,
I had to resort to using a star import, because I have so many classes, that my _main_ class was cluttered at the top.

I did not exactly overcome it, but I had to rename the packages to lowercase because,
my IDE was having trouble syncing with Gradle due to the capitalization. (rookie mistake)

## References/Resources Used:


[design pattern playlist by levonog](https://www.youtube.com/playlist?list=PLWGY69Afe7QaO9KUWiMdzQX8d-Ea-N9an) - _useful playlist to learn an overview of each design pattern._
I used this at the beginning because they are short videos providing an overview of each design pattern and,
explaining why each is good for their use cases. This source helped me decide which patters I would use.

[Design pattern playlist by Geekific](https://www.youtube.com/playlist?list=PLlsmxlJgn1HJpa28yHzkBmUY-Ty71ZUGc) - _A longer playlist that gives you implementation samples. Really good_
I from this source I learned some examples of how to use my patterns. 
He set up a scenario and walkthrough the code, which was really helpful.
This source helped me implement the patters I chose.

[refactoring guru](https://refactoring.guru/) - _useful pattern design website that displays many design examples._
I searched both the factory and state topics and read some of the algorithms the created



#### AI-assisted:

_Shown a sample usage of factory, strategy, state, builder, adapter patterns._
The prompt above helped me visualize and understand when each pattern is useful.

_prompt: How can I test an output to the console?_
the prompt above helped me find a way to learn how to redirect the terminal output to a buffer I could test.

