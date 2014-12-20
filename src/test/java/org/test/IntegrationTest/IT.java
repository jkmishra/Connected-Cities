package org.test.IntegrationTest;

import org.connectedCities.manager.Connected;
import org.junit.Ignore;
import org.junit.Test;

public class IT {
	@Ignore
	@Test
	public void testConnectedCitiesSmallDataFileNoRelation() {
		String[] args = { "./src/test/resources/SmallData", "Lafe", "Amazonia" };
		Connected.main(args);
	}
	@Ignore
	@Test
	public void testConnectedCitiesSmallDataFileConnectedCities() {
		String[] args = { "./src/test/resources/SmallData", "Lafe", "Quasqueton" };
		Connected.main(args);
	}
}
