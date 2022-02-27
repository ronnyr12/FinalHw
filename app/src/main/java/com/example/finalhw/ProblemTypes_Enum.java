package com.example.finalhw;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.NonNull;
import androidx.annotation.StringDef;

public interface ProblemTypes_Enum {
    @Retention(RetentionPolicy.SOURCE)
    @StringDef ({
            Electricity,
            Mechanics,
            Communication,
            Bakash,
            Hamash
    })
    @interface ProblemTypes{}
        String Electricity = "Electricity";
        String Mechanics = "Mechanics";
        String Communication = "Communication";
        String Bakash = "Bakash";
        String Hamash = "Hamash";

    /**
     * Called to notify the listener of the result of the payment.
     * @param problemTypes
     */
    void onProblemTypes(@NonNull @ProblemTypes String problemTypes);
}
