package es.uniovi.asw.parser.agents;

public class SensorAgent extends AbstractAgent {

	public SensorAgent(String name, String location, String email, String identifier, int kind) {
		super(name, location, email, identifier, kind);
	}

	public SensorAgent(Object[] data) {
		super((String)data[0],(String)data[1],(String)data[2],(String) data[3], (Integer)data[4]);	
	}

}
