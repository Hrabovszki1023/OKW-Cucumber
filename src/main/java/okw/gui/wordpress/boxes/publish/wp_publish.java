package okw.gui.wordpress.boxes.publish;

import okw.OKW;
import okw.gui.OKWLocator;
import okw.gui.adapter.selenium.SeAnyChildWindow;

public class wp_publish extends SeAnyChildWindow
{
  
  @OKW (FN="Publish Status")
  public wp_publishStatus mypublishStatus = new wp_publishStatus("%1$s//div[contains(text(), 'Status')]", this.getLOCATOR() );
  
  @OKW (FN="Publish Visibility")
  /** Input Format:
   *        "Private${SEP}Password"
   *        "Public"
  **/
  public wp_publishVisibility mypublishVisibility = new wp_publishVisibility("%1$s//div[contains(text(), 'Visibility')]", this.getLOCATOR());

  @OKW (FN="Publish Date")
  // Input Format: "03-Mar 20,2017@20:15" 
  public wp_publishDate mypublishDate = new wp_publishDate("%1$s//div/span[contains(text(), 'Publish')]/..", this.getLOCATOR() );
  
  public wp_publish( String Locator, OKWLocator... Locators )
  {
    super( Locator, Locators );
    // TODO Auto-generated constructor stub
  }

}
