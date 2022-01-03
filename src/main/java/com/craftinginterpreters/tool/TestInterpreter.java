package com.craftinginterpreters.tool;

import com.craftinginterpreters.lox.*;

import java.util.List;

public class TestInterpreter {
    private static void run(String source){
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();
        Parser parser = new Parser(tokens);
        Expr expression = parser.parse();
        Interpreter interpreter = new Interpreter();
        interpreter.interpret(expression);
    }
    public static void main(String args[]){
        String code ="1+\"jd\"";
        run(code);
    }
}
