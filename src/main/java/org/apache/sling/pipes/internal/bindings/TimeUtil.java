/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.sling.pipes.internal.bindings;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Utility class to be used in bindings
 */
public class TimeUtil {

    /**
     * @param date string date following <code>ISO_LOCAL_DATE</code>
     * @return Gregorian calendar impl of that time
     */
    public Calendar ofDate(String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        return GregorianCalendar.from(localDate.atStartOfDay(ZoneId.systemDefault()));
    }

    /**
     * @param time string date following <code>ISO_DATE_TIME</code>
     * @return Gregorian calendar impl of that time
     */
    public Calendar of(String time){
        OffsetDateTime dt = OffsetDateTime.parse(time);
        return GregorianCalendar.from(dt.toZonedDateTime());
    }
}
