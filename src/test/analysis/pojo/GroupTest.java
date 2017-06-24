package test.analysis.pojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import analysis.pojo.Group;
import analysis.pojo.User;
/**
 * Tests the Group POJO.
 * 
 * @author Henk
 *
 */
public class GroupTest {

	/**
	 * Name used for a user.
	 */
	final private static String USER_NAME = "John";
	
	/**
	 * Name used for a user.
	 */
	final private static String USER_NAME2 = "John Deer";
	
	/**
	 * Name used for the group.
	 */
	final private static String GROUP_NAME = "Group1!";
	
	/**
	 * File path used for the group.
	 */
	final private static String FILE_PATH = "C:/A/B/group chat.txt";
	
	/**
	 * Non-mock Group for testing.
	 */
	private static Group group;
	
	@BeforeClass
	public static void setUp() {
		group = new Group(GROUP_NAME);
		group.setFilePath(FILE_PATH);
		group.addUser(new User(USER_NAME));
		group.addUser(new User(USER_NAME2));
	}

	/**
	 * Tests if the constructor sets it's field properly.
	 */
	@Test
	public void testConstructor() {
		assertEquals("The names were not equal.", GROUP_NAME, group.getName());
	}
	
	/**
	 * Tests if all members are added.
	 */
	@Test
	public void testMemberSize() {
		assertEquals("Two users have been added.", 2, group.size());
	}
	
	/**
	 * Tests if a user is already in the group.
	 */
	@Test
	public void testContains() {
		assertTrue("Two users have been added.", group.contains(new User(USER_NAME)));
	}
	
	/**
	 * Tests if the file path is set accordingly.
	 */
	@Test
	public void testFilePath() {
		assertEquals("Two users have been added.", FILE_PATH, group.getFilePath());
	}
}
