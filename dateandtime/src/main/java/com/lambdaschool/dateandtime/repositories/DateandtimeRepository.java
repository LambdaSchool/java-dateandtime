package com.lambdaschool.dateandtime.repositories;

import com.lambdaschool.dateandtime.models.Dateandtime;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface DateandtimeRepository extends CrudRepository<Dateandtime, Long>
{
    List<Dateandtime> findByDateandtime(Date date);

    List<Dateandtime> findByThedateonly(Date date);

    List<Dateandtime> findByThetimeonly(Date date);
}
