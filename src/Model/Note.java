package Model;

public class Note {

    private String title;
    private String category;
    private String content;

    public Note(String title, String category, String content) {
        this.title = title;
        this.category = category;
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void print() {
        System.out.println("------");
        System.out.println("Nosaukums: " + title);
        System.out.println("Kategorija: " + category);
        System.out.println("Saturs: " + content);
    }
}