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

  // run tests here.
}
