package es.uniovi.asw.parser.agents;

import es.uniovi.asw.parser.ReadList;
import es.uniovi.asw.parser.SingletonParser;

/**
 * 
 * @author Jorge  Class used to represent EntityAgents and parse their data.
 *
 */
public class GeneralAgent extends AbstractAgent {

	public GeneralAgent(String name, String location, String email, String identifier, int kind) {
		super(name, location, email, identifier, kind);
	}

	public GeneralAgent(Object[] data) {
		super((String)data[0],(String)data[1],(String)data[2],(String) data[3], (Integer)data[4]);	
	}

	public String toString() {
		ReadList rl = SingletonParser.getInstance().getDefaultExcelReadList();
		String kind = rl.getMasterKinds().get(this.kind);
		return kind + " Agent [Name=" + this.name
				+ ", location=" + this.location
				+ ", email=" + this.email
				+ ", identifier=" + this.identifier
				+"]";
	}
}
