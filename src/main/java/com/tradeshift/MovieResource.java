package com.tradeshift;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("movie")
public class MovieResource {
    @Autowired
    private MovieService movieService;

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MovieNameDTO> getMovies(@QueryParam("q")String query){
        System.out.println("query: " + query);
        return movieService.getMovies(query);
    }

    @GET
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MovieLocationDTO> getMovieLocations(@QueryParam("mid")String movieId){
        System.out.println("query mid: " + movieId);
        return movieService.getMovieLocations(movieId);
    }
}
