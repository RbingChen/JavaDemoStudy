package com.craftinginterpreters.lox;


public class RuntimeError extends RuntimeException{
    private Token token ;
    public RuntimeError(Token token,String message){
        super(message);
        this.token = token;
    }
    public Token getToken(){
        return this.token;
    }
}
