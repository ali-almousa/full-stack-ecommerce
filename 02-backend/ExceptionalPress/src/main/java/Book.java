public class Book {

    private String title;
    private String author;
    private String content;
    private int edition;

    public Book(String title, String author, String content, int edition) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.edition = edition;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public int getEdition() {
        return edition;
    }

    public int getPages() {
        // return the number of pages

        // divide the whole content's characters by 700
        return (int)Math.ceil((double) this.content.length() / 700);
    }

    @Override
    public String toString() {
        return
                "Title: " + title + '\n' +
                        "Author: " + author + '\n' +
                        "Edition: " + edition + "\n";
    }
}
