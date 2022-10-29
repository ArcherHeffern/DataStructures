/**
* This class runs a simulation of a Railway
* Known Bugs: None
*
* @author Archer Heffern
* hefferna@brandeis.edu
* 10/15/22
* COSI 21A PA1
*/

package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MBTA {

	public static final int SOUTHBOUND = 1;
	public static final int NORTHBOUND = 0;
	
	static final int TIMES = 6;
	static Railway r;
	
	static final String TRAINS_FILE = "trains.txt";
	static final String RIDERS_FILE = "riders.txt";
	static final String STATIONS_FILE = "redLine.txt";
	
	/**
	 * construct the Railway with the Stations, Riders, and Trains loaded from the provided text files and then run the simulation.
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		r = new Railway();
		
		initStations(STATIONS_FILE);
		initTrains(TRAINS_FILE);
		initRiders(RIDERS_FILE);
		
		runSimulation();
	}
	
	/**
	 * Runs simulation TIMES times
	 * O(n)
	 */
	public static void runSimulation() {
		System.out.println("Starting situation:");
		System.out.println(r.toString());
		
		for (int i = 0; i < TIMES; i++) {
			System.out.println("Iteration: " + (i + 1) + ":");
			System.out.println(r.simulate());
		}
	}
	
	/**
	 * constructs Trains from an input file and adds them to the Railway
	 * @param trainsFile name of file with train data
	 * @throws FileNotFoundException
	 * O(n) (Depending on file size)
	 */
	public static void initTrains(String trainsFile) throws FileNotFoundException {
		// format: train location train direction (int)
		Scanner trainScanner = new Scanner(new File(trainsFile));
		while (trainScanner.hasNextLine()) {
			String trainLocation = trainScanner.nextLine();
			String trainDirection = trainScanner.nextLine();
			Scanner check = new Scanner(trainDirection);
			Train train = new Train(trainLocation, check.nextInt());
			r.addTrain(train);
			check.close();
		}
	}
	
	/**
	 * Constructs Riders from an input file and adds them to the Railway
	 * @param ridersFile Name of file with rider data
	 * @throws FileNotFoundException
	 * O(n) (Depending on file size)
	 */
	public static void initRiders(String ridersFile) throws FileNotFoundException {
		// format: ID; from; to
		Scanner riderScanner = new Scanner(new File(ridersFile));
		int counter = 0;
		String[] buffer = new String[3];
		while (riderScanner.hasNextLine()) {
			buffer[counter] = riderScanner.nextLine();
			if (counter == 2) {
				r.addRider(new Rider(buffer[0], buffer[1], buffer[2]));
			}
			counter = (counter + 1) % 3;
		}
		
	}
	
	/**
	 * Constructs Stations from input file and adds them to the Railway
	 * @param stationsFile file with Station data
	 * @throws FileNotFoundException
	 * O(n) (Depending on file size)
	 */
	public static void initStations(String stationsFile) throws FileNotFoundException {
		// format: Station
		Scanner stationScanner = new Scanner(new File(stationsFile));
		while (stationScanner.hasNextLine()) {
			String station = stationScanner.nextLine();
			r.addStation(new Station(station));
		}
	}
}
