package test.analysis.fileReader;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import analysis.FileReader.pojoReader;
import analysis.pojo.Group;
import analysis.pojo.User;

/**
 * Tests file reader methods used to generate POJOs.
 * 
 * @author Henk
 *
 */
public class pojoReaderTest {
	
	/**
	 * Group used for reading.
	 */
	private static Group group;
	
	@Before
	public void setUp() {
		group = new Group("TestName");
	}
 
	/**
	 * Tests the reader on a file which contains basic cases.
	 * Format: "20/11/2015, 15:21:43: Bart Deer: Jeej"
	 * 
	 */
	@Test
	public void testPojoReaderAddUsersBasic() {
		pojoReader.addUsers("src/resources/test_chat_1.txt", group);
		assertEquals("Two users were contained in the test file.", 2, group.size());
	}

	/**
	 * Tests the reader on a file which contains more extensive cases.
	 * Format: "20/11/2015, 15:21:43: Bart Deer: Jeej"
	 * 
	 */
	@Test
	public void testPojoReaderAddUsers() {
		pojoReader.addUsers("src/resources/test_chat_2.txt", group);
		assertEquals("Two users were contained in the test file.", 2, group.size());
	}
	
	/**
	 * Tests the reader on a file containing a user writing potential dangerous messages.
	 * Format: "20/11/2015, 15:21:43: Bart Deer: Jeej"
	 * 
	 */
	@Test
	public void testPojoReaderAddUsersMessage() {
		pojoReader.addUsers("src/resources/test_chat_3.txt", group);
		assertEquals("Two users were contained in the test file.", 3, group.size());
	}
}
