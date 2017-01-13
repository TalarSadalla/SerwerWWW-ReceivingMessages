package pl.sda.projekt;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class EquationFactory {

	private static EquationFactory instance;

	public synchronized static EquationFactory getInstance() {
		if (instance == null) {
			instance = new EquationFactory();
		}
		return instance;
	}

	public Equation produce(String json) throws JsonParseException, JsonMappingException, IOException {

		Equation equation = null;
		ObjectMapper mapper = new ObjectMapper();
		equation = mapper.readValue(json.toString(), Equation.class);

		String[] split = equation.getProblem().split("=");
		String part1 = split[0]; //
		String part2 = split[1];
		String[] split2 = split[0].split("x");
		Integer a = Integer.valueOf(split[1]);
		Integer b = Integer.valueOf(split2[1]);
		Integer c = a - b;
		equation.setResult(c);

		return equation;
	}

}
