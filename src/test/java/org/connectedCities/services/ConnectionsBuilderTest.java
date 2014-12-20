package org.connectedCities.services;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConnectionsBuilderTest {

	@Test
	public void testGetConnectedCities() {
		String line = "Philadelphia, Pittsburgh".toLowerCase();
		ConnectionsBuilder cb = new ConnectionsBuilder(null, "la", "new york");
		String result[] = cb.getConnectedCities(line);
		assertTrue("philadelphia".equals(result[0])
				&& "pittsburgh".equals(result[1]));
	}

	@Test
	public void testCheckDirectConnection() {
		String[][] connections = { { "philadelphia", "pittsburgh" },
				{ "boston", "new york" }, { "philadelphia", "new york" },
				{ "los angeles", "san diego" }, { "new york", "croton-harmon" } };
		ConnectionsBuilder cb = new ConnectionsBuilder(null, "San Diego",
				"Los Angeles");
		for (String[] connection : connections) {
			cb.checkDirectConnection(connection);
		}

	}
}
