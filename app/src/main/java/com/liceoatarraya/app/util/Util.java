package com.liceoatarraya.app.util;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Util {

    public static String findDifference(Date d1, Date d2) {

        String result = "Hace ";
        long difference = 0L;


        long differenceInTime
                = d2.getTime() - d1.getTime();

        difference
                = TimeUnit.MILLISECONDS
                .toSeconds(differenceInTime)
                % 60;
        if (difference > 0) {
            result = "Hace ";
            result += difference + " segundos";
            result = preProcess(result, Math.round(difference));
        }

        difference
                = TimeUnit
                .MILLISECONDS
                .toMinutes(differenceInTime)
                % 60;

        if (difference > 0) {
            result = "Hace ";
            result += difference + " minutos";
            result = preProcess(result, Math.round(difference));
        }

        difference
                = TimeUnit
                .MILLISECONDS
                .toHours(differenceInTime)
                % 24;

        if (difference > 0) {
            result = "Hace ";
            result += difference + " horas";
            result = preProcess(result, Math.round(difference));
        }

        difference
                = TimeUnit
                .MILLISECONDS
                .toDays(differenceInTime)
                % 365;

        if (difference > 0) {
            result = "Hace ";
            result += difference + " días";
            result = preProcess(result, Math.round(difference));
        }

        difference
                = TimeUnit
                .MILLISECONDS
                .toDays(differenceInTime)
                / 52L;

        if (difference > 0) {
            result = "Hace ";
            result += difference + " semanas";
            result = preProcess(result, Math.round(difference));
        }

        difference
                = TimeUnit
                .MILLISECONDS
                .toDays(differenceInTime)
                / 12L;

        if (Math.round(difference) == 1) {
            result = "Hace ";
            result += difference + " mes";
        }else if (difference > 0) {
            result = "Hace ";
            result += difference + " meses";
        }

        difference
                = TimeUnit
                .MILLISECONDS
                .toDays(differenceInTime)
                / 365L;

        if (Math.round(difference) == 1) {
            result = "Hace ";
            result += difference + " año";
        } else if (difference > 1) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            result = "Enviado el " + simpleDateFormat.format(d1);
        }

        return result;
    }

    private static String preProcess(String result, long difference) {
        if (difference == 1) return result.substring(0, result.length() - 1);
        return result;
    }

}
