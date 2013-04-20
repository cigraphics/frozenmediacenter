package net.frozenlogic.mediacenter.impl.plugins;


import java.util.List;

public class MoviesList {
    private List<String> movieNames;

    public MoviesList(List<String> movieNames) {
        this.movieNames = movieNames;
    }

    public List<String> getMovieNames() {
        return movieNames;
    }
}
