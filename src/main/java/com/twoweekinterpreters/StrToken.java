package com.twoweekinterpreters;

public class StrToken extends Token{
    private  String literal;
    protected StrToken(int line,String str) {
        super(line);
        this.literal = str;
    }
    public boolean isString(){
        return true;
    }
    public String getText(){
        return this.literal;
    }
}
