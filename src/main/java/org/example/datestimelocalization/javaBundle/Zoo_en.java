package org.example.datestimelocalization.javaBundle;

import java.util.ListResourceBundle;

public class Zoo_en extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
            {"hello", "Hello - form Java class"},
            {"open", "The zoo is open"}
        };
    }
}
