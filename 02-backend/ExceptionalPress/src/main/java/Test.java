import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Book book1 = new Book("Treasure Island", "Robert Louis Stevenson", "df", 1);
        Book book2 = new Book("gardwn", "Stevenson", "edfehw  hdkjedfehw ", 1);
//
//        System.out.println(book.getPages());
//        System.out.println(book);

        VendingMachine vendingMachine = new VendingMachine(0.2, "123");
//
//        System.out.println(vendingMachine.getCassette());
//        vendingMachine.insertCoin(0.5);
//        vendingMachine.insertCoin(0.1);
//        System.out.println(vendingMachine.returnCoins()); // 0.6
//        System.out.println(vendingMachine.getCassette()); // 0

        List<Book> books = Arrays.asList(book1, book2);
        vendingMachine.restock(books, "123");

        System.out.println(vendingMachine.getCatalogue());
        System.out.println(book2.getPages());
        System.out.println(vendingMachine.getPrice(1));



    }


}
