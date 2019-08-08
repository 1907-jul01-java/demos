package boot.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * MovieRepository
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{
    List<Movie> findByTitle(String title);
    List<Movie> findByYearBetween(int min, int max);
}