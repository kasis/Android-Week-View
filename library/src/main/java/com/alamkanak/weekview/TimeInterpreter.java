package com.alamkanak.weekview;

import java.util.Calendar;

/**
 * Creates string from hour that is displayed in the left column of the {@link WeekView}
 */
public interface TimeInterpreter {

    String interpretTime(int hour);
}
