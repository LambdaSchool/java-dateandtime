package com.lambdaschool.dateandtime.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Dateandtime
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long dtid;

    @Temporal(TemporalType.DATE)
    private Date thedateonly;

    @Temporal(TemporalType.TIME)
    private Date thetimeonly;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateandtime;

    public Dateandtime()
    {
    }

    public long getDtid()
    {
        return dtid;
    }

    public void setDtid(long dtid)
    {
        this.dtid = dtid;
    }

    public Date getThedateonly()
    {
        return thedateonly;
    }

    public void setThedateonly(Date thedateonly)
    {
        this.thedateonly = thedateonly;
    }

    public Date getThetimeonly()
    {
        return thetimeonly;
    }

    public void setThetimeonly(Date thetimeonly)
    {
        this.thetimeonly = thetimeonly;
    }

    public Date getDateandtime()
    {
        return dateandtime;
    }

    public void setDateandtime(Date dateandtime)
    {
        this.dateandtime = dateandtime;
    }

    @Override
    public String toString()
    {
        return "Dateandtime{" +
            "dtid=" + dtid +
            ", thedateonly=" + thedateonly +
            ", thetimeonly=" + thetimeonly +
            ", dateandtime=" + dateandtime +
            '}';
    }
}
