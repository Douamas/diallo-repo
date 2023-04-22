package com.luv2code.junitdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class ConditionalTest {

	@Test
	@Disabled("Don't run util JIRA #123 is resolved")
	void basicTest() {

	}

	@Test
	@EnabledOnOs(OS.WINDOWS)
	void testForWindowsOnly() {

	}
	
	@Test
	@EnabledOnOs(OS.MAC)
	void testForMacOnly() {

	}
	
	@Test
	@EnabledOnOs( {OS.MAC,OS.WINDOWS})
	void testForMacAndWindowsOnly() {

	}
	
	@Test
	@EnabledOnOs(OS.LINUX)
	void testForLinuxOnly() {

	}
	
	@Test
	@EnabledOnJre(JRE.JAVA_17)
	void testOnlyForJava17() {

	}
	
	@Test
	@EnabledOnJre(JRE.JAVA_13)
	void testOnlyForJava13() {

	}
	
	@Test
	@EnabledForJreRange(min= JRE.JAVA_13, max = JRE.JAVA_18)
	void testOnlyForRange() {

	}
	
	@Test
	@EnabledForJreRange(min= JRE.JAVA_11)
	void testOnlyForRangeMin() {

	}

	
	@Test
	@EnabledIfEnvironmentVariable(named = "LUV2CODE_ENV", matches = "DEV")
	void testOnlyForDevEnvironment() {

	}
	
	@Test
	@EnabledIfSystemProperty(named = "LUV2CODE_SYS_PROP", matches = "CI_CD_DEPLOY")
	void testOnlyForSystemProperty() {

	}
}
