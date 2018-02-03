package es.uniovi.asw.parser.agents;

public class PersonAgent extends AbstractAgent {

	public PersonAgent(String name, String location, String email, String identifier, int kind) {
		super(name, location, email, identifier, kind);
		// TODO Auto-generated constructor stub
	}

	public PersonAgent(Object[] data) {
super((String)data[0],(String)data[1],(String)data[2],(String) data[3], (Integer)data[4]);	}

}
