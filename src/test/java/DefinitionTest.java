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

  @Test
  public void all_returnsAllInstancesOfDefinition_true() {
    Definition firstDefinition = new Definition("Wash the dishes");
    Definition secondDefinition = new Definition("Buy groceries");
    assertTrue(Definition.all().contains(firstDefinition));
    assertTrue(Definition.all().contains(secondDefinition));
  }

  @Test
  public void newId_DefinitionsInstantiateWithAnID_true() {
    Definition testDefinition = new Definition("Wash the dishes");
    assertEquals(Definition.all().size(), testDefinition.getId());
  }

  @Test
  public void find_returnsDefinitionWithSameId_secondDefinition() {
    Definition firstDefinition = new Definition("To remove dirt");
    Definition secondDefinition = new Definition("To purchase goods");
    assertEquals(Definition.find(secondDefinition.getId()), secondDefinition);
  }

  @Test
  public void find_returnsNullWhenNoDefinitionFound_null() {
    assertTrue(Definition.find(999)== null);
  }

  @Test
  public void clear_emptiesAllDefinitionsFromArrayList() {
    Definition testDefinition = new Definition("Wash the dishes");
    Definition.clear();
    assertEquals(Definition.all().size(), 0);
  }

}
