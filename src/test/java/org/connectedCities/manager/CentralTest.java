package org.connectedCities.manager;

import org.connectedCities.manager.Connected;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
public class CentralTest {
	@Test
	public void TestCheckArgsEmptyList() {
		String[] args = { "" };
		assertTrue(!Connected.checkArgs(args));
	}
	@Test
	public void TestCheckArgsNoFileName() {
		String[] args = { "  ","A","B" };
		assertTrue(!Connected.checkArgs(args));
	}
	
	@Test
	public void TestCheckArgsInvalidCityName() {
		String[] args = { "rrs","\\$","B" };
		assertTrue(!Connected.checkArgs(args));
	}
}
