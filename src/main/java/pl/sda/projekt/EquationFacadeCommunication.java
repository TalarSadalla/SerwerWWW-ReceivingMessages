package pl.sda.projekt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

public class EquationFacadeCommunication {

	public Equation RequestLoad(String httpName) throws JsonParseException, JsonMappingException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(httpName);

		// add request header
		request.addHeader("User-Agent", HTTP.USER_AGENT);
		HttpResponse response = client.execute(request);

		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		System.out.println(result);

		Equation equation = EquationFactory.getInstance().produce(result.toString());
		return equation;

	};

	public StringBuffer RequestSend(String url, String json)
			throws JsonParseException, JsonMappingException, IOException {
		String url1 = url;

		HttpClient client1 = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url1);

		// add header
		post.setHeader("User-Agent", HTTP.USER_AGENT);
		post.setHeader("Content-type", "application/json");

		// List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		// urlParameters.add(new BasicNameValuePair("sn", "C02G8416DRJM"));

		post.setEntity(new StringEntity(json));

		HttpResponse response1 = client1.execute(post);
		System.out.println("Response Code : " + response1.getStatusLine().getStatusCode());

		BufferedReader rd1 = new BufferedReader(new InputStreamReader(response1.getEntity().getContent()));

		StringBuffer result1 = new StringBuffer();
		String line1 = "";
		while ((line1 = rd1.readLine()) != null) {
			result1.append(line1);
		}
		System.out.println(result1);
		return result1;
	};
}
