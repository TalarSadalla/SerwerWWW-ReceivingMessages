package pl.sda.projekt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class EquationFacadeStorage {

	public String RequestSave(Equation equation) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String JsonToSave = mapper.writeValueAsString(equation);

		try {

			File newTextFile = new File("FileToSend.txt");
			FileWriter fw = new FileWriter(newTextFile, true);
			BufferedWriter out = new BufferedWriter(fw);
			out.newLine();
			out.write(JsonToSave);
			out.close();

		} catch (IOException iox) {
			// do stuff with exception
			iox.printStackTrace();
		}
		System.out.println(JsonToSave);
		return JsonToSave;
	}

}
