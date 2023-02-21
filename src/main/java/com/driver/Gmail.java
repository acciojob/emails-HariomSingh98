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

    private  int inboxSize;
    private int trashSize;



    public Gmail(String emailId, int inboxCapacity) {
         super(emailId);
         this.inboxCapacity=inboxCapacity;
         this.inboxSize=0;
         this.trashSize=0;
         this.inbox = new ArrayList<>();
         this.trash= new ArrayList<>();

    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
        Mail n = new Mail(date,sender,message);
        if(getInboxSize()==getInboxCapacity()){
           trash.add(inbox.remove(0));
           setTrashSize(trash.size());
           inbox.add(n);
           setInboxSize(inbox.size());
           return ;
       }
       inbox.add(n);
        setInboxSize(inbox.size());

    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        for(int i=0;i<getInboxSize();i++){
            if(inbox.get(i).getMessage().equals(message)){
                trash.add(inbox.remove(i));
                setTrashSize(trash.size());
                setInboxSize(inbox.size());
                return ;
            }
        }

    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if(getInboxSize()== 0)return null;
        Mail temp= inbox.get(getInboxSize()-1);
        return temp.getMessage();

    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(getInboxSize()==0)return null;
        Mail temp = inbox.get(0);
        return temp.getMessage();

    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        if(getInboxSize()==0)return 0;
        int count =0;
        for(int i=0;i<getInboxSize();i++){
            Mail temp= inbox.get(i);
            if ( temp.getDate().compareTo(start) >= 0 && temp.getDate().compareTo(end) <= 0)count++;
        }
       return count ;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return this.inboxSize;

    }
    public void setInboxSize(int size){
        this.inboxSize= size;
    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return this.trashSize;

    }
    public void setTrashSize(int size){
        this.trashSize=size;
    }

    public void emptyTrash(){
        // clear all mails in the trash
        trash.clear();
        setTrashSize(0);
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
          return   this.inboxCapacity;
    }
}
