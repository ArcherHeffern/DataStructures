Logic:

Simulation: Creates building with n amount of floors. User can request to add people
to the building.

Building: Is a building with several floors. When a person enters the building, a job is created
for the elevator to complete

Floor: The building has several floor instances that people can enter via the elevator

Elevator: The elevator is stored in the Building and serves as an access to the floors for 
people. Moves people and puts them on floors.

Job: How people interact with the Elevator, states who wants to use elevator and where they
want to go.

Person: Has name and location. People can enter building which will create a job with the 
elevator. The elevator will process their request and move them to the floor they want. 
Or keep them in the lobby forever if the floor does not exist.
