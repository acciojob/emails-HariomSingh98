package com.driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class Gmail extends Email {

    private  int inboxCapacity; //maximum number of mails inbox can store

    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    private ArrayList<Mail> inbox;
    private ArrayList<Mail> trash ;





    public Gmail(String emailId, int inboxCapacity) {
         super(emailId);
         this.inboxCapacity=inboxCapacity;
         this.inbox = new ArrayList<>();
         this.trash= new ArrayList<>();

    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
        Mail n = new Mail(date,sender,message);
        if(inbox.size() == inboxCapacity){
           Mail old = inbox.remove(0);
           trash.add(old);
           inbox.add(n);
           return ;
       }
       inbox.add(n);
    }

    public void deleteMail(String message) {
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        int index = -1;
        for (int i = 0; i < inbox.size(); i++) {
            if (message.equals(inbox.get(i).getMessage())) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            trash.add(inbox.get(index));
            inbox.remove(index);
        }
    }
    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if(inbox.isEmpty())return null;
        Mail temp= inbox.get(inbox.size()-1);
        return temp.getMessage();

    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(inbox.isEmpty())return null;
        Mail temp = inbox.get(0);
        return temp.getMessage();

    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        if(inbox.isEmpty())return 0;
        int count =0;
        for(int i=0;i<inbox.size();i++){
            if ( (inbox.get(i).getDate().compareTo(start) >= 0) && (inbox.get(i).getDate().compareTo(end) <= 0))count++;
        }
       return count ;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return inbox.size();

    }


    public int getTrashSize(){
        // Return number of mails in Trash
        return trash.size();

    }


    public void emptyTrash(){
        // clear all mails in the trash
        trash.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
          return   this.inboxCapacity;
    }
}
