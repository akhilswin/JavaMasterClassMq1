package yaksha;

import static yaksha.TestUtils.businessTestFile;
import static yaksha.TestUtils.currentTest;
import static yaksha.TestUtils.yakshaAssert;
import org.junit.jupiter.api.Test;

class MainClassTest { 
	
	@Test
	public void testExceptionConditon() throws Exception {

		TestUtils.yakshaAssert(TestUtils.currentTest(), true, TestUtils.boundaryTestFile);
	}

	@Test
	public void testBoundaryCondition() throws Exception {

		TestUtils.yakshaAssert(TestUtils.currentTest(), true, TestUtils.exceptionTestFile);
	}

	@Test
	void testHighestScorer() throws Exception {
		// Test will pass
		String information1[] = { "sunil-56-88-23", "bindul-88-70-10", "john-70-49-65" };
		StudentInformation studentInformation1 = new StudentInformation(information1);
		try {

			yakshaAssert(currentTest(),
					(MainClass.highestScorer(studentInformation1).equals("john") ? "true" : "false"), businessTestFile);
		} catch (InvalidMarkException e) {
			e.printStackTrace();
		}
	}
}


