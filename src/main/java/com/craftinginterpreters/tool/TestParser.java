package com.craftinginterpreters.tool;

import com.craftinginterpreters.lox.*;

import java.util.List;

public class TestParser {
    private static void run(String source){
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();
        Parser parser = new Parser(tokens);
        Expr expression = parser.parse();
//        for(Token token : tokens){
//            System.out.println(token);
//        }
        System.out.println(new AstPrinter().print(expression));
    }
    public static void main(String args[]){
        String code ="(3-1==6-2)==7-8==10*9";
        run(code);
    }
}
