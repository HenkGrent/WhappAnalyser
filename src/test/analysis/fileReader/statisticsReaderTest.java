package test.analysis.fileReader;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import analysis.FileReader.pojoReader;
import analysis.FileReader.statisticsReader;
import analysis.pojo.Group;
import analysis.pojo.User;

/**
 * Tests file reader methods used to generate POJOs.
 * 
 * @author Henk
 *
 */
public class statisticsReaderTest {
	
	/**
	 * Group used for reading.
	 */
	private static Group group;
	
	@Before
	public void setUp() {
		group = new Group("TestName");
		pojoReader.addUsers("src/resources/test_chat_4.txt", group);
	}


	/**
	 * Tests the reader on a file containing 4 users and moderate amount of messages.
	 * Checks for the amount of messages.
	 * Format: "20/11/2015, 15:21:43: Bart Deer: Jeej"
	 * 
	 */
	@Test
	public void testStatisticsReaderMessageSize() {
		statisticsReader.addUserMessages("src/resources/test_chat_4.txt", group);
		assertEquals("Bart Deer wrote 4 messages.", 4, group.getUserByName("Bart Deer").getMessages().size());
	}
	
	/**
	 * Tests the reader on a file containing 4 users and moderate amount of messages.
	 * Checks for the content of the messages.
	 * Format: "20/11/2015, 15:21:43: Bart Deer: Jeej"
	 * 
	 */
	@Test
	public void testStatisticsReaderMessageContent() {
		statisticsReader.addUserMessages("src/resources/test_chat_4.txt", group);
		for(String message : group.getUserByName("Bart Deer").getMessages()) {
			assertEquals("Bart Deer only writes 'Jeej'.", "Jeej", message);
		}
	}
}
