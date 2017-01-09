import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import okw.OKW_GetJavaClass;
import okw.core.EN;
import okw.log.Logger_Sngltn;
import okw.log.log2html.Log2HTML;
import okw.gui.frames.frmFirefox;

public class LoginTest {

	static Logger_Sngltn myLogger;
	
    static Log2HTML myLog2html;
	  /** 
	   *  \~german
	   *  Enthält den Namen des aktuellen junit Testfalls.
	   *  
	   * @see:   org.junit.rules.TestName
	   * \~
	   * @author Zoltan Hrabovszki
	   * @date 2014.12.03
	   */
		@Rule
		public TestName tcname = new TestName();
		
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
        myLogger = Logger_Sngltn.getInstance();
        myLog2html = new Log2HTML();

        // Reset/init the Logger
        Logger_Sngltn.Init();
        myLogger.AddLogger(myLog2html);

        myLogger.setDebugMode(false);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		myLog2html.Result2HTML("target/LoginTest.html");
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void Hello_OKW() throws Exception {
		EN.BeginTest(tcname.getMethodName());

		EN.EndTest();
	}

	@Test
	public void tcWP_Login() throws Exception {
		EN.BeginTest(tcname.getMethodName());
		
				//OKW_GetJavaClass myOKW_GetJavaClass = new OKW_GetJavaClass();
				myLogger.LogPrint( OKW_GetJavaClass.getClassPaths("okw.gui.frames").toString());
				
				//myLogger.LogPrint( OKW_GetJavaClass.getClasses( "okw.gui.frames").toString());
				
		EN.EndTest();
		
	}
}
