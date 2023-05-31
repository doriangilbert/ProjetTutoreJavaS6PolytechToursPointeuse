package application;

import java.io.Serializable;
import java.util.Date;

public class Check implements Serializable {
    public boolean EstUnCheckIn;
    public boolean EstUneErreur;
    public Date date;
    public int hour;
    public int minutes;

    public Check(boolean EstUnCheckIn,boolean EstUneErreur, Date date,int hour, int minutes){
        this.EstUnCheckIn=EstUnCheckIn;
        this.EstUneErreur=EstUneErreur;
        this.date =date;
        this.hour = hour;
        this.minutes = minutes;
    }

    public boolean getEstUnCheckIn() {
        return EstUnCheckIn;
    }

    public Date getDate() {
        return date;
    }

    public int getHour() {
        return hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setEstUnCheckIn(boolean estUnCheckIn) {
        EstUnCheckIn = estUnCheckIn;
    }
}
