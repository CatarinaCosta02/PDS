package ex3;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private final String title;
    private final int year;
    private final Person director;
    private final Person writer;
    private final String series;
    private final List<Person> cast;
    private final List<Place> locations;
    private final List<String> languages;
    private final List<String> genres;
    private final boolean isTelevesion;
    private final boolean isNetflix;
    private final boolean isIndependent;

    private Movie(Builder builder) {
        this.title = builder.title;
        this.year = builder.year;
        this.director = builder.director;
        this.writer = builder.writer;
        this.series = builder.series;
        this.cast = builder.cast;
        this.locations = builder.locations;
        this.languages = builder.languages;
        this.genres = builder.genres;
        this.isTelevesion = builder.isTelevesion;
        this.isNetflix = builder.isNetflix;
        this.isIndependent = builder.isIndependent;
    }

    public static class Builder {
        private final String title;
        private final int year;
        private Person director;
        private Person writer;
        private String series;
        private List<Person> cast = new ArrayList<>();
        private List<Place> locations = new ArrayList<>();
        private List<String> languages = new ArrayList<>();
        private List<String> genres = new ArrayList<>();
        private boolean isTelevesion;
        private boolean isNetflix;
        private boolean isIndependent;

        public Builder(String title, int year) {
            this.title = title;
            this.year = year;
        }

        public Builder director(Person director) {
            this.director = director;
            return this;
        }

        public Builder writer(Person writer) {
            this.writer = writer;
            return this;
        }

        public Builder series(String series) {
            this.series = series;
            return this;
        }

        public Builder addCast(Person person) {
            this.cast.add(person);
            return this;
        }

        public Builder addLocation(Place place) {
            this.locations.add(place);
            return this;
        }

        public Builder addLanguage(String language) {
            this.languages.add(language);
            return this;
        }

        public Builder addGenre(String genre) {
            this.genres.add(genre);
            return this;
        }

        public Builder isTelevesion(boolean isTelevesion) {
            this.isTelevesion = isTelevesion;
            return this;
        }

        public Builder isNetflix(boolean isNetflix) {
            this.isNetflix = isNetflix;
            return this;
        }

        public Builder isIndependent(boolean isIndependent) {
            this.isIndependent = isIndependent;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }
    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", director=" + director +
                ", writer=" + writer +
                ", series='" + series + '\'' +
                ", cast=" + cast +
                ", locations=" + locations +
                ", languages=" + languages +
                ", genres=" + genres +
                ", isTelevesion=" + isTelevesion +
                ", isNetflix=" + isNetflix +
                ", isIndependent=" + isIndependent +
                '}';
    }
}
