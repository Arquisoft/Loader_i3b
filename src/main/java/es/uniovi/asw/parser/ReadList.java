package es.uniovi.asw.parser;

import java.util.Set;

import es.uniovi.asw.parser.agents.AbstractAgent;

/**
 * @author Oriol
 * 
 */
public interface ReadList {
	Set<AbstractAgent> parse(String ruta);

	void parseMaster(String ruta);
}
