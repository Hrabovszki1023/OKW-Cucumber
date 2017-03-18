package okw.gui.wordpress.boxes.publish;

import java.util.ArrayList;

import okw.OKW;
import okw.core.EN;
import okw.gui.OKWLocator;
import okw.gui.adapter.selenium.*;

public class wp_publishDate extends SeAnyChildWindow
{

  @OKW (FN="Publish Date Expand")
  public SeInputButton ExpandButton = new SeInputButton( "%1$s//button[@class='handlediv button-link' and @aria-expanded='false']", this.getLOCATOR() );
  
  @OKW (FN="Publish Date Edit")
  public SeLink Publish_Edit = new SeLink( "%1$s//a[contains(., 'Edit') and ((string-length(@style)=0) or contains(@style,'display: inline'))]", this.getLOCATOR() );
  
  @OKW (FN="Publish Date OK")
  public SeLink PublishStasusOK = new SeLink( "%1$s//a[@href='#edit_timestamp' and text()='OK']", this.getLOCATOR() );
  
  //public Month
  @OKW (FN="Publish Date Month")
  public SeSelect Month  = new SeSelect( "%1$s//select[@id='mm']", this.getLOCATOR() );
  
  @OKW (FN="Publish Date Day")
  public SeInputText Day = new SeInputText( "%1$s//input[@id='jj']", this.getLOCATOR() ); 
  
  @OKW (FN="Publish Date Year")
  public SeInputText Year = new SeInputText( "%1$s//input[@id='aa']", this.getLOCATOR() );
  
  @OKW (FN="Publish Date Hours")
  public SeInputText hours = new SeInputText( "%1$s//input[@id='hh']", this.getLOCATOR() );
  
  @OKW (FN="Publish Date Minutes")
  public SeInputText Minutes  = new SeInputText( "%1$s//input[@id='mn']", this.getLOCATOR() );  
  
  
  @Override
  // Input Format "03-Mar 13,2017@12:00" -> Separtors " " (blank) "," "@" ":"
  public void SetValue( ArrayList<String> Val ) throws Exception
  {
    
      ArrayList<String> myValues;
      
      // Is "Publish" expanded?
      if ( ExpandButton.getExists() )
      {
        // Attention Current Object 
        EN.ClickOn( "Publish Date Expand" );
      }

      // Is "Edit" Visible? Hint: The Locator detects "edit "only if the Link Edit is visble!
      if ( Publish_Edit.getExists() )
      {
        // Attention Current Object 
        EN.ClickOn( "Publish Date Edit" );
      }
      else
      {
        this.MyLogger.LogPrint( "Locator:" + this.Publish_Edit.getLocator() );
      }
      
      // Input Format "03-Mar 13,2017@12:00" -> Separtors " " (blank) "," "@" ":"
      // Month
      myValues = okw.OKW_Helper.StrSplit( Val.get( 0 ), " " );
      EN.Select( "Publish Date Month", myValues.get( 0 ) );

      //Day
      myValues = okw.OKW_Helper.StrSplit( myValues.get( 1 ), "," );      
      EN.SetValue( "Publish Date Day", myValues.get( 0 ) );
      
      //year
      myValues = okw.OKW_Helper.StrSplit( myValues.get( 1 ), "@" );      
      EN.SetValue( "Publish Date Year", myValues.get( 0 ) );

      //hour
      myValues = okw.OKW_Helper.StrSplit( myValues.get( 1 ), ":" );      
      EN.SetValue( "Publish Date Hours", myValues.get( 0 ) );

      //hour
      EN.SetValue( "Publish Date Minutes", myValues.get( 1 ) );

      EN.ClickOn( "Publish Date OK" );
  }

  
  public wp_publishDate( String Locator, OKWLocator... fpLocators )
  {
    super( Locator, fpLocators );
    // TODO Auto-generated constructor stub
  }

}
