import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void Definition_instantiatesCorrectly_true() {
    Definition myDefinition = new Definition("hard");
    assertEquals(true, myDefinition instanceof Definition);
  }

  @Test
  public void Definition_instantiatesWithMeaning_String() {
    Definition myDefinition = new Definition("adj. 1. solid, firm, and resistant to pressure; not easily broken, bent, or pierced.");
    assertEquals("adj. 1. solid, firm, and resistant to pressure; not easily broken, bent, or pierced.", myDefinition.getMeaning());
  }

  @Test
  public void all_returnsAllInstancesOFDefinition_true() {
    Definition firstDefinition = new Definition("adj. 1. solid, firm, and resistant to pressure; not easily broken, bent, or pierced.");
    Definition secondDefinition = new Definition("adj. 2. requiring a great deal of endurance or effort.");
    assertTrue(Definition.all().contains(firstDefinition));
    assertTrue(Definition.all().contains(secondDefinition));
  }

  @Test
  public void clear_emptiesAllDefinitionsFromArrayList_0() {
    Definition myDefinition = new Definition("adj. 1. solid, firm, and resistant to pressure; not easily broken, bent, or pierced.");
    Definition.clear();
    assertEquals(Definition.all().size(), 0);
  }

  @Test
  public void getId_definitionsInstatiatesWithAnId_1() {
    Definition.clear();
    Definition myDefinition = new Definition("adj. 1. solid, firm, and resistant to pressure; not easily broken, bent, or pierced.");
    assertEquals(1, myDefinition.getId());
  }



}
