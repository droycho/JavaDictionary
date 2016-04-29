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

  @Test
  public void all_returnAllInstancesOfEntry_true() {
    Entry firstEntry = new Entry("Hard");
    Entry secondEntry = new Entry("Soft");
    assertTrue(Entry.all().contains(firstEntry));
    assertTrue(Entry.all().contains(secondEntry));
  }

  @Test
  public void clear_emptiesAllEntriesFromList_0() {
    Entry testEntry = new Entry("Hard");
    Entry.clear();
    assertEquals(Entry.all().size(), 0);
  }

  @Test
  public void getId_entriesInstantiateWithAnId_1() {
    Entry testEntry = new Entry("Hard");
    assertEquals(1, testEntry.getId());
  }

  @Test
  public void find_returnsEntryWithSameId_secondEntry() {
    Entry firstEntry = new Entry("Hard");
    Entry secondEntry = new Entry("Soft");
    assertEquals(Entry.find(secondEntry.getId()), secondEntry);
  }

  @Test
  public void find_returnsNullWhenNoEntryFound_null() {
    assertTrue(Entry.find(999) == null);
  }

  // run tests here.
}
