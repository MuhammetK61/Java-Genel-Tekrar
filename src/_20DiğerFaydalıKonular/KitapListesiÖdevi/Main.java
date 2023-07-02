package _20DiğerFaydalıKonular.KitapListesiÖdevi;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //Burada kitap listesini oluşturdum.
        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Book0", 50, "Author0",2000));
        bookList.add(new Book("Book1", 60, "Author1",2001));
        bookList.add(new Book("Book2", 70, "Author2",2010));
        bookList.add(new Book("Book3", 100, "Author3",2012));
        bookList.add(new Book("Book4", 45, "Author4",2013));
        bookList.add(new Book("Book5", 300, "Author5",2014));
        bookList.add(new Book("Book6", 350, "Author6",2015));
        bookList.add(new Book("Book7", 400, "Author7",2016));
        bookList.add(new Book("Book8", 450, "Author8",2017));
        bookList.add(new Book("Book9", 500, "Author9",2020));

        //Burada Map kullanarak key - value işlemi ile kitap ve yazar eşleştirmesi yaptım
        Map<String, String> bookList2 = new TreeMap<>();
        bookList.stream().forEach(book -> bookList2.put(book.getName(), book.getAuthor()));

        //Burada ekrana yazdırıyorum
        System.out.println("--------Kitaplar ve Yazarları--------");
        for (String name : bookList2.keySet()){
            System.out.println(name + " - " + bookList2.get(name));
        }
        System.out.println();


        //Burada kitapların sayfa sayısı 100den fazla olanları ayrı bir liste olarak yazdırıyorum.
        System.out.println("--------Sayfa Sayısı 100den Büyük Olan Kitaplar--------");
        List<Book> filteredBooks = bookList.stream().filter(book -> book.getPageNumber()>100).collect(Collectors.toList());
        filteredBooks.stream().forEach(book -> System.out.println(
                "Author : " + book.getAuthor() +
                        "\nBook : " + book.getName()+
                        "\nPage Number : " + book.getPageNumber()+
                        "\nPublication Year : " + book.getPublicationYear()+
                        "\n----------------------"
        ));
    }
}
