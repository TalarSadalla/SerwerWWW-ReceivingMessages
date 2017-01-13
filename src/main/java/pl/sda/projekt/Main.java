package pl.sda.projekt;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public class Main {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		// String url = "http://localhost:8090/equations/get";
		//
		// HttpClient client = HttpClientBuilder.create().build();
		// HttpGet request = new HttpGet(url);
		//
		// // add request header
		// request.addHeader("User-Agent", HTTP.USER_AGENT);
		// HttpResponse response = client.execute(request);
		//
		// System.out.println("Response Code : " +
		// response.getStatusLine().getStatusCode());
		//
		// BufferedReader rd = new BufferedReader(new
		// InputStreamReader(response.getEntity().getContent()));
		//
		// StringBuffer result = new StringBuffer();
		// String line = "";
		// while ((line = rd.readLine()) != null) {
		// result.append(line);
		// }
		// System.out.println(result);
		//
		// ObjectMapper mapper = new ObjectMapper();
		// Equation equation = null;
		// equation = mapper.readValue(result.toString(), Equation.class);
		// // System.out.println(equation.getId());
		//
		// String[] split = equation.getProblem().split("=");
		// String part1 = split[0]; //
		// String part2 = split[1];
		// // System.out.println(split[0]);
		// System.out.println(split[1]);
		// String[] split2 = split[0].split("x");
		// // System.out.println(split2[0]);
		// System.out.println(split2[1]);
		// Integer a = Integer.valueOf(split[1]);
		// Integer b = Integer.valueOf(split2[1]);
		// Integer c = a - b;
		// System.out.println(c);
		// equation.setResult(c);
		//
		// String JsonToSave = mapper.writeValueAsString(equation);
		//
		// try {
		//
		// File newTextFile = new File("FileToSend.txt");
		// FileWriter fw = new FileWriter(newTextFile, true);
		// BufferedWriter out = new BufferedWriter(fw);
		// out.newLine();
		// out.write(JsonToSave);
		// out.close();
		//
		// } catch (IOException iox) {
		// // do stuff with exception
		// iox.printStackTrace();
		// }
		//
		// String url1 = "http://localhost:8090/equations/solve";
		//
		// HttpClient client1 = HttpClientBuilder.create().build();
		// HttpPost post = new HttpPost(url1);
		//
		// // add header
		// post.setHeader("User-Agent", HTTP.USER_AGENT);
		// post.setHeader("Content-type", "application/json");
		//
		// // List<NameValuePair> urlParameters = new
		// ArrayList<NameValuePair>();
		// // urlParameters.add(new BasicNameValuePair("sn", "C02G8416DRJM"));
		//
		// post.setEntity(new StringEntity(JsonToSave));
		//
		// HttpResponse response1 = client1.execute(post);
		// System.out.println("Response Code : " +
		// response1.getStatusLine().getStatusCode());
		//
		// BufferedReader rd1 = new BufferedReader(new
		// InputStreamReader(response1.getEntity().getContent()));
		//
		// StringBuffer result1 = new StringBuffer();
		// String line1 = "";
		// while ((line1 = rd1.readLine()) != null) {
		// result1.append(line1);
		// }
		//
		// System.out.println(result1);

		String url = "http://localhost:8090/equations/get";
		String url2 = "http://localhost:8090/equations/solve";
		EquationFacadeCommunication facade = new EquationFacadeCommunication();
		Equation result = facade.RequestLoad(url);
		EquationFacadeStorage facadeStor = new EquationFacadeStorage();
		String json = facadeStor.RequestSave(result);
		facade.RequestSend(url2, json);
	}
}
