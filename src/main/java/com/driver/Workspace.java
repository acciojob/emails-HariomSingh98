package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId,Integer.MAX_VALUE);
        calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);

    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
       if(calendar.size()==0)return 0;
       int count=1;
       Collections.sort(calendar,(a,b)->a.getStartTime().compareTo(b.getStartTime()));
       LocalTime initialStart = calendar.get(0).getStartTime();
       LocalTime endStart = calendar.get(0).getEndTime();
       for(int i=1;i<calendar.size();i++){
           LocalTime nextStart = calendar.get(i).getStartTime();
           if((nextStart.compareTo(initialStart))<0 && (nextStart.compareTo(endStart))>0){
               count++;
               initialStart = nextStart;
               endStart = calendar.get(i).getEndTime();
           }
       }
       return count;

    }
}
