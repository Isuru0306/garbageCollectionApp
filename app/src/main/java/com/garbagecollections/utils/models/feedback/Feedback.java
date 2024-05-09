package com.garbagecollections.utils.models.feedback;

import com.garbagecollections.utils.config.FireBaseConfig;
import com.garbagecollections.utils.models.helpers.FeedbackHelper;
import java.util.Random;

public class Feedback extends FireBaseConfig {

    public Feedback() {
        super("feedback");
    }

    public boolean insertFeedBack(FeedbackHelper feedbackHelper){
        try{
            Random random = new Random();
            String randomNumber =  String.valueOf(random.nextInt(900) + 1000);
            this.databaseReference.child(randomNumber).setValue(feedbackHelper);
            return  true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
