package com.twoweekinterpreters;

public class NumToken extends Token{
    private int value ;
    protected NumToken(int line,int num) {
        super(line);
        this.value = num;
    }
    public boolean isNumber(){
        return true;
    }
    public String getText(){
        return Integer.toString(value);
    }
    public int getNumber(){
        return this.value;
    }
}
