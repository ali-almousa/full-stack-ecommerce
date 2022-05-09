import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VendingMachine {

    private List<Book> shelf;
    private double locationFactor;
    private double cassette;
    private double safe;
    private String password;
    private List<Double> acceptableCoins;

    public VendingMachine(double locationFactor, String password) {
        this.locationFactor = locationFactor;
        this.password = password;
        this.cassette = 0;
        this.safe = 0;
        this.shelf = new ArrayList<>();
        this.acceptableCoins = Arrays.asList(0.01, 0.02, 0.05, 0.1, 0.2, 0.5, 1.0, 2.0);
    }

    public double getCassette() {
        return cassette;
    }

    // tested
    public void insertCoin(double coin) throws IllegalArgumentException {
        // check the validity of the coins entered
        if (!this.acceptableCoins.contains(coin)) {
            throw new IllegalArgumentException();
        }

        // add to the cassette
        this.cassette += coin;
    }

    public double returnCoins() {
        double cassetteValue = this.getCassette();
        this.cassette = 0.0;
        return cassetteValue;
    }

    public void restock(List<Book> books, String password) {
        // the user is authenticated: add the list of books to the shelf
        authenticate(password);
        // add the shelf
        this.shelf.addAll(books);
    }

    public double emptySafe(String password) {
        // authenticate the user
        authenticate(password);
        // set the safe to zero and return the former value of the safe
        double safeValue = this.safe;
        this.safe = 0;
        return safeValue;
    }

    public List<String> getCatalogue() {
        List<String> descriptions = new ArrayList<>();

        for (Book book : this.shelf) {
            descriptions.add(book.toString());
        }

        return descriptions;
    }

    public double getPrice(int index) {
        // get the book from the shelf
        Book k = this.shelf.get(index);
        // calculate its price
        double price = k.getPages() * locationFactor;
        // return the price
        return price;
    }

    public Book buyBook(int index) {
        // check the validity of the index
        if (!(index >= 0 && index < shelf.size())) {
            throw new IndexOutOfBoundsException("There is no book on the shelf.");
        }
        // get the price of the book from the shelf at "index"
        double price = getPrice(index);
        // catch the book to buy
        Book k = this.shelf.get(index);
        // if cassette has enough money then proceed with the purchase
        if (price <= this.cassette) {
            this.shelf.remove(k);
            this.cassette -= price;
            this.safe += price;
            return k;
        }
        // if the money in cassette is not enough then throw runtime exception
        else
            throw new CassetteException("The cassette is not enough");
    }

    public void authenticate(String password) {
        if (!this.password.equals(password)) {
            throw new InvalidPasswordException("Invalid password!");
        }
    }

}
