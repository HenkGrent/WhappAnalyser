package analysis.pojo;

import java.util.ArrayList;

/**
 * POJO which represents a person who participated (i.e. did anything) in a
 * Whatsapp Chat.
 * 
 * @author Henk
 *
 */
public class User {

	/**
	 * Represents the name of a user (e.g. "John").
	 */
	private String name;

	/**
	 * Messages a user sent.
	 */
	private ArrayList<String> messages;
	
	/**
	 * Constructor.
	 * @param name Name of the user.
	 */
	public User(final String name) {
		this.name = name;
	}

	/**
	 * Equality method: checks equality of names.
	 * 
	 * @param user2
	 *            User to check equality with.
	 * @return True if they are equal.
	 */
	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null) {
			return false;
		}
		boolean result = false;
		if (other instanceof User) {
			User that = (User) other;
			result = (this.getName().equals(that.getName()));
		}
		return result;
	}

	/// Start setters and Getters ///

	/**
	 * @return The name of the user.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the name of the user.
	 * 
	 * @param name
	 *            The name of the user. (e.g. John Benedict).
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * @return the messages the user sent.
	 */
	public ArrayList<String> getMessages() {
		return messages;
	}

	/**
	 * @param messages The messages a user sent.
	 */
	public void setMessages(ArrayList<String> messages) {
		this.messages = messages;
	}
}
