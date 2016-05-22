package daniel.daniel_pset5;

/* Student name: Daniel Oliemans
 * Student number: 11188669
 * Universiteit van Amsterdam
 */

/*
 * Constructor for retrieving the right data
 */
public class Data {

    private String title;
    private String genre;

    // Constructor
    public Data(String title, String genre){
        super();
        this.title = title;
        this.genre = genre;
    }

    // Gets the title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Gets the genre
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
