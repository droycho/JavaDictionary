import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void definition_instantiatesCorrectly_true() {
    Definition myDefinition = new Definition("hard");
    assertEquals(true, myDefinition instanceof Definition);
  }



}
