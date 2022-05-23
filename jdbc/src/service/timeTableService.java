package service;

import model.TimeTable;

import java.util.List;

public interface timeTableService {
    void addTimeTable(TimeTable timeTable);

    List<TimeTable> getAllTimeTablesByMovieId(Integer movieId);
}
