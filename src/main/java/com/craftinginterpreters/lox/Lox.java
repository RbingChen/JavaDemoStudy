package com.craftinginterpreters.lox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
public class Lox {
    private static boolean hadError = false;
    private static boolean hadRuntimeError = true;

    public static void error(int line,String message){
        report(line,"",message);
    }
    public static void error(Token token, String message) {
        if (token.type == TokenType.EOF) {
            report(token.line, " at end", message);
        } else {
            report(token.line, " at '" + token.lexeme + "'", message);
        }
    }
    public static void runtimeError(RuntimeError error){
        System.err.println(error.getMessage()+"\n[line "+error.getToken().line+" ]");
        hadRuntimeError = true;
    }
    public  static void report(int line,String where,String message){
        System.err.println("[line "+line+"] Error "+ where + ":"+message);
        hadError = true;
    }
    public static void main(String []args) throws IOException{
        if(args.length > 1){
            System.out.println("Usage : jlox [script]");
            System.exit(64);
        }else if(args.length == 1){
            runFile(args[0]);
        }else{
            runPrompt();
        }
    }
    private  static void runFile(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        run(new String(bytes, Charset.defaultCharset()));
        if(hadError) System.exit(65);
        if (hadRuntimeError) System.exit(70);
    }
    private static void runPrompt() throws IOException{
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        for(;;){
            System.out.println(">");
            String line = reader.readLine();
            if(line == null) break;
            run(line);
            if(hadError) System.exit(65);
        }
    }
    private static void run(String source){
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();
        for(Token token : tokens){
            System.out.println(token);
        }
    }
}
