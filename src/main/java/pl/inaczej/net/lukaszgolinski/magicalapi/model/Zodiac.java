package pl.inaczej.net.lukaszgolinski.magicalapi.model;

import java.time.LocalDate;

public enum Zodiac {

    ARIES(newDate(3, 21), newDate(4, 20), "baran"),
    TAURUS(newDate(4, 21), newDate(5, 21), "byk"),
    GEMINI(newDate(5, 22), newDate(6, 21), "bliznieta"),
    CANCER(newDate(6, 22), newDate(7, 22), "rak"),
    LEO(newDate(7, 23), newDate(8, 22), "lew"),
    VIRGO(newDate(8, 23), newDate(9, 23), "panna"),
    LIBRA(newDate(9, 24), newDate(10, 23), "waga"),
    SCORPIO(newDate(10, 24), newDate(11, 22), "skorpion"),
    SAGITTARIUS(newDate(11, 23), newDate(12, 21), "strzelec"),
    CAPRICORN(newDate(12, 22), newDate(1, 20), "koziorozec"),
    AQUARIUS(newDate(1, 21), newDate(2, 19), "wodnik"),
    PISCES(newDate(2, 20), newDate(3, 20), "ryby");

    public String polishName;
    private LocalDate fromDate;
    private LocalDate toDate;

    Zodiac(LocalDate fromDate, LocalDate toDate, String polishName) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.polishName = polishName;
    }

    private static LocalDate newDate(int monthOfYear, int dayOfMonth) {
        return LocalDate.of(2000, monthOfYear, dayOfMonth);
    }

    public static Zodiac toZodiac(LocalDate birthday) {
        for (Zodiac zodiac : values()) {
            LocalDate fromWithYear = zodiac.fromDate.withYear(birthday.getYear());
            LocalDate toWithYear = zodiac.toDate.withYear(birthday.getYear());

            if (birthday.getMonthValue() == 12 && Zodiac.CAPRICORN.equals(zodiac)) {
                toWithYear = toWithYear.plusYears(1);
            } else if (birthday.getMonthValue() == 1 && Zodiac.CAPRICORN.equals(zodiac)) {
                fromWithYear = fromWithYear.minusYears(1);
            }

            if ((fromWithYear.isBefore(birthday) || fromWithYear.isEqual(birthday))
                    && (toWithYear.isAfter(birthday) || toWithYear.isEqual(birthday))) {
                return zodiac;
            }
        }

        throw new IllegalArgumentException("Cannot find zodiac sign for date: " + birthday);
    }
}
