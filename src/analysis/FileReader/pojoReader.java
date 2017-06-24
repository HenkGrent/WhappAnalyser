package analysis.FileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import analysis.pojo.Group;
import analysis.pojo.User;

public class pojoReader {

	/**
	 * Builds all the Users for a Group. Ignoring users who added or changed
	 * something.
	 * 
	 * @param filePath
	 *            The file path to the file to read from.
	 * @param group
	 *            The group to add users to.
	 */
	public static void addUsers(final String filePath, final Group group) {
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
			System.out.println(line);
			// The first check is done to ensure the substring check doesn't
			// throw an error.
			if (line.length() > 20 && line.substring(20, 21).equals(":")) {
				// The line without the date.
				final String lineNoDate = line.substring(21, line.length());
				final int messageStart = lineNoDate.indexOf(":");
				if (messageStart > -1) {
					final String name = lineNoDate.substring(0, messageStart);
					final User user = new User(name);
					if (!group.contains(user)) {
						group.addUser(user);
					}
				}
			}
		}
		sc.close();
	}
}
