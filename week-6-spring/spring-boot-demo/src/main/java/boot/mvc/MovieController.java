package boot.mvc;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import boot.data.Movie;
import boot.data.MovieRepository;


/**
 * MovieController
 */
@RestController
@RequestMapping(path = "movies")
public class MovieController {
    @Autowired
    MovieRepository movieRepository;

    @GetMapping(value="/")
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    
    @GetMapping(value = "{year}")
    public Movie getByYear(@PathParam("year") Integer year) {
        return movieRepository.findByYear(year);
    }

    @GetMapping(value = "nineties")
    public List<Movie> getNineties() {
        return movieRepository.findByIdBetween(1, 10);
    }
    
    @PostMapping
    public Movie newMovie(Movie movie) {
        return movie;
    }
}