package com.twoweekinterpreters;

import java.io.IOException;

public class ParseException extends Exception{
    public ParseException(Token t){
        this("", t);
    }
    public ParseException(IOException e){
        super(e);
    }
    public ParseException(String msg){
        super(msg);
    }
    public ParseException(String msg, Token t){
        super("syntax error around " + location(t) + ". "+msg);
    }
    private static String location(Token t){
        if( t == Token.EOF)
            return "the last line";
        else
            return "\""+ t.getText() + "\" at line"+ t.getLineNumber();
    }

}
