import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class WordTest {

  @Test
  public void getName_returnsName_true() {
    Word testWord = new Word("Home");
    assertEquals("Home", testWord.getName());
  }

  @Test
  public void getId_returnsWordId() {
    Word testWord = new Word("Home");
    assertTrue(Word.all().size() == testWord.getId());
  }

  @Test
  public void getDefinitions_initiallyReturnsEmtyArrayList() {
    Word testWord = new Word("Home");
    assertTrue(testWord.getDefinitions() instanceof ArrayList);
  }

  @Test
  public void all_returnsAllInstancesofWord_true() {
    Word firstWord = new Word("Home");
    Word secondWord = new Word("Cake");
    assertTrue(Word.all().contains(firstWord));
    assertTrue(Word.all().contains(secondWord));
  }

  @Test
  public void clear_removesAllWordInstancesFromMemory() {
    Word testWord = new Word("Home");
    Word.clear();
    assertEquals(Word.all().size(), 0);
  }

  @Test
  public void find_returnsWordWithSameId() {
    Word testWord = new Word("Home");
    assertEquals(Word.find(testWord.getId()), testWord);
  }

  @Test
  public void addDefinition_addsDefinitionToList() {
    Word testWord = new Word("Home");
    Definition testDefinition = new Definition("A place where one resides");
    testWord.addDefinition(testDefinition);
    assertTrue(testWord.getDefinitions().contains(testDefinition));
  }


}
