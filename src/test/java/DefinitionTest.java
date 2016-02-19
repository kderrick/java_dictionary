import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class DefinitionTest {

  @Rule
  public ClearRule clearRule = new ClearRule();


  @Test
  public void newDefinition_instatiateCorrectly_true() {
    Definition testDefinition = new Definition("Wash the dishes");
    assertEquals(true, testDefinition instanceof Definition);
  }

  @Test
  public void newDefinition_displayADefinition() {
    Definition testDefinition = new Definition("To flail wildly");
    assertEquals("To flail wildly", testDefinition.getDescription());
  }

  @Test
  public void newDefinition_getIdOfDefinition() {
    Definition testDefinition = new Definition("To flail wildly");
    assertEquals(1, testDefinition.getId());
  }

}
