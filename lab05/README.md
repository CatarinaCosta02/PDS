# Aula05 - Notes

A class main é usada para dar print das classes criadas.

## Ex1: Factory method

## Ex2: Builder

## Ex3 : Builder
## EX4:

### calendar.txt

### Factroty Method: lets a class defer instantiation to subclasses

In the given example, we can observe that it is possible to instantiate various types of calendars and create various types of calendars.

``` 
public static Calendar getInstance(TimeZone zone,
                                       Locale aLocale)
    {
        return createCalendar(zone, aLocale);
    }

    private static Calendar createCalendar(TimeZone zone,
                                           Locale aLocale)```
                                       
