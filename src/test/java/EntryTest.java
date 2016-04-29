import org.junit.*;
import static org.junit.Assert.*;

public class EntryTest {
  // @After
  // public void tearDown() {
  //   Entry.clear();
  // }

  @Test
  public void entry_instantiatesCorrectly_true() {
    Entry testEntry = new Entry("hard");
    assertEquals(true, testEntry instanceof Entry);
  }

  @Test
  public void getWord_entryInstantiatesWithWord_Hard(){
    Entry testEntry = new Entry("Hard");
    assertEquals("Hard", testEntry.getWord());
  }

  // run tests here.
}
