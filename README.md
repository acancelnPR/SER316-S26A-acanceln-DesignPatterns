\#SER316-S26A-acanceln-DesignPatterns



\#### Project Overview:

\- \*\* Brief description of your chosen domain (Pet Shelter) \*\*: 

\_My domain, Pet Shelter, features a pet shelter management application. This app will be able to store animals and staff from the shelter, and control the various states they are in.\_

 



\#### Planned Design Patterns:

\- \*\* Which two design patterns you plan to implement and why \*\*:

\_I will implement the Factory and state patterns to fulfill the requirements outlined below.\_

\_Factory will help create objects such as different animals and staff with standardized parameters.\_

\_State will allow a clean switch between the states an object would be in. EX: animal is available, or is injured.\_

 



\#### Integration Strategy

\- \*\* High-level explanation of how you envision these patterns working together \*\*:

\_Factory will create standardized objects, and the State will control the behavior.\_

 



\#### Requirements Focus:

\- \*\* List which 6+ functional requirements you plan to fulfill \*\*:



\_R1.a Start with at least 5 animals and track basic attributes (ID, species, age, health status).\_



\_R1.b New animals can arrive during the simulation (stray, surrender, transfer).\_



\_R1.c Maintain a simple status for each animal (e.g., intake, available, pending, adopted).\_



\_R2.a Define at least two staff roles (e.g., veterinarian, technician, counselor).\_ 



\_R2.b Staff availability can change over time (simple shift or on/off availability).\_



\_R4.a Provide basic care actions (feeding, cleaning, exercise, or socialization).\_ 





\#### Concerns/Questions:

\- \*\* Any concerns or open questions about your approach \*\*:

\_What is the best way to start this?\_



\## References:



\[design pattern playlist by levonog](https://www.youtube.com/playlist?list=PLWGY69Afe7QaO9KUWiMdzQX8d-Ea-N9an) - \_useful playlist to learn an overview of each design pattern.\_



\[refactoring guru](https://refactoring.guru/) - \_useful pattern design website that displays many design examples.\_



\#### AI-assisted:



\_Shown a sample usage of factory, strategy, state, builder, adapter patterns.\_

