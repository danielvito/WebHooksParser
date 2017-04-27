package devitos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import devitos.model.WebHook;
import devitos.util.Load;
import devitos.util.Report;

public class TestApp {

	final static Logger logger = Logger.getLogger(TestApp.class);

	@Rule
	public ExpectedException exception = ExpectedException.none();

	/**
	 * Test load file
	 * 
	 * @throws IOException
	 */
	@Test
	public void testLoadFileOnlyOneLine() throws IOException {
		List<WebHook> webHooks = Load.loadFile("log.txt", 1);
		assertEquals(webHooks.size(), 1, 0.0);
		WebHook webHook = webHooks.iterator().next();
		assertNotNull(webHook.level);
	}

	/**
	 * Test if invalid file @throws Exception.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testInvalidFile() throws Exception {
		exception.expect(IOException.class);
		Load.loadFile("log123.txt", 1);
	}

	/**
	 * Load challenge file.
	 * 
	 * @throws IOException
	 */
	@Test
	public void testLoadFilechallenge() throws IOException {
		List<WebHook> webHooks = Load.loadFileAllLines("log.txt");
		assertEquals(webHooks.size(), 10000, 0.0);
	}

	/**
	 * Top 3 url challenge.
	 * 
	 * @throws IOException
	 */
	@Test
	public void testTop3Urls() throws IOException {
		Report.top3Urls();
	}

	/**
	 * Summarize by status challenge.
	 * 
	 * @throws IOException
	 */
	@Test
	public void testSummarizeByStatus() throws IOException {
		Report.summarizeByStatus();
	}
}
