## Serialization
Serialization process on the example of inheritance and nested object


### Task
***
The following 7 classes are given:
- "Vehicle" with fields: speed, year of production, engine.
- "Airplane" (imitates "Vehicle" and implements Serializable) with fields: model, flight range, chassis.
- "Ship" (follows "Vehicle" and implements Externalizable) with fields: water capacity, length, a boat.
- "Engine" with fields: type, power.
- "Chassis" with fields: wheel, the number of wheels.
- "Boat" with fields: number of passengers, material.
- "Wheel" with fields: load, diameter.

<br/>
  Required:<br/><br/>
1) Create objects of classes of aircraft and ships, which will be saved in the two corresponding ones
   ArrayLists sorted by year of production.<br/>
2) Serialize the created ArrayLists to the corresponding files: PLANES using
   the Serializable interface and SHIPS using the Externalizable interface.<br/>
3) Deserialize files using the Serializable/Externalizable interfaces
   PLANES and SHIPS to two corresponding sorted ArrayLists.

### Setup
***
In your IDE just run the Dispatcher class.
Сreated files after serialization will appear in the "resultedFiles" folder, which come with project.
### Realization
***
The Plane class in this project implements the Serializable interface. The Chassis object in the Plane class is marked as transient, which means that it will not be included in the serialization process by default. The Plane class has two methods, writeObject and readObject, which are called during the serialization and deserialization process, respectively. In the writeObject method, the state of the Chassis object is explicitly written to the byte stream by calling the writeInt method on the ObjectOutputStream. In the readObject method, the state of the Chassis object is explicitly read from the byte stream by calling the readInt method on the ObjectInputStream.

The Ship class in this project implements the Externalizable interface. The Externalizable interface gives more control over the serialization process compared to the Serializable interface. The Ship class has two methods, writeExternal and readExternal, which are called during the serialization and deserialization process, respectively. In the writeExternal method, the state of the Ship object is explicitly written to the byte stream by calling the writeInt and writeObject methods on the ObjectOutput. In the readExternal method, the state of the Ship object is explicitly read from the byte stream by calling the readInt and readObject methods on the ObjectInput.

In both cases, the compareTo method is implemented to provide a way to sort objects based on their producedYear property before serialization (as required by task).

### Conclusion
***
Serialization is the process of converting an object's state to a byte stream so that the object can be easily saved to a file, sent over a network, or stored in a database. In Java, serialization is achieved by implementing the Serializable interface or the Externalizable interface in a class depending on how this class is implemented (inheritance presence, nested objects etc.).