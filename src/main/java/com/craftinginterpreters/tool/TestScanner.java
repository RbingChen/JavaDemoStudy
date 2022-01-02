package com.craftinginterpreters.tool;

import com.craftinginterpreters.lox.Scanner;
import com.craftinginterpreters.lox.Token;

import java.util.List;

public class TestScanner {
    private static void run(String source){
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();
        for(Token token : tokens){
            System.out.println(token);
        }
    }
    public static void main(String args[]){
        String code ="for (;;) class Foo {}";
        run(code);
    }
}
