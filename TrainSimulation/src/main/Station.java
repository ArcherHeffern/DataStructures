/**
* This class represents a Station on the red line. A Station 
* tracks which Trains and Riders are waiting to go north or south
* Known Bugs: None
*
* @author Archer Heffern
* hefferna@brandeis.edu
* 10/15/22
* COSI 21A PA1
*/

package main;

public class Station {

	private String name;
	public Queue<Rider> northBoundRiders;
	public Queue<Rider> southBoundRiders;
	public Queue<Train> northBoundTrains;
	public Queue<Train> southBoundTrains;
	private final int QUEUE_LENGTH= 20;
	
	/**
	 * Constructs a new Station with given name
	 * @param name of station
	 */
	public Station(String name) {
		this.name = name;
		this.northBoundRiders = new Queue<>(QUEUE_LENGTH);
		this.southBoundRiders = new Queue<>(QUEUE_LENGTH);
		this.northBoundTrains = new Queue<>(QUEUE_LENGTH);
		this.southBoundTrains = new Queue<>(QUEUE_LENGTH);
	}
	
	/**
	 * Adds a Rider to the appropriate Queue, depending on the Rider’s direction, as long as they should be in this Station
	 * @param r Rider
	 * @return true if this is possible, false if not
	 * O(1)
	 */
	public boolean addRider(Rider r) { 
		if (!r.getStarting().equals(name)) return false;
		if (r.goingNorth()) {
			northBoundRiders.enqueue(r);
		}
		else {
			southBoundRiders.enqueue(r);
		}
		return true;
	}
	
	/**
	 * moves a Train into this Station, removes all of the passengers who are meant to disembark at this Station,
	 *  and places the Train in the appropriate Queue depending on its direction
	 * @param t Train going into the station
	 * @return String that includes that some passengers were removed at this Station
	 * O(1)
	 */
	public String addTrain(Train t) {
		t.updateStation(name);
		String disembarkedPassengers = t.disembarkPassengers();
		if (t.goingNorth()) northBoundTrains.enqueue(t);
		else southBoundTrains.enqueue(t);
		return disembarkedPassengers;
	}
	
	/**
	 * prepare a southbound Train of passengers by performing the following steps: 
	 * 1) Dequeuing a train from the southbound train queue.
	 * 2) Adding as many southbound Riders to the Train as possible.
	 * @return the train that has been filled or null if there are no waiting southbound Trains.
	 * O(n)
	 */
	public Train southBoardTrain() {
		if (southBoundTrains.size() == 0) return null;
		Train train = southBoundTrains.front();
		southBoundTrains.dequeue();
		while (train.hasSpaceForPassengers() && southBoundRiders.size() > 0) {
			Rider tempRider = southBoundRiders.front();
			southBoundRiders.dequeue();
			train.addPassenger(tempRider);
		}
		return train;
	}
	
	/**
	 * prepare a northbound Train of passengers by performing the following steps: 
	 * 1) Dequeuing a train from the southbound train queue.
	 * 2) Adding as many northbound Riders to the Train as possible.
	 * @return the train that has been filled or null if there are no waiting southbound Trains.
	 * O(n)
	 */
	public Train northBoardTrain() {
		if (northBoundTrains.size() == 0) return null;
		Train train = northBoundTrains.front();
		northBoundTrains.dequeue();
		while (train.hasSpaceForPassengers() && northBoundRiders.size() > 0) {
			Rider tempRider = northBoundRiders.front();
			northBoundRiders.dequeue();
			train.addPassenger(tempRider);
		}
		return train;
	}
	
	/**
	 * changes the direction of the first waiting northbound Train and moves it to the southbound queue. 
	 * You may assume that the Train will not have any Riders.
	 * O(n)
	 */
	public void moveTrainNorthToSouth() {
		if (northBoundTrains.size() == 0) return;
		Train train = northBoundTrains.front();
		northBoundTrains.dequeue();
		if (train.goingNorth()) {
			train.swapDirection();			
		}
		southBoundTrains.enqueue(train);
	}
	
	/**
	 * changes the direction of the first waiting southbound Train and moves it to the northbound queue. 
	 * You may assume that the Train will not have any Riders.
	 * O(n)
	 */
	public void moveTrainSouthToNorth() {
		if (southBoundTrains.size() == 0) return;
		Train train = southBoundTrains.front();
		southBoundTrains.dequeue();
		if (!train.goingNorth()) {
			train.swapDirection();
		}
		northBoundTrains.enqueue(train);
	}
	
	/**
	 * toString method
	 * @return String representation of station
	 * O(n)
	 */
	@Override
	public String toString() {
		String stuff = "";
		stuff += "Station: " + name + "\n";
		stuff += northBoundTrains.size() + " north-bound trains waiting\n";
		stuff += southBoundTrains.size() + " south-bound trains waiting\n";
		stuff += northBoundRiders.size() + " north-bound passengers waiting\n";
		stuff += southBoundRiders.size() + " south-bound passengers waiting\n";
		return stuff;
	}
	
	/**
	 * Gets name of station
	 * @return name of this Station
	 * O(1)
	 */
	public String stationName() {
		return name;
	}
	
	/**
	 * Checks if Station is equal to some object based on name
	 * O(1)
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Station) {
			if (((Station) o).stationName().equals(name)) {
				return true;
			}
		}
		return false;
	}
}
