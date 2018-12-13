package com.sql2.mock;


public interface CreditService {

    public int getUserCredit(int userId);

    public boolean addCredit(int userId,int score);
}
