package okw.gui.frames;

import okw.OKW;
import okw.gui.container.wp_basewindow;
import okw.gui.container.wp_format;
import okw.gui.adapter.selenium.SeInputText;
import okw.gui.adapter.selenium.SeInputButton;


@OKW(FN="WP Dashboard")
public class wp_Dashboard extends wp_basewindow
{

  @OKW (FN="Title")
  public SeInputText Username = new SeInputText("%1$s//*[@id='title']", this.getLOCATOR() );
  
  public wp_Dashboard()
  {
    super("//body//h1[text()='Dashboard']/../../../../../..");
  }

}