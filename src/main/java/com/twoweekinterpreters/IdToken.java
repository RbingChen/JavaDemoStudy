package com.twoweekinterpreters;

public class IdToken extends Token{
    private String text;
    protected IdToken(int line,String id) {
        super(line);
        this.text = id;
    }
    public boolean isIdentifier(){
        return true;
    }
    public String getText(){
        return text;
    }
}
