package okw.gui.wordpress.boxes.format;

import java.util.ArrayList;

import okw.OKW;
import okw.core.EN;
import okw.gui.OKWLocator;
import okw.gui.adapter.selenium.SeInputButton;
import okw.gui.adapter.selenium.SeInputRadio;
import okw.gui.adapter.selenium.SeRadioList;

/**
 * This is the GUI-Container für the Complex Object _Format_.
 * 
 * ![Caption text](https://cloud.githubusercontent.com/assets/15831418/23447409/f120ffb2-fe4a-11e6-802c-c369ee2187c1.png)
 * 
 *  feauters:
 *  Select format from  
 *   
 * @author Zoltan Hrabovszki
 *
 */
public class wp_format extends SeRadioList
{

  public wp_format( String Locator )
  {
      super( Locator );
  }
  
  public wp_format( String Locator, OKWLocator... fpLocators )
  {
      super( Locator, fpLocators );
  }
  
  @OKW (FN="Format Expand")
  public SeInputButton ExpandButton = new SeInputButton( "%1$s//button[@class='handlediv button-link' and @aria-expanded='false']", this.getLOCATOR() );

  @OKW (FN="Format.Standard")
  public SeInputRadio myStandard = new SeInputRadio( "%1$s//input[@type='radio' and @value='0']", this.getLOCATOR() );

  @OKW (FN="Format.Aside")
  public SeInputRadio myAside = new SeInputRadio( "%1$s//input[@type='radio' and @value='aside']", this.getLOCATOR() );

  @OKW (FN="Format.Image")
  public SeInputRadio myImage = new SeInputRadio( "%1$s//input[@type='radio' and @value='image']", this.getLOCATOR() );

  @OKW (FN="Format.Video")
  public SeInputRadio myVideo = new SeInputRadio( "%1$s//input[@type='radio' and @value='video']", this.getLOCATOR() );

  @OKW (FN="Format.Quote")
  public SeInputRadio myQuote = new SeInputRadio( "%1$s//input[@type='radio' and @value='quote']", this.getLOCATOR() );

  @OKW (FN="Format.Link")
  public SeInputRadio myLink = new SeInputRadio( "%1$s//input[@type='radio' and @value='link']", this.getLOCATOR() );

  @OKW (FN="Format.Gallery")
  public SeInputRadio myGallery = new SeInputRadio( "%1$s//input[@type='radio' and @value='gallery']", this.getLOCATOR() );

  @OKW (FN="Format.Status")
  public SeInputRadio myStatus = new SeInputRadio( "%1$s//input[@type='radio' and @value='status']", this.getLOCATOR() );

  @OKW (FN="Format.Audio")
  public SeInputRadio myAudio = new SeInputRadio( "%1$s//input[@type='radio' and @value='audio']", this.getLOCATOR() );

  @OKW (FN="Format.Chat")
  public SeInputRadio myChat = new SeInputRadio( "%1$s//input[@type='radio' and @value='chat']", this.getLOCATOR() );
  

  @Override
  public void SetValue( ArrayList<String> Val ) throws Exception
  {
      // Is "Format" expanded?
      if ( ExpandButton.getExists() )
      {
        // Attention Current Object 
        EN.ClickOn( "Format Expand" );

        // Reset Current Object
        okw.core.OKW_CurrentObject_Sngltn.getInstance().SetChildName( this.getFN() );
      }
            
      super.SetValue( Val );
  }
  
};
