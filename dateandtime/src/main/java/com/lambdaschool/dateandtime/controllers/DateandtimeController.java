package com.lambdaschool.dateandtime.controllers;

import com.lambdaschool.dateandtime.services.DateandtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateandtimeController
{
    @Autowired
    DateandtimeService dateandtimeService;

    // localhost:2019/find/date/2021-03-02
    @GetMapping(value = "/find/date/{datestr}")
    public ResponseEntity<?> findDate(
        @PathVariable
            String datestr) throws Exception
    {
        return new ResponseEntity<>(dateandtimeService.findByDate(datestr),
            HttpStatus.OK);
    }

    // localhost:2019/find/time/7:00:00 PST
    @GetMapping(value = "/find/time/{datestr}")
    public ResponseEntity<?> findTime(
        @PathVariable
            String datestr) throws Exception
    {
        return new ResponseEntity<>(dateandtimeService.findByTime(datestr),
            HttpStatus.OK);
    }

    // localhost:2019/find/dateandtime/2019-01-03 07:00:00 PST
    @GetMapping(value = "/find/dateandtime/{datestr}")
    public ResponseEntity<?> findDateandTime(
        @PathVariable
            String datestr) throws Exception
    {
        return new ResponseEntity<>(dateandtimeService.findByDateAndTime(datestr),
            HttpStatus.OK);
    }

    // localhost:2019/save/dateandtime/2019-01-03 07:00:00 PST
    @PostMapping(value = "/save/dateandtime/{datestr}")
    public ResponseEntity<?> saveDateandTime(
        @PathVariable
            String datestr) throws Exception
    {
        dateandtimeService.save(datestr);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
