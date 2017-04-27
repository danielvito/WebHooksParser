package devitos.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import devitos.model.WebHook;

/**
 * Load.
 * 
 * @author daniel.silveira
 */
public class Load {

	final static Logger logger = Logger.getLogger(Load.class);

	/**
	 * Load webhook file - specific number of lines.
	 * 
	 * @param fileName
	 *            File name
	 * @param lines
	 *            Number of lines to be read
	 * @return List of persons
	 * @throws IOException
	 */
	public static List<WebHook> loadFile(String fileName, int lines) throws IOException {
		String line = "";

		List<WebHook> webHooks = new ArrayList<WebHook>();

		BufferedReader br = new BufferedReader(new FileReader(fileName));
		Pattern pattern = Pattern.compile(
				"level=(.*) response_body=\"(.*)\" request_to=\"(.*)\" response_headers=(.*) response_status=\"(.*)\"");

		int count = 0;
		while ((line = br.readLine()) != null) {
			Matcher matcher = pattern.matcher(line);
			if (matcher.find()) {
				WebHook webHook = new WebHook();
				webHook.level = matcher.group(1);
				webHook.responseBody = matcher.group(2);
				webHook.requestTo = matcher.group(3);
				webHook.responseHeaders = matcher.group(4);
				webHook.responseStatus = matcher.group(5);
				webHooks.add(webHook);
				count++;

				logger.debug("Count:" + count + ", webHook:" + webHook);
			}

			if (count >= lines && lines > 0)
				break;
		}

		br.close();

		return webHooks;
	}

	/**
	 * Load webhook file - all lines.
	 * 
	 * @param fileName
	 *            File name
	 * @return List of persons
	 * @throws IOException
	 */
	public static List<WebHook> loadFileAllLines(String fileName) throws IOException {
		return loadFile(fileName, 0);
	}

}
