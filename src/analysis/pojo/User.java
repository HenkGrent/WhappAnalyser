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
	 * Determines if the user's fields are updated.
	 */
	private boolean updated = false;

	/**
	 * Represents the name of a user (e.g. "John").
	 */
	private String name;

	/**
	 * Messages a user sent.
	 */
	private ArrayList<String> messages;

	/**
	 * Amount of character a user sent.
	 */
	private int characterCount = 0;

	/**
	 * Percentage of messages this user sent in the group it's part of.
	 */
	private double messagePercentage;
	
	/**
	 * Percentage of characters this user sent in the group it's part of.
	 */
	private double charactersPercentage;


	/**
	 * Constructor.
	 * 
	 * @param name
	 *            Name of the user.
	 */
	public User(final String name) {
		this.name = name;
	}

	public void update() {
		calculateCharacters();
		updated = true;
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

	/**
	 * Calculates the amount of characters the user sent.
	 */
	private void calculateCharacters() {
		characterCount = 0;
		for (final String message : getMessages()) {
			characterCount += message.length();
		}
	}

	/**
	 * Returns the character count. May trigger the update() trigger.
	 * 
	 * @return
	 */
	public int charactersSent() {
		if (!updated) {
			update();
		}
		return characterCount;
	}

	/**
	 * The amount of messages a user sent in a group.
	 * 
	 * @return The amount of messages sent.
	 */
	public int messagesSent() {
		return messages.size();
	}
	
	/**
	 * Message percentage of a group.
	 */
	public double messagePercentage() {
		return messagePercentage;
	}
	
	/**
	 * Characters percentage of a group.
	 */
	public double charactersPercentage() {
		return charactersPercentage;
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
	 * @param messages
	 *            The messages a user sent.
	 */
	public void setMessages(ArrayList<String> messages) {
		updated = false;
		this.messages = messages;
	}

	/**
	 * Sets the percentage of messages this person sent in a group.
	 * 
	 * @param percentage
	 *            Percentage of messages.
	 */
	protected void setMessagePercentage(final double percentage) {
		this.messagePercentage = percentage;
	}
	
	/**
	 * Sets the percentage of characters this person sent in a group.
	 * 
	 * @param percentage
	 *            Percentage of characters.
	 */
	protected void setCharactersPercentage(final double percentage) {
		this.charactersPercentage = percentage;
	}
}
