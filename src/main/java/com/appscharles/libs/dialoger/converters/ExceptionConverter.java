package com.appscharles.libs.dialoger.converters;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * The type Exception converter.
 */
public class ExceptionConverter {

    /**
     * To string string.
     *
     * @param exception the exception
     * @return the string
     */
    public static String toString(Exception exception){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        exception.printStackTrace(pw);
        return sw.toString();
    }
}
