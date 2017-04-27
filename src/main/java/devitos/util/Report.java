package devitos.util;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import devitos.model.WebHook;

public class Report {

	final static Logger logger = Logger.getLogger(Report.class);

	/**
	 * Prints a total of webhooks by status.
	 * 
	 * @throws IOException
	 */
	public static void summarizeByStatus() throws IOException {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		List<WebHook> webHooks = Load.loadFileAllLines("log.txt");
		logger.debug("Total: " + webHooks.size());
		Iterator<WebHook> it = webHooks.iterator();
		while (it.hasNext()) {
			WebHook webHook = it.next();
			if (!map.containsKey(webHook.responseStatus))
				map.put(webHook.responseStatus, 0);
			map.put(webHook.responseStatus, map.get(webHook.responseStatus) + 1);
		}

		Comparator<String> comparator = new ValueComparator<String, Integer>(map);
		TreeMap<String, Integer> result = new TreeMap<String, Integer>(comparator);
		result.putAll(map);

		for (Map.Entry<String, Integer> entry : result.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			logger.info(key + " - " + value);
		}
	}

	/**
	 * Prints the 3 most requested urls.
	 * 
	 * @throws IOException
	 */
	public static void top3Urls() throws IOException {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		List<WebHook> webHooks = Load.loadFileAllLines("log.txt");
		logger.debug("Total: " + webHooks.size());
		Iterator<WebHook> it = webHooks.iterator();
		while (it.hasNext()) {
			WebHook webHook = it.next();
			if (!map.containsKey(webHook.requestTo))
				map.put(webHook.requestTo, 0);
			map.put(webHook.requestTo, map.get(webHook.requestTo) + 1);
		}

		Comparator<String> comparator = new ValueComparator<String, Integer>(map);
		TreeMap<String, Integer> result = new TreeMap<String, Integer>(comparator);
		result.putAll(map);

		int count = 0;
		for (Map.Entry<String, Integer> entry : result.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			logger.info(key + " - " + value);
			count++;
			if (count == 3)
				break;
		}
	}

}
