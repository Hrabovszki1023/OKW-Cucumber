package okw.gui.frames.wordpress;

import java.util.ArrayList;

import okw.OKW;
import okw.OKW_Helper;
import okw.core.EN;
import okw.gui.adapter.selenium.*;

@OKW(FN="WP Login")
public class wp_login extends SeBrowserChild
{

    @OKW (FN="Username")
    public SeInputText Username = new SeInputText("%1$s//*[@id='user_login']", this.getLOCATOR() );
    
    @OKW (FN="Password")
    public SeInputText Password = new SeInputText("%1$s//*[@id='user_pass']", this.getLOCATOR() );
    
    @OKW (FN="Remember Me")
    public SeInputCheckbox Remember_Me = new SeInputCheckbox("%1$s//*[@id='rememberme']", this.getLOCATOR() );;

	  @OKW( FN = "Log In")
	  public SeInputButton Log_In = new SeInputButton( "%1$s//*[@id='wp-submit']", this.getLOCATOR() );;

    @OKW( FN = "Lost your password")
    public SeLink LostPasswd = new SeLink( "%1$s//p[@id='nav']/a", this.getLOCATOR() );

    @OKW( FN = "Back")
    public SeLink Back = new SeLink( "%1$s//p[@id='backoblog']/a", this.getLOCATOR() );
	
    @OKW( FN = "Login Error")
    public SeAnyWindow LogError = new SeAnyWindow( "%1$s//div[@id='login_error']", this.getLOCATOR() );

    
    public void Login( String SEQID ) throws Exception
    {
       ArrayList<String> myParams = OKW_Helper.StrSplit( SEQID, "/" );
       
       EN.SelectWindow( this.getFN() );
       EN.SetValue( "Username", myParams.get( 0 ) );
       EN.SetValue( "Password", myParams.get( 1 ) );
       EN.ClickOn( "Log In" );

       EN.VerifyExists( "Login Error", "NO" );
    }
    
    public wp_login()
    {
    	super("//body/div[@id='login']/..");
        
    	// Concat Child and Window Locators...
    	/* Username    = new SeInputText("%1$s//*[@id='user_login']", this.getLOCATOR() );
    	Password    = new SeInputText("%1$s//*[@id='user_pass']", this.getLOCATOR() );
        Remember_Me = new SeInputCheckbox("%1$s//*[@id='rememberme']", this.getLOCATOR() );

    	Log_In      = new SeInputButton( "%1$s//*[@id='wp-submit']", this.getLOCATOR() );
    	LostPasswd  = new SeLink( "%1$s//p[@id='nav']/a", this.getLOCATOR() );
        Back        = new SeLink( "%1$s//p[@id='backoblog']/a", this.getLOCATOR() );
        */
    }
}
