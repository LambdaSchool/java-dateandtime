package com.lambdaschool.dateandtime.services;

import com.lambdaschool.dateandtime.models.Dateandtime;

import java.util.List;

public interface DateandtimeService
{
    Dateandtime save(Dateandtime dateandtime);

    Dateandtime save(String dateandtimestr) throws Exception;

    List<Dateandtime> findByDate(String datestr) throws Exception;

    List<Dateandtime> findByTime(String datestr) throws Exception;

    List<Dateandtime> findByDateAndTime(String datestr) throws Exception;
}
