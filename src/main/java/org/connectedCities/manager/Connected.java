package org.connectedCities.manager;

import java.io.BufferedReader;
import java.util.concurrent.ConcurrentHashMap;

import org.connectedCities.domain.City;
import org.connectedCities.services.ConnectionFinder;
import org.connectedCities.services.ConnectionsBuilder;
import org.connectedCities.services.CustomFileLoader;
import org.connectedCities.utility.Terminator;

public class Connected {
	public static void main(String[] args) {
		if (!checkArgs(args)) {
			Terminator
					.terminate(
							"Input Error: Usage java Connected <filename> <cityname1> <cityname2>",
							1);
		}
		execute(args);
	}

	/**
	 * Start Executing the program.
	 * 
	 * @param args
	 *            command line arguments
	 * */
	protected static void execute(String[] args) {
		final String dataFile = args[0];
		final String startCity = args[1].toLowerCase();
		final String endCity = args[2].toLowerCase();

		//Check stupid question.
		checkStupidQuestion(startCity, endCity);
		// Loading data file
		CustomFileLoader fileLoader = new CustomFileLoader();
		BufferedReader fileBufferReader = fileLoader.loadFile(dataFile);

		// Building cities connections
		ConnectionsBuilder connectionBuilder = new ConnectionsBuilder(
				fileBufferReader, startCity, endCity);
		ConcurrentHashMap<String, City> dataMap = connectionBuilder
				.buildConnections();

		// Search for the desired connection
		ConnectionFinder connectionFinder = new ConnectionFinder(startCity,
				endCity, dataMap);
		connectionFinder.checkConnection();
	}

	/**
	 * Basic check for arguments validity.
	 * 
	 * @param args
	 *            command line arguments.
	 * */
	protected static boolean checkArgs(final String args[]) {
		if (args.length == 3) {
			for (String arg : args) {
				if (arg.trim().isEmpty()) {
					return false;
				}
			}
			return true;
		}

		return false;
	}
	
	/**
	 * Checks if inserted cities are the same.
	 * @param cityA starting point.
	 * @param cityB end point.
	 * */
	protected static void checkStupidQuestion(final String cityA,final String cityB){
		if(cityA.trim().toLowerCase().equals(cityB.trim().toLowerCase())){
			Terminator.yes();
		}
	}
}
