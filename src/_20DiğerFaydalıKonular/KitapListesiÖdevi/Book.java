package _20DiğerFaydalıKonular.KitapListesiÖdevi;

public class Book {
    private String name;
    private int pageNumber;
    private String author;
    private int publicationYear;

    public Book(String name, int pageNumber, String author, int publicationYear) {
        this.name = name;
        this.pageNumber = pageNumber;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
}
