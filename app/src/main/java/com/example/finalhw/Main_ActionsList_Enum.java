package com.example.finalhw;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.NonNull;
import androidx.annotation.StringDef;

public interface Main_ActionsList_Enum {
    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
            Open_error,
            Map,
            Fix_Team,
            Notify,
            Info,
            Peoples,
            Message,
            Settings
    })
    @interface ActionList {
    }

    String Open_error = "פתיחת תקלה";
    String Map = "מפה";
    String Fix_Team = "חולייה";
    String Notify = "תזכורת";
    String Info = "מידע";
    String Peoples = "כוח אדם";
    String Message = "צ'אט";
    String Settings = "הגדרות";

    /**
     * Called to notify the listener of the result of the payment.
     *
     * @param actionTypes
     */
    void onProblemTypes(@NonNull @ActionList String actionTypes);
}
