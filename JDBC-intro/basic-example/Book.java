public class Book {
  private String title;
  private int pages;

  public Book(String title, int pages) {
    this.title = title;
    this.pages = pages;
  }

  public String title() {
    return title;
  }

  public int pages() {
    return pages;
  }

  @Override
  public String toString() {
    return title + " (" + pages + " pages)";
  }
}
