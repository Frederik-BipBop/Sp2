import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Title {
    private String title;
    private String literatureType;
    protected int copies;
    protected static final double RATE = 0.067574; // Statiske rate for biblioteksbøger

    // Konstruktør
    public Title(String title, String literatureType, int copies) {
        setTitle(title);
        setLiteratureType(literatureType);
        setCopies(copies);
    }

    // Setter for title
    public void setTitle(String title) {
        if (title == null) {
            throw new NullPointerException("Title cannot be null");
        }
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be blank");
        }
        if (title.length() > 10000) {
            throw new IllegalArgumentException("Title cannot be greater than 10000 characters");
        }
        this.title = title;
    }

    // Getter for literatureType
    public String getLiteratureType() {
        return this.literatureType;
    }

    // Setter for literatureType
    public void setLiteratureType(String literatureType) {
        if (literatureType == null) {
            throw new IllegalArgumentException("Literature type cannot be null");
        }
        literatureType = literatureType.trim().toUpperCase(); // Trim mellemrum og brug uppercase
        switch (literatureType) {
            case "BI": // Billedbøger
            case "TE": // Tegneserier
            case "LYRIK": // Lyrik
            case "SKØN": // Skønlitteratur
            case "FAG": // Fagbøger
                this.literatureType = literatureType;
                break;
            default:
                throw new IllegalArgumentException("Unsupported literature type: " + literatureType);
        }
    }

    // Setter for copies
    public void setCopies(int copies) {
        if (copies < 0) {
            throw new IllegalArgumentException("Copies cannot be negative");
        }
        this.copies = copies;
    }

    // Statisk metode til at returnere raten
    public static double getRate() {
        return RATE;
    }


    protected abstract double calculatePoints();

    // Beregn royalty ved hjælp af calculatePoints() og RATE
    public double calculateRoyalty() {
        double points = calculatePoints();
        return points * RATE;
    }

    // Beregn point baseret på literatureType (genre)
    protected double calculateGenrePoints() {
        switch (literatureType) {
            case "BI":
            case "TE":
                return 3.0;
            case "LYRIK":
                return 6.0;
            case "SKØN":
                return 1.7;
            case "FAG":
                return 1.0;
            default:
                throw new IllegalArgumentException("Unsupported literature type: " + literatureType);
        }
    }
}
