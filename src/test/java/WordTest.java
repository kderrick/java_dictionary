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


}
