package org.connectedCities.services;

import java.io.BufferedReader;
import java.util.concurrent.ConcurrentHashMap;
import org.connectedCities.domain.City;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

public class FullITConnectionsBuilder {
	@Ignore
	@Test
	public void testConnectionBuilderSmallData() {
		String filePath = "./src/test/resources/SmallData";
		BufferedReader br = new CustomFileLoader().loadFile(filePath);
		ConnectionsBuilder cb = new ConnectionsBuilder(br, "Ugashik", "Poteau");
		ConcurrentHashMap<String, City> data = cb.buildConnections();
		assertNotNull(data);
		assertTrue(data.size() == 46);
		assertTrue(data.containsKey("pinta"));
		assertTrue(data.containsKey("blue mound"));
		assertTrue(data.containsKey("jet"));
		assertTrue(data.containsKey("chamisal"));
	}

	@Ignore
	@Test
	public void testConnectionBuilderBigData() {
		String filePath = "./src/test/resources/connections";
		long start = System.currentTimeMillis();
		BufferedReader br = new CustomFileLoader().loadFile(filePath);
		ConnectionsBuilder cb = new ConnectionsBuilder(br, "Ugashik", "Poteau");
		ConcurrentHashMap<String, City> data = cb.buildConnections();
		System.out.println("Processing : "
				+ (System.currentTimeMillis() - start));
		System.out.println("Map size: " + data.size());
	}

	@Ignore
	@Test
	public void testDirectConnectionBuilderBigData() {
		String filePath = "./src/test/resources/connections";
		BufferedReader br = new CustomFileLoader().loadFile(filePath);
		ConnectionsBuilder cb = new ConnectionsBuilder(br, "Mira Monte",
				"Mays Lick");
		ConcurrentHashMap<String, City> data = cb.buildConnections();
	}
}
