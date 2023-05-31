package application;

import java.io.Serializable;
import java.util.Date;

public class Check implements Serializable {
    public boolean IsACheckIn;
    public boolean IsAnError;
    public Date date;
    public int hour;
    public int minutes;

    public Check(boolean IsACheckIn,boolean IsAnError, Date date,int hour, int minutes){
        this.IsACheckIn=IsACheckIn;
        this.IsAnError=IsAnError;
        this.date =date;
        this.hour = hour;
        this.minutes = minutes;
    }

    public boolean getisACheckIn() {
        return IsACheckIn;
    }

    public boolean getisAnError() {
        return IsAnError;
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

    public void setIsACheckIn(boolean IsACheckIn) {
        this.IsACheckIn = IsACheckIn;
    }

    public void setIsAnError(boolean IsAnError) {
        this.IsAnError = IsAnError;
    }
}
