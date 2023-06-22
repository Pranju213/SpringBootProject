package com.springbootjunit.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import com.springbootjunit.entity.Movie;
import com.springbootjunit.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController
{
	
	@Autowired
	private MovieService movieService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Movie create(@RequestBody Movie movie) 
	{
		return movieService.save(movie);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Movie> read() {
		return movieService.getAllMovies();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Movie read(@PathVariable Long id) {
		return movieService.getMovieById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		movieService.deleteMovie(id);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/{id}")
	public Movie update(@PathVariable Long id, @RequestBody Movie movie) {
		return movieService.updateMovie(movie, id);
	}
}
