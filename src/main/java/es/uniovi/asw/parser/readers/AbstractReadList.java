package es.uniovi.asw.parser.readers;

import java.util.HashMap;
import java.util.Set;

import es.uniovi.asw.database.AgentDao;
import es.uniovi.asw.database.MongoPersistanceFactory;
import es.uniovi.asw.parser.Citizen;
import es.uniovi.asw.parser.ReadList;
import es.uniovi.asw.parser.agents.AbstractAgent;
import es.uniovi.asw.parser.lettergenerators.ConsoleLetterGenerator;
import es.uniovi.asw.parser.lettergenerators.LetterGenerator;
import es.uniovi.asw.parser.parserutil.PasswordGenerator;
import es.uniovi.asw.reportwriter.WriteReport;
import es.uniovi.asw.reportwriter.WriteReportDefault;

/**
 * @author Oriol Template, concrete parsers (Excel/Word/txt/...) will override
 *         "doParse".
 */
public abstract class AbstractReadList implements ReadList {

	protected Set<AbstractAgent> agentsCensus;
	protected HashMap<Integer,String> masterKinds;
	private LetterGenerator letterGen;
	protected WriteReport wReport;

	public AbstractReadList() {
		this.letterGen = new ConsoleLetterGenerator();
		this.wReport = new WriteReportDefault();
	}

	public AbstractReadList(LetterGenerator letterGenerator) {
		this.letterGen = letterGenerator;
		this.wReport = new WriteReportDefault();
	}

	@Override
	public Set<AbstractAgent> parse(String ruta) {

		doParse(ruta);

		if (agentsCensus != null && agentsCensus.size() > 0) {
			PasswordGenerator.createPasswords(agentsCensus);
			insertCitizens(agentsCensus);
		}
		return agentsCensus;
	}

	private void insertCitizens(Set<AbstractAgent> census) {
		AgentDao dao = MongoPersistanceFactory.getAgentDAO();
		for (AbstractAgent c : census) {
			if (dao.insert(c)) {
				letterGen.generatePersonalLetter(c);
			}
		}
	}

	@Override
	public void parseMaster(String ruta) {

		doParseMaster(ruta);

	}
	protected abstract void doParse(String ruta);
	protected abstract void doParseMaster(String ruta);

}
