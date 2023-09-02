package com.OpenWeather.Request.Utils;



public class WindDirectionConverter {

    public static String convertDegreesToCardinal(double degrees) {
        if (degrees >= 337.5 || degrees < 22.5) {
            return "Norte";
        } else if (degrees >= 22.5 && degrees < 67.5) {
            return "Noreste";
        } else if (degrees >= 67.5 && degrees < 112.5) {
            return "Este";
        } else if (degrees >= 112.5 && degrees < 157.5) {
            return "Sureste";
        } else if (degrees >= 157.5 && degrees < 202.5) {
            return "Sur";
        } else if (degrees >= 202.5 && degrees < 247.5) {
            return "Suroeste";
        } else if (degrees >= 247.5 && degrees < 292.5) {
            return "Oeste";
        } else if (degrees >= 292.5 && degrees < 337.5) {
            return "Noroeste";
        }
        return "Desconocido";
    }
}