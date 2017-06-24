package test.analysis.pojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import analysis.pojo.User;
/**
 * Tests the User POJO.
 * 
 * @author Henk
 *
 */
public class UserTest {

	/**
	 * The user used for this test.
	 */
	private static User userMock;

	/**
	 * Name used for the user.
	 */
	final private static String USER_NAME = "John";
	
	/**
	 * Non-mock user for testing.
	 */
	final private User user = new User(USER_NAME);
	
	@Before
	public void setUp() {
		userMock = Mockito.mock(User.class);
		Mockito.when(userMock.getName()).thenReturn(USER_NAME);
	}

	/**
	 * Tests if the constructor sets it's field properly.
	 */
	@Test
	public void testConstructor() {
		assertEquals("The names were not equal.", USER_NAME, user.getName());
	}
	
	/**
	 * Tests if equal by pointer case is caught.
	 */
	@Test
	public void testEqualsPointer() {
		assertTrue("They shoud be equal by pointer.", userMock.equals(userMock));
		Mockito.verify(userMock, Mockito.times(0)).getName();
	}
	
	/**
	 * Tests if equal by values case is caught.
	 */
	@Test
	public void testEqualsValue() {
		assertTrue("They shoud be equal by value.", user.equals(userMock));
		Mockito.verify(userMock).getName();
	}
	
	/**
	 * Tests if equal by values case is caught.
	 */
	@Test
	public void testEqualsNull() {
		assertFalse("Should be false, since it's compared to null.", userMock.equals(null));
		Mockito.verify(userMock, Mockito.times(0)).getName();
	}
}
