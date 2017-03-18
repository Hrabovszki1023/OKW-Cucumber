package okw.gui.wordpress.boxes.publish;

import java.util.ArrayList;

import okw.OKW;
import okw.core.EN;
import okw.gui.OKWLocator;
import okw.gui.adapter.selenium.*;

public class wp_publishStatus extends SeAnyChildWindow
{
  @OKW (FN="Publish Status Expand")
  public SeInputButton ExpandButton = new SeInputButton( "%1$s//button[@class='handlediv button-link' and @aria-expanded='false']", this.getLOCATOR() );

  @OKW (FN="Publish Status Edit")
  public SeLink Publish_Edit = new SeLink( "%1$s//a[contains(., 'Edit') and ((string-length(@style)=0) or contains(@style,'display: inline'))]", this.getLOCATOR() );
      
  @OKW (FN="Publish Status Listbox")
  public SeSelect Listbox = new SeSelect( "%1$s//*[@id='post_status']", this.getLOCATOR() );

  @OKW (FN="Publish Status OK")
  public SeLink PublishStasusOK = new SeLink( "%1$s//a[@href='#post_status' and text()='OK']", this.getLOCATOR() );

  
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
        EN.ClickOn( "Publish Status Expand" );
      }

      // Is "Edit" Visible? Hint: The Locator detects "edit "only if the Link Edit is visble!
      if ( Publish_Edit.getExists() )
      {
        // Attention Current Object 
        EN.ClickOn( "Publish Status Edit" );
      }
      else
      {
        this.MyLogger.LogPrint( "Locator:" + this.Publish_Edit.getLocator() );
      }
      
      // Yes, it is Silly but we hav to conwert to separeted string...
      EN.Select( "Publish Status Listbox", okw.OKW_Const_Sngltn.getInstance().ConcatSEP(Val) );
      
      EN.ClickOn( "Publish Status OK" );
  }
  
  public wp_publishStatus( String Locator, OKWLocator... fpLocators )
  {
    super( Locator, fpLocators );
    // TODO Auto-generated constructor stub
  }

}
