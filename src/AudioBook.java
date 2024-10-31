public class AudioBook extends Title {
    private int durationMinutes;

    public AudioBook(int durationMinutes, String titleOfBook, String literatureType, int copies) {
        super(titleOfBook, literatureType, copies);
        setDurationInMinutes(durationMinutes);
    }

    // Setter for varighed i minutter
    public void setDurationInMinutes(int durationMinutes) {
        if (durationMinutes < 0) {
            throw new IllegalArgumentException("Duration in minutes cannot be less than zero");
        }
        this.durationMinutes = durationMinutes;
    }

    @Override
    protected double calculatePoints() {
        double pointsPerMinute = calculateGenrePointsPerMinute(getLiteratureType());
        return (durationMinutes * 0.5) * pointsPerMinute * copies;
    }

    // Beregner point pr. minut baseret på litteraturtype - for audiobooks
    private double calculateGenrePointsPerMinute(String literatureType) {
        switch (literatureType) {
            case "BI": // Billedbøger
            case "TE": // Tegneserier
                return 1.5;
            case "LYRIK": // Lyrik
                return 3.0;
            case "SKØN": // Skønlitteratur
                return 0.85;
            case "FAG": // FagBøger
                return 0.5;
            default:
                throw new IllegalArgumentException("Unsupported genre type: " + literatureType);
        }
    }
}
