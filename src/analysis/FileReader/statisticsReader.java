package analysis.FileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import analysis.pojo.Group;
import analysis.pojo.User;

/**
 * Fetches certain statistics from a text file. These statistics are to be
 * extracted directly from the file.
 * 
 * @author Henk
 *
 */
public class statisticsReader {

	/**
	 * Builds a map from User.name -> 0.
	 * 
	 * @param group
	 *            Users to map the names from.
	 * @return
	 */
	private static Map<String, ArrayList<String>> initMap(final Group group) {
		final Map<String, ArrayList<String>> map = new HashMap<>();
		for (final User user : group) {
			map.put(user.getName(), new ArrayList<String>());
		}
		return map;
	}

	/**
	 * Adds the messages to users in a group.
	 * 
	 * @param map
	 *            The map containing User.name -> messages.
	 * @param group
	 *            The group containing the users.
	 */
	private static void setUserMessages(final Map<String, ArrayList<String>> map, final Group group) {
		for (final String name : map.keySet()) {
			final ArrayList<String> messages = map.get(name);
			group.getUserByName(name).setMessages(messages);
		}
	}

	/**
	 * Builds all messages for all users in a group.
	 * 
	 * @param filePath
	 *            The file path to the file to read from.
	 * @param group
	 *            The group containing users to add messages to.
	 */
	public static void addUserMessages(final String filePath, final Group group) {
		// HashMap used to keep track of the users.
		final Map<String, ArrayList<String>> mapMessages = initMap(group);
		FileReader reader = null;

		try {
			reader = new FileReader(filePath);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		final Scanner sc = new Scanner(reader);
		// Scan through the entire document.
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			// The first check is done to ensure the substring check doesn't
			// throw an error.
			if (line.length() > 20 && line.substring(20, 21).equals(":")) {
				// The line without the date.
				final String lineNoDate = line.substring(21, line.length());
				final int nameEnd = lineNoDate.indexOf(":");
				if (nameEnd > -1) {
					final String name = lineNoDate.substring(1, nameEnd);
					final String message = lineNoDate.substring(nameEnd + 2, lineNoDate.length());
					final ArrayList<String> messages = mapMessages.get(name);
					messages.add(message);
					mapMessages.put(name, messages);
				}
			}
		}
		sc.close();
		setUserMessages(mapMessages, group);
	}
}
