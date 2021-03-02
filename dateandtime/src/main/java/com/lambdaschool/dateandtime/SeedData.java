package com.lambdaschool.dateandtime;

import com.lambdaschool.dateandtime.models.Dateandtime;
import com.lambdaschool.dateandtime.services.DateandtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Transactional
@ConditionalOnProperty(
    prefix = "command.line.runner",
    value = "enabled",
    havingValue = "true",
    matchIfMissing = true)
@Component
public class SeedData
    implements CommandLineRunner
{
    @Value("${spring.jackson.date-format}")
    private String dateFormat;

    @Autowired
    private DateandtimeService dateandtimeService;

    @Transactional
    @Override
    public void run(String[] args) throws Exception
    {
        SimpleDateFormat df = new SimpleDateFormat(dateFormat,
            Locale.US);

        String s1 = "2019-01-03 08:00:00 MST";
        Dateandtime d1 = new Dateandtime();

        Date date = df.parse(s1);
        d1.setThetimeonly(date);
        d1.setThedateonly(date);
        d1.setDateandtime(date);
        dateandtimeService.save(d1);

        String s2 = "2021-03-02 12:00:00 PST";
        Dateandtime d2 = new Dateandtime();

        date = df.parse(s2);
        d2.setThetimeonly(date);
        d2.setThedateonly(date);
        d2.setDateandtime(date);
        dateandtimeService.save(d2);

        String s3 = "2021-12-25 12:00:00 CST";
        Dateandtime d3 = new Dateandtime();

        date = df.parse(s3);
        d3.setThetimeonly(date);
        d3.setThedateonly(date);
        d3.setDateandtime(date);
        dateandtimeService.save(d3);
    }
}
