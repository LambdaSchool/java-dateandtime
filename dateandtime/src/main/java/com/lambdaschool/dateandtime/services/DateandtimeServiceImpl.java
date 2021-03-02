package com.lambdaschool.dateandtime.services;

import com.lambdaschool.dateandtime.models.Dateandtime;
import com.lambdaschool.dateandtime.repositories.DateandtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service(value = "dateandtimeService")
public class DateandtimeServiceImpl implements DateandtimeService
{
    @Value("${spring.jackson.date-format}")
    private String dateFormat;

    @Autowired
    private DateandtimeRepository dtrepos;

    @Override
    public Dateandtime save(Dateandtime dateandtime)
    {
        Dateandtime newDateandtime = new Dateandtime();

        newDateandtime.setThedateonly(dateandtime.getThedateonly());
        newDateandtime.setThetimeonly(dateandtime.getThetimeonly());
        newDateandtime.setDateandtime(dateandtime.getDateandtime());

        return dtrepos.save(newDateandtime);
    }

    @Override
    public Dateandtime save(String dateandtimestr) throws Exception
    {
        Date dateandtime;
        try
        {
            SimpleDateFormat df = new SimpleDateFormat(dateFormat,
                Locale.US);
            dateandtime = df.parse(dateandtimestr);
        } catch (Exception e)
        {
            throw new Exception("Invalid Date format");
        }

        Dateandtime newDateandtime = new Dateandtime();

        newDateandtime.setThedateonly(dateandtime);
        newDateandtime.setThetimeonly(dateandtime);
        newDateandtime.setDateandtime(dateandtime);

        return dtrepos.save(newDateandtime);
    }

    @Override
    public List<Dateandtime> findByDate(String datestr) throws Exception
    {
        Date findDate;
        try
        {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd",
                Locale.US);
            findDate = df.parse(datestr);
        } catch (Exception e)
        {
            throw new Exception("Invalid Date format");
        }

        return dtrepos.findByThedateonly(findDate);
    }

    @Override
    public List<Dateandtime> findByTime(String datestr) throws Exception
    {
        Date findTime;
        try
        {
            System.out.println(datestr);
            SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss z",
                Locale.US);
            findTime = df.parse(datestr);
        } catch (Exception e)
        {
            throw new Exception("Invalid Date format");
        }

        return dtrepos.findByThetimeonly(findTime);
    }

    @Override
    public List<Dateandtime> findByDateAndTime(String datestr) throws Exception
    {
        Date findDateAndTime;
        try
        {
            SimpleDateFormat df = new SimpleDateFormat(dateFormat,
                Locale.US);
            findDateAndTime = df.parse(datestr);
        } catch (Exception e)
        {
            throw new Exception("Invalid Date format");
        }

        return dtrepos.findByDateandtime(findDateAndTime);
    }
}
