package com.unknottedb.criminalintent;


import java.text.DateFormat;
import java.util.Date;
import java.util.UUID;

public class Crime {
    private UUID mID;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public Crime(){
        mID = UUID.randomUUID();
        mDate = new Date();
    }

    public void setDate(Date date) {
        mDate = date;
    }
    public Date getDate() {
        return mDate;
        //return DateFormat.getDateInstance().format(mDate);
    }
    public void setSolved(boolean solved) {
        mSolved = solved;
    }
    public boolean isSolved() {
        return mSolved;
    }
    public UUID getID() {
        return mID;
    }
    public void setTitle(String title) {
        this.mTitle = title;
    }
    public String getTitle() {
        return mTitle;
    }

    @Override
    public String toString(){
        return mTitle;
    }


}
