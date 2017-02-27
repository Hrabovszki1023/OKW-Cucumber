

import org.junit.*;
import org.junit.rules.TestName;

import okw.core.EN;
import okw.log.Logger_Sngltn;
import okw.log.log2html.Log2HTML;

public class wp_LoginTest {

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
  public void FirefoxAfter() throws Exception
  {
    Runtime rt = Runtime.getRuntime();
    
    if (System.getProperty("os.name").toLowerCase().indexOf("windows") > -1)
    {
       rt.exec("taskkill firefox");
    }
    else
    {
       rt.exec("pkill -f firefox");
    }
    
    Thread.sleep( 1000 );
  }


	@Test
	public void tcWP_LoginError() throws Exception {
		EN.BeginTest(tcname.getMethodName());
		
		EN.StartApp("Firefox");
		EN.SetValue("URL", "http://wordpress.openkeyword.de/wp-login.php");
		
		EN.SelectWindow("WP Login");
		EN.SetValue("Username", "Zoltan");
		EN.SetValue("Password", "Uschi");
		EN.ClickOn("Log In");
		
		EN.VerifyExists("Login Error", "YES");
		
		EN.StopApp("Firefox");
		EN.EndTest();
	}

	
	 @Test
	  public void tcWP_AddNewPost() throws Exception {
	    EN.BeginTest(tcname.getMethodName());
	    
	    EN.StartApp("Firefox");
	    EN.SetValue("URL", "http://wordpress.openkeyword.de/wp-login.php");
	    
	    EN.SelectWindow("WP Login");
	    EN.SetValue("Username", "Zoltan");
	    EN.SetValue("Password", "${Password}");
	    EN.ClickOn("Log In");
	    
	    EN.VerifyExists("Login Error", "NO");
	    
      EN.SelectWindow("WP Dashboard");
	    EN.ClickOn( "Posts" );
      EN.ClickOn( "Add New Posts" );
      
      EN.SelectWindow("WP Add New Post");
      EN.SetValue( "Title", "My First Post" );
      EN.TypeKey( "Content Editor", "${TCN}" );
	    
      EN.StopApp("Firefox");
	    EN.EndTest();
	  }

}
