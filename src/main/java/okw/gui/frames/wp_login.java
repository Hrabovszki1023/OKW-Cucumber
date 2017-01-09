package okw.gui.frames;

import okw.OKW;
import okw.gui.OKWLocator;
import okw.gui.adapter.selenium.SeBrowserChild;
import okw.gui.adapter.selenium.SeInputButton;
import okw.gui.adapter.selenium.SeInputCheckbox;
import okw.gui.adapter.selenium.SeInputText;
import okw.gui.adapter.selenium.SeLink;

@OKW(FN="WP-Login")
public class wp_login extends SeBrowserChild
{

    @OKW (FN="Username")
    public SeInputText Username = new SeInputText("//*[@id='user_login']");
    
    @OKW (FN="Password")
    public SeInputText Password = new SeInputText("//*[@id='user_pass']");
    
    @OKW (FN="Remember Me")
    public SeInputCheckbox Remember_Me = new SeInputCheckbox("//*[@id='rememberme']");

	@OKW( FN = "Log In")
	public SeInputButton Log_In       = new SeInputButton( "//*[@id='wp-submit']" );

    @OKW( FN = "Lost your password")
    public SeLink LinkNotExists = new SeLink( "//p[@id='nav']/a" );

    @OKW( FN = "Back")
    public SeLink Back = new SeLink( "//p[@id='backoblog']/a" );
	
    public wp_login()
    {
    	super("//body/div[@id='login']/..");
    }
}
