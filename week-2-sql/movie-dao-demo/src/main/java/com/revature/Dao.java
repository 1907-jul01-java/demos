package com.revature;

import com.revature.movies.*;
import java.util.List;

/**
 * Dao
 */
public interface Dao {
    void insert(Movie movie);

    List<Movie> getAll();

    void update();

    void delete();
}