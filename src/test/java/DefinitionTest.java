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
    Definition myDefinition = new Definition("adj. 1. Solid, firm, and resistant to pressure; not easily broken, bent, or pierced.");
    assertEquals("adj. 1. Solid, firm, and resistant to pressure; not easily broken, bent, or pierced.", myDefinition.getMeaning());
  }



}
