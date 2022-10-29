/**
* This class represents the red line railway and is made up of a list of Stations
* Known Bugs: None
*
* @author Archer Heffern
* hefferna@brandeis.edu
* 10/15/22
* COSI 21A PA1
*/

package main;

public class Railway {

	public DoubleLinkedList<Station> railway; // Start of railway is north, end is south
	public String[] stationNames;
	private int stationIndex;
	private final int MAX_STATIONS = 18;

	/**
	 * Constructs new railway
	 */
	public Railway() {
		stationNames = new String[MAX_STATIONS];
		railway = new DoubleLinkedList<>();
		stationIndex = 0;
	}

	/**
	 * adds a Station to the Railway
	 * @param s
	 * O(1)
	 */
	public void addStation(Station s) {
		railway.insert(s);
		stationNames[stationIndex] = s.stationName();
		stationIndex++;
	}

	/**
	 * sets a Rider’s direction based on the order of the Stations in the Railway
	 * and (ii) adds the Rider to the appropriate Station in the Railway.
	 * 
	 * @param r
	 * O(1)
	 */
	public void addRider(Rider r) {
		setRiderDirection(r);
		String stationOfRider = r.getStarting();
		Station station = railway.get(new Station(stationOfRider));
		station.addRider(r);
	}

	/**
	 * adds a Train to the appropriate Station in this Railway.
	 * @param t Train
	 * O(1)
	 */
	public void addTrain(Train t) {
		String stationOfTrain = t.getStation();
		Station station = railway.get(new Station(stationOfTrain));
		station.addTrain(t);
	}

	/**
	 * sets a Rider’s direction based on the Rider’s starting and ending Stations
	 * @param r
	 * O(n)
	 */
	public void setRiderDirection(Rider r) {
		String starting = r.getStarting();
		String destination = r.getDestination();
		for (int i = 0; i < stationIndex; i++) {
			if (stationNames[i].equals(starting)) {
				// going south
				if (r.goingNorth()) {
					r.swapDirection();
				}
				return;
			}
			if (stationNames[i].equals(destination)) {
				// going north
				if (!r.goingNorth()) {
					r.swapDirection();
				}
				return;
			}
		}

	}

	/**
	 * This method will execute one simulation of the Railway. You should log the
	 * events that occur in the process of your simulation such as the status of
	 * each Station, where Trains and Riders are, and when Riders exit a Train. This
	 * log should be returned by this method for use in the main class MBTA.java
	 * 
	 * During this method, you should traverse the Stations in the Railway north to
	 * south and perform the following steps at each Station in this order:
	 * 
	 * 1. Board a (southbound/northbound) train with as many passengers as possible
	 * unless the Station is (Braintree/Alewife). 2. Move the boarded trains to
	 * their next Stations. 3. Disembark any passengers who are meant to get off at
	 * the Stations that the trains were moved to. 4. If the current Station is
	 * (Braintree/Alewife) then you should move a (southbound train to go
	 * north/northbound train to go south).
	 * 
	 * Note: you should never have a train switch direction and move from that
	 * Station in a single call to this method.
	 * 
	 * @return String representation of simulation
	 * @error Trains not going into BrainTree or alewife - find out why and fix
	 * 
	 * O(n)
	 */
	public String simulate() {
		String simulation = "";

		// traverse the Stations in the Railway north to south
		Node<Station> curr = railway.getFirst();
		while (curr != null) {

			Station currStation = curr.getData();

			boolean skip = true;
			// if at first stop and there are northbound trains in station: Switch them around
			if (currStation.northBoundTrains.size() > 0 && curr.getPrev() == null) {
				simulation += "Northbound train swapped direction to South\n";
				currStation.moveTrainNorthToSouth();
				skip = false;
//						System.out.println("Front of last station trains" + currStation.northBoundTrains.front());
			}
			// if at last stop and there are southbound trains in station: Switch them around
			if (currStation.southBoundTrains.size() > 0 && curr.getNext() == null) {
				simulation += "Southbound train swapped direction to North\n";
				currStation.moveTrainSouthToNorth();
				skip = false;
			}
			// if not at last stop: move southbound trains to next 
			if (curr.getNext() != null && skip) {
				Train southBoundTrain = currStation.southBoardTrain();
				if (southBoundTrain != null) {
					Station nextStation = curr.getNext().getData();
					simulation += "Southbound train moved from " + currStation.stationName() + " to " + nextStation.stationName() + "\n";
					simulation += "Passengers removed: " + nextStation.addTrain(southBoundTrain) + "\n";
				}
			}
			// if not at first stop: move northbound train to next 
			if (curr.getPrev() != null && skip) {
				Train northBoundTrain = currStation.northBoardTrain(); // error: northboundtrain return null
				if (northBoundTrain != null) {
					Station prevStation = curr.getPrev().getData();
					simulation += "Northbound train moved from " + currStation.stationName() + " to " + prevStation.stationName() + "\n";
					simulation += "Passengers removed: " + prevStation.addTrain(northBoundTrain) + "\n";
				}
			} 
			
			// move both trains to next station unless at end of the line

			curr = curr.getNext();

		}
		simulation += "\n" + this.toString();
		return simulation;
	}

	/**
	 * @return the Stations list’s String representation
	 * O(n)
	 */
	@Override
	public String toString() {
		String stationString = "";
		Node<Station> curr = railway.getFirst();
		while (curr != null) {
			stationString += curr.getData().toString() + "\n";
			curr = curr.getNext();
		}
		stationString += "-------------------------------------------------";
		return stationString;
	}
}
