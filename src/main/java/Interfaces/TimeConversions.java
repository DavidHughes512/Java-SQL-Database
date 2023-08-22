package Interfaces;
/** This is the Time Conversions interface. This Interface establishes the grounds for lambdas to be used for converting times when altering data*/
@FunctionalInterface
public interface TimeConversions {
    String convertTime(String timeToConvert);
}
