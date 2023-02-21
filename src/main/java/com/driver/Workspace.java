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
        this.calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);

    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.

        ArrayList<Pair<LocalTime,Integer>> endTimes = new ArrayList<>();
        //make ArrayList of a pair of endtime and index
        for(int i=0;i<calendar.size();i++) {
            endTimes.add(Pair.of(calendar.get(i).getEndTime(),i));
        }

        Collections.sort(endTimes);
        LocalTime  time_limit = endTimes.get(0).getLeft();//remove the initial endTime
        int count =0;

        if(endTimes.size()==0){
            count++;
            return count;
        }

        for(int i=1;i<endTimes.size();i++){//compare the end time of other meeting with time-limit
            if(calendar.get(endTimes.get(i).getRight()).getEndTime().compareTo(time_limit)>0){
                count++;
                time_limit = endTimes.get(i).getLeft();
            }
        }
        return count;

    }
}
