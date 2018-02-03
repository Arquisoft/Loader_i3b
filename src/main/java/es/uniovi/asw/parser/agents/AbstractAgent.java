package es.uniovi.asw.parser.agents;

public abstract class AbstractAgent {
	protected String name;
	protected String location;
	protected String email;	
	protected String identifier;
	protected int kind;
	protected String password;
	
	public AbstractAgent(String name, String location, String email, String identifier, int kind) {
		super();
		this.name = name;
		this.location = location;
		this.email = email;
		this.identifier = identifier;
		this.kind = kind;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}

	public void setPassword(String string) {
		password = string;
	}
	public String getPassword() {
		return this.password;
	}
	
	
	
}
