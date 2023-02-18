Emails

Mail is one of the oldest and most reliable sources of communication. In today’s world, electronic mails (Email) are used for both personal and professional use.

Any email can be defined using two basic entities: an email Id and a password. Email services might range from basic features like receive and delete mails to managing daily calendars and meetings. A popular email service provider is Google.

For personal/limited usage, Google offers Gmail. Using Gmail, we can create an account, receive mails and delete the mails we do not need. However, the maximum number of mails we can store in a Gmail inbox might be limited.
For professional usage, Google offers Workspace. Workspace contains all features provided by Gmail. Some additional advantages of Workspace are: huge inbox capacity and the feature of organising calendars for daily meetings.
Consider the following classes which implement the above mentioned system:

Email: An email contains an emailId (String) and a password (String). Initially, the password is set as "Accio@123" by default.

a. changePassword(String oldPassword, String newPassword): This method allows you to change the email password. The password can be changed only if the oldPassword is equal to current password and the newPassword meets all of the following conditions:

 - It contains at least 8 characters.
 - It contains at least one uppercase letter.
 - It contains at least one lowercase letter.
 - It contains at least one digit.
 - It contains at least one special character. Any character apart from alphabets and digits is considered a special character.
Gmail: Gmail extends Email. A Gmail account has an inboxCapacity (the maximum number of mails that can be stored in the inbox), an Inbox (collection of mails), and a Trash (collection of mails). A mail contains a date (Date), senderId (String), message (String). It is guaranteed that the messages of all the mails are distinct. Gmail offers the following features:

a. receiveMail(Date date, String sender, String message): If the inbox is full, move the oldest mail in the inbox to trash. Add the new mail to the inbox. It is guaranteed that the mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.

b. deleteMail(String message): If the given message is found in any mail in the inbox, move the mail to trash, else do nothing. Note that all the messages are distinct. Thus, at most one match would be found in the inbox.

c. findLatestMessage(): If the inbox is empty, return null. Else, return the message of the latest mail present in the inbox.

d. findOldestMessage(): If the inbox is empty, return null. Else, return the message of the oldest mail present in the inbox.

e. findMailsBetweenDates(Date start, Date end): Return the number of mails present in the inbox that are received between the given dates (both included). It is guaranteed that the start date is smaller than equal to the end date.

f. getInboxSize(): Return the number of mails in the inbox at a particular time.

g. getTrashSize(): Return the number of mails in the trash at a particular time.

h. emptyTrash(): Clear all the mails in the trash.

i. getInboxCapacity(): Return the maximum number of mails that can be stored in the inbox.

Meeting: Meeting contains a startTime (LocalTime), and an endTime (LocalTime). It is guaranteed that the start time is always less than equal to the end time.

Workspace: Workspace extends Gmail. By default, the inbox capacity of a Workspace account is equal to the maximum value an integer can store. A workspace account consists of a calendar which stores the timings of daily meetings. It offers the following features:

a. addMeeting(Meeting meeting): Add a meeting to the calendar.

b. findMaxMeetings(): Return the maximum number of meetings you can attend, such that, at a particular time, you can be present in at most one meeting. Note that, if you want to attend a meeting, you must join it at its start time and leave at end time. Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am.

Complete the code of the above mentioned functions. Note that you must not change the names of any existing class or method.
