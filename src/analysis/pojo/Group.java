package analysis.pojo;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

import analysis.FileReader.pojoReader;

/**
 * POJO which represents a group of people in the same Whatsapp chat. A group
 * implies 2 or more people.
 * 
 * @author Henk
 *
 */
public class Group {

	/**
	 * Name of the chat the group is part of.
	 */
	private String name;
	
	/**
	 * File path to the file used for creating buildig this group.
	 */
	private String filePath;

	/**
	 * Users part of this group.
	 */
	private ArrayList<User> users = new ArrayList<>();

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
		this.users.add(user);
	}
	
	/**
	 * Adds all users in it's specified file to it's group.
	 */
	public void buildUsers() {
		pojoReader.addUsers(filePath, this);
	}
	
	/**
	 * Checks if the group contains a certain user.
	 * @param user
	 * @return
	 */
	public boolean contains(final User user) {
		return users.contains(user);
	}
	
	/**
	 * Sets the file path used for building this group.
	 * @param filePath File path (e.g. C:/user/John/deer.txt)
	 */
	public void setFilePath(final String filePath) {
		this.filePath = filePath;
	}
}
