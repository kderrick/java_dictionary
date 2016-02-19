import org.fluentlenium.adapter.FluentTest;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.*;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }



  @ClassRule
  public static ServerRule server = new ServerRule();

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Dictionary");
  }

  @Test
  public void wordIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Word"));
    fill("#name").with("Kitten");
    submit(".btn");
    assertThat(pageSource()).contains("Your word has been saved.");
  }

  @Test
  public void wordIsDisplayedTest() {
    goTo("http://localhost:4567/words/new");
    fill("#name").with("Kitten");
    submit(".btn");
    click("a", withText("View words"));
    assertThat(pageSource()).contains("Kitten");
  }

  @Test
  public void wordDefinitionsFormIsDisplayed() {
    goTo("http://localhost:4567/words/new");
    fill("#name").with("Kitten");
    submit(".btn");
    click("a", withText("View words"));
    click("a", withText("Kitten"));
    click("a", withText("Add a new definition"));
    assertThat(pageSource()).contains("Add a new Definition to Kitten");
  }

  @Test
  public void definitionsIsAddedAndDisplayed() {
    goTo("http://localhost:4567/words/new");
    fill("#name").with("Kitten");
    submit(".btn");
    click("a", withText("View words"));
    click("a", withText("Kitten"));
    click("a", withText("Add a new definition"));
    fill("#description").with("A young feline");
    submit(".btn");
    assertThat(pageSource()).contains("A young feline");
  }

}
