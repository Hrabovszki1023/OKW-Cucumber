package okw.gui.container;

import okw.OKW;
import okw.gui.AnyWinBase;
import okw.gui.OKWLocator;
import okw.gui.adapter.selenium.*;


// Erfassung ca 1 Std.
// Die Gründe
// 1. keine eindeutige ID in den Menü-Links - Testbarkeit
// 2. einer der Menü Name ist nicht eindeutig s. "Add New"
// 3. href ist nicht eindeutig Beispiel href='edit.php' kommt in zwei Menü-Einträgen vor
// Musste ein Weg gesucht werden die Erkennung eindeutig zu machen.
// Lösung: Zwei Typen von Objekten:
//  * Ober-Menü´s wie Dashboard, Post usw "//a[@href='?????.php']//div[@class='wp-menu-name']/.."
//  * Sub-Menü´s wie All Posts, Add New usw "//ul[contains(@class, 'wp-submenu')]//a[@href='????.php']""
// Capturen ist hier nicht möglich
// ZH
public class wp_admin_menu extends SeAnyWin
{
  public wp_admin_menu( String Locator, OKWLocator okwLocator )
  {
    super( Locator, okwLocator );
  }

  //-------------------------------
  // Dashboard
  //
  @OKW (FN="Dashboard")
  public SeLink Dashboard = new SeLink("//a[@href='index.php']//div[@class='wp-menu-name']/..");
  
  //-------------------------------
  // Posts
  //
  @OKW (FN="Posts")
  public SeLink Posts = new SeLink("//a[@href='edit.php']//div[@class='wp-menu-name']/..");
  
  @OKW (FN="All Posts")
  public SeLink AllPosts = new SeLink("//ul[contains(@class, 'wp-submenu')]//a[@href='edit.php']");

  @OKW (FN="Add New Posts")
  public SeLink AddNewPosts = new SeLink("//ul[contains(@class, 'wp-submenu')]//a[@href='post-new.php']");
  
  
  //-------------------------------
  // Media
  //
  @OKW (FN="Media")
  public SeLink Media = new SeLink("//a[@href='upload.php']//div[@class='wp-menu-name']/..");

  @OKW (FN="Library")
  public SeLink Library = new SeLink("//ul[contains(@class, 'wp-submenu')]//a[@href='upload.php']");
  
  @OKW (FN="Add New Media")
  public SeLink AddNewMedia = new SeLink("//ul[contains(@class, 'wp-submenu')]//a[@href='media-new.php']");

  
  //-------------------------------
  // Comments
  //
  @OKW (FN="Comments")
  public SeLink Comments = new SeLink("//a[@href='edit-comments.php']//div[@class='wp-menu-name']/..");

  
  //-------------------------------
  // Profile
  //
  @OKW (FN="Profile")
  public SeLink Profile = new SeLink("//a[@href='profile.php']//div[@class='wp-menu-name']/..");

  
  //-------------------------------
  // Tools
  //
  @OKW (FN="Tools")
  public SeLink Tools = new SeLink("//a[@href='tools.php']//div[@class='wp-menu-name']/..");
  
}
