package com.tradeshift;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.util.ISO8601Utils;

@Service
public class MovieService {
    public List<MovieNameDTO> getMovies(String query){
        List<MovieNameDTO> list = new LinkedList<MovieNameDTO>();
        MovieNameDTO dto = new MovieNameDTO();
        dto.setId(UUID.randomUUID());
        dto.setName("abc");
        list.add(dto);
        return list;
    }

    public List<MovieLocationDTO> getMovieLocations(String query){
        List<MovieLocationDTO> list = new LinkedList<MovieLocationDTO>();
        MovieLocationDTO dto = new MovieLocationDTO();
        dto.setMovieName("TestName");
        dto.setLat("37.73268");
        dto.setLng("-122.411314");
        dto.setReleaseYear("2016");
        list.add(dto);
        return list;
    }

    public Object getJSON(Message msgIn){
        msgIn.setId(UUID.randomUUID());
        msgIn.setPostedAt(ISO8601Utils.format(Calendar.getInstance().getTime(), true, TimeZone.getTimeZone("UTC")));
        return msgIn;
    }
}
