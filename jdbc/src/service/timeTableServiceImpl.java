package service;

import model.TimeTable;
import repository.TimeTableRepository;

import java.util.List;

public class timeTableServiceImpl implements timeTableService {
    TimeTableRepository timeTableRepository = new TimeTableRepository();

    @Override
    public void addTimeTable(TimeTable timeTable) {
        timeTableRepository.addTimetable(timeTable);
    }

    @Override
    public List<TimeTable> getAllTimeTablesByMovieId(Integer id) {
        return timeTableRepository.getAllTimeTablesByMovieId(id);
    }
}
