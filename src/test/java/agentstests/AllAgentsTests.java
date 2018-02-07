package agentstests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import parsertests.CitizenTest;
import parsertests.ExcelParseTest;
import parsertests.PasswordTest;
import parsertests.SingletonParserTest;

@RunWith(Suite.class)
@SuiteClasses({ PersonAgentTest.class, EntityAgentTest.class, GeneralAgentTest.class, 
	SensorAgentTest.class})
public class AllAgentsTests {

}
