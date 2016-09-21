package ie.com.fexco.eircode.api.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ie.com.fexco.eircode.api.exception.ConnectionException;
import ie.com.fexco.eircode.api.service.ConnectionService;
import ie.com.fexco.eircode.api.util.EirCodeUtil;

@Service
public class ConnectionServiceImpl implements ConnectionService
{

	private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionServiceImpl.class);

	@Override
	public String connect(final String fullURL, final String format) throws ConnectionException
	{

		LOGGER.info("INI: connect(String , String , String)");

		StringBuilder sb = new StringBuilder();

		// call the service
		HttpURLConnection connection;
		try
		{
			connection = (HttpURLConnection) new URL(fullURL).openConnection();

			LOGGER.info("EXE: " + connection.getURL());

			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", EirCodeUtil.APPLICATION + format);

			// check for call failure
			if (connection.getResponseCode() != HttpURLConnection.HTTP_OK)
			{
				throw new ConnectionException("Failed : HTTP error code : " + connection.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = br.readLine()) != null)
			{
				sb.append(line);
			}
			br.close();

		} catch (IOException e)
		{
			LOGGER.info("EXCPT: connect(String , String , String , String ) ", e);
			throw new ConnectionException(e.getMessage(), e);
		}

		LOGGER.info("END: connect(String , String , String , String ) ");

		return sb.toString();
	}

}
