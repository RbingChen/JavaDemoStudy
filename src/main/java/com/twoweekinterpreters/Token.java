package com.twoweekinterpreters;

public abstract class Token {
    public static final Token EOF = new Token(-1){};
    public static final String EOL = "\\n";
    private int lineNumber;
    protected Token(int line){
        this.lineNumber = line;
    }
    public int getLineNumber(){
        return this.lineNumber;
    }
    public boolean isIdentifier(){
        return false;
    }
    public boolean isNumber(){
        return false;
    }
    public boolean isString(){
        return false;
    }
    public int getNumber(){
        throw new StoneException("not number token");
    }
    public String getText(){
        return "";
    }
}
