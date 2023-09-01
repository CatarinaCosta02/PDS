package ex3;
public class Main {
    public static void main(String[] args) {
    //print out the movie
        Movie movie = new Movie.Builder("The Godfather", 1972)
                .director(new Person("Francis Ford Coppola"))
                .writer(new Person("Mario Puzo"))
                .series("The Godfather")
                .addCast(new Person("Marlon Brando"))
                .addCast(new Person("Al Pacino"))
                .addCast(new Person("James Caan"))
                .addCast(new Person("Robert Duvall"))
                .addCast(new Person("Diane Keaton"))
                .addLocation(new Place("Alta Vista"))
                .addLocation(new Place("Beverly Hills"))
                .addLanguage("English")
                .addGenre("Drama")
                .addGenre("Crime")
                .isTelevesion(false)
                .isNetflix(false)
                .isIndependent(false)
                .build();
        System.out.println(movie);
    }
}