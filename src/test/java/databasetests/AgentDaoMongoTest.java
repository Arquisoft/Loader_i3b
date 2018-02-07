package databasetests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uniovi.asw.database.AgentDao;
import es.uniovi.asw.database.AgentDaoImplMongo;
import es.uniovi.asw.parser.ReadList;
import es.uniovi.asw.parser.SingletonParser;
import es.uniovi.asw.parser.agents.AbstractAgent;
import es.uniovi.asw.parser.agents.EntityAgent;
import es.uniovi.asw.parser.agents.GeneralAgent;
import es.uniovi.asw.parser.agents.PersonAgent;
import es.uniovi.asw.parser.agents.SensorAgent;
import es.uniovi.asw.parser.readers.ExcelReadList;

public class AgentDaoMongoTest {

	private PersonAgent dummy;
	private EntityAgent dummy1;
	private SensorAgent dummy2;
	private GeneralAgent dummy3;
	private static AgentDao dao;

	@BeforeClass
	public static void setUp() {
		dao = new AgentDaoImplMongo("localhost", 27017, "test_db", "agent_test");
		dao.cleanDatabase();
	}

	@Before
	public void insertCitizen() {
		dummy = new PersonAgent("a", "45,-1", "prueba@email.com", "12345678A", 1);
		dummy1 = new EntityAgent("b", "45,-1", "prueba@email.com", "12345678B", 2);
		dummy2 = new SensorAgent("c", "45,-1", "prueba@email.com", "12345678C", 3);
		dummy3 = new GeneralAgent("c", "45,-1", "prueba@email.com", "12345678D", 4);
		SingletonParser.getInstance().getDefaultExcelReadList().parseMaster("src/test/resources/masterTest.xlsx");
	}

	@After
	public void deleteAgents() {
		dao.cleanDatabase();
	}

	@Test
	public void testInsert() {
		
		dao.insert(dummy);
		List<AbstractAgent> agents = dao.findAll();

		assertEquals(agents.size(), 1);

		dao.insert(dummy1);
		dao.insert(dummy2);
		dao.insert(dummy3);

		agents = dao.findAll();

		assertEquals(agents.size(), 4);

	}

	@Test
	public void testFindAll() {
		dao.insert(dummy);
		dao.insert(dummy2);
		dao.insert(dummy1);
		dao.insert(dummy3);
		
		List<AbstractAgent> agents = dao.findAll();

		assertEquals(agents.size(), 4);

		assertTrue(agents.contains(dummy));
		assertTrue(agents.contains(dummy1));
		assertTrue(agents.contains(dummy2));
		assertTrue(agents.contains(dummy3));
	}

	@Test
	public void testFindById() {
		dao.insert(dummy);
		dao.insert(dummy3);

		AbstractAgent a = dao.findById("1");

		assertNull(a);

		a = dao.findById("12345678D");
		assertNotNull(a);
		assertEquals(dummy3, a);
	}

	@Test
	public void testRemove() {
		dao.insert(dummy);
		dao.insert(dummy1);
		dao.insert(dummy2);

		List<AbstractAgent> agents = dao.findAll();

		assertEquals(agents.size(), 3);

		dao.remove("1");

		assertTrue(agents.contains(dummy));
		assertTrue(agents.contains(dummy1));
		assertTrue(agents.contains(dummy2));

		agents = dao.findAll();

		assertEquals(agents.size(), 3);

		assertTrue(agents.contains(dummy));
		assertTrue(agents.contains(dummy1));
		assertTrue(agents.contains(dummy2));

		dao.remove("12345678B");

		agents = dao.findAll();

		assertEquals(agents.size(), 2);

		assertTrue(agents.contains(dummy));
		assertFalse(agents.contains(dummy1));
		assertTrue(agents.contains(dummy2));

		dao.remove("12345678C");

		agents = dao.findAll();

		assertEquals(agents.size(), 1);

		assertTrue(agents.contains(dummy));
		assertFalse(agents.contains(dummy1));
		assertFalse(agents.contains(dummy2));

	}

	@Test
	public void testNoDuplicates() {
		dao.insert(dummy);
		dao.insert(dummy);
		dao.insert(dummy);
		dao.insert(dummy);

		List<AbstractAgent> agents = dao.findAll();

		assertEquals(agents.size(), 1);
	}

}
