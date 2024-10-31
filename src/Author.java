import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Author {
    private String name;
    private ArrayList<Title> titles;

    public Author(String name) {
        this.name = name;
        titles = new ArrayList<Title>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new NullPointerException("name can't be null");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name can't be empty");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("name can't be blank");
        }
        if (name.length() < 2) {
            throw new IllegalArgumentException("name can't be less than 2 characters");
        }
        if (name.length() > 10000) {
            throw new IllegalArgumentException("name can't be longer than 10000 characters");
        }

        // Hvis alle betingelser er opfyldt, kan name blive tildelt til feltet
        this.name = name;
    }

    public ArrayList<Title> getTitles() {
        return titles;
    }

    public void addTitle(Title title) {
        if (title == null) {
            throw new NullPointerException("Title cannot be null");
        }
        this.titles.add(title);
    }

    public float calculateTotalPay() {
        float totalPay = 0;

        // Løber gennem alle titler for at beregne den samlede royalty
        for (Title t : titles) {
            totalPay += t.calculateRoyalty(); // Sørger for, at hver royalty beregnes korrekt
        }

        // Afrund totalPay til 2 decimaler for præcision ved hjælp af BigDecimal
        BigDecimal roundedPay = BigDecimal.valueOf(totalPay)
                .setScale(2, RoundingMode.HALF_UP);
        return roundedPay.floatValue(); // Returner det afrundede beløb som float
    }


}

