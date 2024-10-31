public class PrintedBook extends Title {
    private int pages;

    // Konstruktør
    public PrintedBook(String titleOfBook, String literatureType, int copies, int pages) {
        super(titleOfBook, literatureType, copies); // Kald superklassens constructor
        setPages(pages);
    }


    public void setPages(int pages) {
        if (pages < 0) {
            throw new IllegalArgumentException("Pages cannot be less than zero");
        }
        this.pages = pages;
    }

    @Override
    protected double calculatePoints() {
        return pages * calculateGenrePoints() * copies;
    }
}

