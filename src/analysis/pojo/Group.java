package analysis.pojo;

/**
 * POJO which represents a group of people in the same Whatsapp chat.
 * A group implies 2 or more people.
 * 
 * @author Henk
 *
 */
public class Group {
	
	/**
	 * Name of the chat the group is part of.
	 */
	private String name;
	
	public Group(final String name) {
		this.name = name;
	}
}
