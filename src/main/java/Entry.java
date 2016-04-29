import java.util.ArrayList;

public class Entry{
  private String mWord;
  private static ArrayList<Entry> instances = new ArrayList<Entry>();
  private int mId;
  private ArrayList<Definition> mDefinitions;

  public Entry(String word) {
    mWord = word;
    instances.add(this);
    mId = instances.size();
    mDefinitions = new ArrayList<Definition>();
  }

  public String getWord() {
    return mWord;
  }

  public static ArrayList<Entry> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static Entry find(int id) {
    try {
      return instances.get(id -1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public ArrayList<Definition> getDefinitions() {
    return mDefinitions;
  }


}
