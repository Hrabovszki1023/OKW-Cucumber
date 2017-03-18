package okw.gui.wordpress.boxes.publish;

import java.util.ArrayList;

import okw.OKW;
import okw.core.EN;
import okw.gui.OKWLocator;
import okw.gui.adapter.selenium.*;

/**
 * This is the GUI-Container für the Complex Object _Format_.
 * 
 * ![Caption text](https://cloud.githubusercontent.com/assets/15831418/23447409/f120ffb2-fe4a-11e6-802c-c369ee2187c1.png)
 * 
 *  feauters:
 *  Select Publish Visibility
 *  
 *  Values: 
 *  Select("FN", "Public");
 *  Select("FN", "Password protected${SEP}Password");
 *  Select("FN", "Private");
 *  
 *  Implementation of zhis class: 30min
 *   
 * @author Zoltan Hrabovszki
 * 
 */
public class wp_publishVisibility extends SeAnyChildWindow
{

  public wp_publishVisibility( String Locator )
  {
      super( Locator );
  }
  
  public wp_publishVisibility( String Locator, OKWLocator... fpLocators )
  {
      super( Locator, fpLocators );
  }
  
  @OKW (FN="Publish Visibility Expand")
  public SeInputButton ExpandButton = new SeInputButton( "%1$s//button[@class='handlediv button-link' and @aria-expanded='false']", this.getLOCATOR() );

  @OKW (FN="Publish Visibility Edit")
  // XPATH ist so eingestellz dass Edit nur gefunden wird wenn auf der GUI sichtbar, sonst ist das XPATh ergebniss = empty
  public SeLink Publish_Edit = new SeLink( "%1$s//a[contains(., 'Edit') and ((string-length(@style)=0) or contains(@style,'display: inline'))]", this.getLOCATOR() );
  
  @OKW (FN="Publish Visibility RadioList")
  public myRadioList visibiltiRadioList= new myRadioList( "", "//div[@id='post-visibility-select']" );
  
  public class myRadioList extends SeRadioList
  {
  
  public myRadioList( String IframeID, String Locator, OKWLocator... Locators )
    {
      super( IframeID, Locator, Locators );
    }

  @OKW (FN="Publish Visibility RadioList.Public")
  public SeInputRadio myStandard = new SeInputRadio( "%1$s//input[@type='radio' and @value='public']", this.getLOCATOR() );

  @OKW (FN="Publish Visibility RadioList.Password protected")
  public SeInputRadio myAside = new SeInputRadio( "%1$s//input[@type='radio' and @value='password']", this.getLOCATOR() );

  @OKW (FN="Publish Visibility RadioList.Private")
  public SeInputRadio myImage = new SeInputRadio( "%1$s//input[@type='radio' and @value='private']", this.getLOCATOR() );
  }
  
  @OKW (FN="Publish Visibility Password")
  public SeInputText myPassword = new SeInputText("//span[(string-length(@style)=0) or contains(@style,'display: inline')]/input[@id='post_password']");
  
  
  @OKW (FN="Publish Visibility OK")
  public SeLink PublishStasusOK = new SeLink( "//a[@href='#visibility' and text()='OK']" );

  @Override
  public void Select( ArrayList<String> Val ) throws Exception
  {
    this.SetValue( Val );
  }
  
  
  @Override
  public void SetValue( ArrayList<String> Val ) throws Exception
  {
      // Is "Publish" expanded?
      if ( ExpandButton.getExists() )
      {
        // Attention Current Object 
        EN.ClickOn( "Publish Visibility Expand" );
      }

      // Is "Edit" Visible? Hint: The Locator detects "edit" only if the link is visble!
      if ( Publish_Edit.getExists() )
      {
        // Attention Current Object 
        EN.ClickOn( "Publish Visibility Edit" );
      }

      EN.Select( "Publish Visibility RadioList", Val.get( 0 ) );
      
      // if 
      if( Val.get( 0 ).equals( "Password protected" ))
      {
        EN.SetValue( "Publish Visibility Password", Val.get( 1 ) );
      }
      
      EN.ClickOn( "Publish Visibility OK" );
  }
  
};
