package br.pucpr.poo.Estacionamento;

public class HourMinute {

    int hour=0;
    int minute=0;

    public String toString(){

        String hm=hour+ ":" +minute;

        return hm;
    }

    public HourMinute calcHourMinuteDif(HourMinute other){

        HourMinute Dif =new HourMinute();

        if (other.minute<minute){

            other.minute+=60;
            other.hour--;
        }

        Dif.hour=other.hour-hour;
        Dif.minute= other.minute-minute;

        return Dif;
    }
}
