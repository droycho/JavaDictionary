import java.util.ArrayList;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.*;
import static org.junit.Assert.*;

public class AppTest extends FluentTest{

  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
   public WebDriver getDefaultDriver() {
   return webDriver;
   }

   @ClassRule
   public static ServerRule server = new ServerRule();
   @After
     public void tearDown() {
       Entry.clear();
       Definition.clear();
     }

   @Test
   public void rootTest() {
     goTo("http://localhost:4567/");
     assertThat(pageSource()).contains("Dictionary");
   }

   @Test
   public void entryIsCreatedTest() {
     goTo("http://localhost:4567/");
     click("a", withText("Add a New Word"));
     fill("#word").with("Hard");
     submit(".btn");
     assertThat(pageSource()).contains("Your word has been saved.");
   }

   @Test
   public void entryIsDisplayedTest() {
     goTo("http://localhost:4567/entries/new");
     fill("#word").with("Hard");
     submit(".btn");
     click("a", withText("View Words"));
     assertThat(pageSource()).contains("Hard");
   }

   @Test
   public void entryShowPageDisplaysWord() {
     goTo("http://localhost:4567/entries/new");
     fill("#word").with("Hard");
     submit(".btn");
     click("a", withText("View Words"));
     click("a", withText("Hard"));
     assertThat(pageSource()).contains("Hard");
   }

   @Test
   public void entryDefinitionsFormIsDisplayed() {
     goTo("http://localhost:4567/entries/new");
     fill("#word").with("Soft");
     submit(".btn");
     click("a", withText("View Words"));
     click("a", withText("Soft"));
     click("a", withText("Add a new definition"));
     assertThat(pageSource()).contains("Add a definition to Soft");
   }

   @Test
   public void definitionIsAddedAndDisplayed() {
     goTo("http://localhost:4567/entries/new");
     fill("#word").with("Clear");
     submit(".btn");
     click("a", withText("View Words"));
     click("a", withText("Clear"));
     click("a", withText("Add a new definition"));
     fill("#definition").with("adj. 1. easy to perceive, understand, or interpret.");
     submit(".btn");
     click("a", withText("View Words"));
     click("a", withText("Clear"));
     assertThat(pageSource()).contains("adj. 1. easy to perceive, understand, or interpret.");
   }
 }
