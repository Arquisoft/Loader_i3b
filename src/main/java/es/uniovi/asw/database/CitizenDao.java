package es.uniovi.asw.database;

import java.util.List;

import es.uniovi.asw.parser.Citizen;
import es.uniovi.asw.parser.agents.AbstractAgent;

/**
 * Interface for the methods that the DAO must accomplish
 * 
 * @author Gonzalo de la Cruz Fernández - UO244583
 *
 */
public interface CitizenDao {

	boolean insert(AbstractAgent c);

	Citizen findById(String ID);

	void remove(String ID);

	List<Citizen> findAll();

	void cleanDatabase();
	//prueba
}
