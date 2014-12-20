package org.connectedCities.services;

import java.util.concurrent.ConcurrentHashMap;

import org.connectedCities.domain.City;
import org.connectedCities.utility.Terminator;

/**
 * Search data map for requested connection.
 * */
public class ConnectionFinder {

	private String startPoint;
	private String endPoint;
	private ConcurrentHashMap<String, City> dataMap;

	public ConnectionFinder(final String startPoint, final String endPoint,
			final ConcurrentHashMap<String, City> dataMap) {
		this.startPoint = startPoint.toLowerCase();
		this.endPoint = endPoint.toLowerCase();
		this.dataMap = dataMap;
	}

	/**
	 * Checks if there is a connection between provided starting point and end
	 * point.
	 * */
	public void checkConnection() {
		if (isConnected()) {
			Terminator.yes();
		} else {
			Terminator.no();
		}
	}

	/**
	 * @return false if there is no connection between provided cities.
	 * */
	protected boolean isConnected() {
		City startCity = dataMap.get(startPoint);
		search(startCity);
		return false;
	}

	/**
	 * Used to search for connection.
	 * 
	 * @param currentNode
	 *            to check.
	 * */
	protected void search(City currentNode) {
		if (currentNode.getName().equals(endPoint)) {
			Terminator.yes();
		}
		// Clean CityA nodes
		cleanNodes(currentNode);
		if (!currentNode.isVisited()) {
			currentNode.visited();
		} else {
			return;
		}

		for (City node : currentNode.getConnections().values()) {
			search(node);
		}
	}

	/**
	 * Used to remove connections with visited node to prevent circular path
	 * 
	 * */
	protected void cleanNodes(City A) {
		for (City city : A.getConnections().values()) {
			city.getConnections().remove(A.getName());
		}
	}

}
