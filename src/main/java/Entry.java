import java.util.ArrayList;

public class Entry{
  private String mWord;
  private static ArrayList<Entry> instances = new ArrayList<Entry>();
  // private int mId;

  public Entry(String word) {
    mWord = word;
    instances.add(this);
  }

  public String getWord() {
    return mWord;
  }

  public static ArrayList<Entry> all() {
    return instances;
  }


}
