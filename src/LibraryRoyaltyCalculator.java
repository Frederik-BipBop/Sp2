public class LibraryRoyaltyCalculator {
    public static void main(String[] args) {

        Author author = new Author("Sussi Bech");

        author.addTitle(new PrintedBook("Skatteøen", "SKØN", 50, 200));
        author.addTitle(new PrintedBook("Mumiens Hemmelighed", "TE", 30, 120));
        author.addTitle(new PrintedBook("Eventyret om Den Blå Drage", "FAG", 40, 300));


        author.addTitle(new AudioBook(180, "Den Magiske Verden", "LYRIK", 20));
        author.addTitle(new AudioBook(90, "Robotternes Tid", "SKØN", 25));
        author.addTitle(new AudioBook(120, "Universets Hemmeligheder", "FAG", 15));
        // Beregner forfatterens samlede betaling
        float totalPay = author.calculateTotalPay();

        // Udskriver resultatet med forfatterens navn og den samlede betaling
        System.out.printf("%s: %.2f kr%n", author.getName(), totalPay);
    }
}
