package edu.du.sb20241120.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/data")
public class DataPointController {

    @Autowired
    private DataPointRepository dataPointRepository;

    @GetMapping
    public List<DataPoint> getAllDataPoints() {
        return dataPointRepository.findAll();
    }
}
