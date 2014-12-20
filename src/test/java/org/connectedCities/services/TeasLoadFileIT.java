package org.connectedCities.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.MappedByteBuffer;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
public class TeasLoadFileIT {

	@Test
	public void testLoadFileRosy(){
		File connections = new File("./src/test/resources/connections");
		CustomFileLoader fileLoader = new CustomFileLoader();
		MappedByteBuffer mByteBuffer = fileLoader.loadDataFile(connections);
		assertNotNull(mByteBuffer);
		assertTrue(mByteBuffer.limit()!=0);
		assertTrue(mByteBuffer.limit()==connections.length());
	}
	@Test
	public void testGetBufferedReaderIT() throws IOException{
		File connections = new File("./src/test/resources/connections");
		CustomFileLoader fileLoader = new CustomFileLoader();
		MappedByteBuffer mByteBuffer = fileLoader.loadDataFile(connections);
		BufferedReader BReader = fileLoader.getBufferedReader(mByteBuffer);
		assertNotNull(BReader);
		assertTrue(BReader.ready());
		
	}
	@Test
	public void testingOpeningFileDoesntExist(){
		File invalidFile = new File("file_doesnt_exist");
		new CustomFileLoader().checkFile(invalidFile);
	}
	@Test
	public void testingOpeningEmptyFile(){
		File emptyFile = new File("./src/test/resources/emptyFile");
		new CustomFileLoader().checkFile(emptyFile);
	}
	
}
