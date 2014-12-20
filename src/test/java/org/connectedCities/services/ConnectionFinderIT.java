package org.connectedCities.services;

import java.io.BufferedReader;
import java.util.concurrent.ConcurrentHashMap;

import org.connectedCities.domain.City;
import org.junit.Ignore;
import org.junit.Test;

public class ConnectionFinderIT {
	@Ignore
	@Test
	public void findConnectionITExample1() {
		String start = "D";
		String target = "J";
		String filePath = "./src/test/resources/Example1";
		long startTime = System.currentTimeMillis();
		BufferedReader br = new CustomFileLoader().loadFile(filePath);
		ConnectionsBuilder cb = new ConnectionsBuilder(br, start, target);
		ConcurrentHashMap<String, City> data = cb.buildConnections();
		ConnectionFinder cf = new ConnectionFinder(start, target, data);
		cf.checkConnection();
		System.out.println("Processing Time: "
				+ (System.currentTimeMillis() - startTime));
	}

	@Ignore
	@Test
	public void findConnectionITExample2() {
		String start = "Ypsilanti";
		String target = "Boston";
		String filePath = "./src/test/resources/Example2";
		long startTime = System.currentTimeMillis();
		BufferedReader br = new CustomFileLoader().loadFile(filePath);
		ConnectionsBuilder cb = new ConnectionsBuilder(br, start, target);
		ConcurrentHashMap<String, City> data = cb.buildConnections();
		ConnectionFinder cf = new ConnectionFinder(start, target, data);
		cf.checkConnection();
		System.out.println("Processing Time: "
				+ (System.currentTimeMillis() - startTime));
	}

	@Ignore
	@Test
	public void FindConnectionITExample3BigData() {
		String start = "Menard";
		String target = "Palomas";
		String filePath = "./src/test/resources/connections";
		BufferedReader br = new CustomFileLoader().loadFile(filePath);
		ConnectionsBuilder cb = new ConnectionsBuilder(br, start, target);
		ConcurrentHashMap<String, City> data = cb.buildConnections();
		ConnectionFinder cf = new ConnectionFinder(start, target, data);
		cf.checkConnection();

	}
}
