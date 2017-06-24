package analysis.pojo;

import java.awt.List;
import java.util.ArrayList;

import analysis.FileReader.pojoReader;
import analysis.FileReader.statisticsReader;

/**
 * POJO which represents a group of people in the same Whatsapp chat. A group
 * implies 2 or more people.
 * 
 * @author Henk
 *
 */
public class Group extends ArrayList<User> {

	/**
	 * Name of the chat the group is part of.
	 */
	private String name;

	/**
	 * File path to the file used for creating buildig this group.
	 */
	private String filePath;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            Name of the chat the group is part of.
	 */
	public Group(final String name) {
		this.name = name;
	}

	/**
	 * Adds a user to this group.
	 * 
	 * @param user
	 *            User to add to the group.
	 */
	public void addUser(final User user) {
		this.add(user);
	}

	/**
	 * Adds all users in it's specified file to it's group.
	 */
	public void buildUsers() {
		pojoReader.addUsers(filePath, this);
	}
	
	/**
	 * Adds all messages to the users part of this group..
	 */
	public void buildUserMessages() {
		statisticsReader.addUserMessages(filePath, this);
	}

	/**
	 * Checks if the group contains a certain user.
	 * 
	 * @param user
	 *            User to check for.
	 * @return True if it does contain the user.
	 */
	public boolean contains(final User user) {
		boolean result = false;
		for (final User user2 : this) {
			if (user.equals(user2)) {
				result = true;
				break;
			}
		}
		return result;
	}

	/**
	 * Calculates the message percentage for every user in this group.
	 * O(2n)
	 */
	public void calculateUserPercentages() {
		double sum = 0;
		for (final User user : this) {
			sum += user.messagesSent();
		}
		
		for (final User user : this) {
			user.setMessagePercentage(user.messagesSent()/sum);
		}
	}
	
	/**
	 * Calculates the characers percentage for every user in this group.
	 * O(2n)
	 */
	public void calculateUserPercentagesChar() {
		double sum = 0;
		for (final User user : this) {
			sum += user.charactersSent();
		}
		
		for (final User user : this) {
			user.setCharactersPercentage(user.charactersSent()/sum);
		}
	}

	/**
	 * Gets the user by Name from this group.
	 * 
	 * @param name
	 *            Name of the user to get.
	 * @return Null if the user is not present in the group, returns the user
	 *         otherwise.
	 */
	public User getUserByName(final String name) {
		User user = null;

		for (final User user2 : this) {
			if (user2.getName().equals(name)) {
				user = user2;
				break;
			}
		}

		return user;
	}

	/// Start Setters and Getters ///

	/**
	 * Sets the file path used for building this group.
	 * 
	 * @param filePath
	 *            File path (e.g. C:/user/John/deer.txt)
	 */
	public void setFilePath(final String filePath) {
		this.filePath = filePath;
	}

	/**
	 * @return The name of the group.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            The name of the group to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return The file path of the file used to build this group.
	 */
	public String getFilePath() {
		return filePath;
	}
}
