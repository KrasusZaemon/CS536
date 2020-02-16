///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            P2 
// Files:            P2.java
// Semester:         Spring 2020
//
// Author:           Li Yinjie
// Email:            li2324@wisc.edu
// CS Login:         li2324
// Lecturer's Name:  Loris D'Antoni
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.*;
import java.io.*;
import java_cup.runtime.*;  // defines Symbol

/**
 * This program is to be used to test the Wumbo scanner.
 * This version is set up to test all tokens, but you are required to test 
 * other aspects of the scanner (e.g., input that causes errors, character 
 * numbers, values associated with tokens)
 */
public class P2 {
    public static void main(String[] args) throws IOException {
                                           // exception may be thrown by yylex
        // test all tokens
        testAllTokens("allTokens");
        CharNum.num = 1;
         testAllTokens("Validtoken");
        CharNum.num = 1;
        test_the_linenumber("Position_test");
        CharNum.num = 1;
        test_eof_or_error("eof");
        CharNum.num = 1;
        test_eof_or_error("Error_input");
        CharNum.num = 1;
    
        // ADD CALLS TO OTHER TEST METHODS HERE
    }

    /**
     * name
     *
     * Open and read from file name.txt
     * For each token read, write the corresponding string to name.out
     * If the input file contains all tokens, one per line, we can verify
     * correctness of the scanner by comparing the input and output files
     * (e.g., using a 'diff' command).
     */
    private static void testAllTokens(String name) throws IOException {
        // open input and output files
        FileReader inFile = null;
        PrintWriter outFile = null;
        try {
            inFile = new FileReader(name+".in");
            outFile = new PrintWriter(new FileWriter(name+".out"));
        } catch (FileNotFoundException ex) {
            System.err.println("File "+name+".in not found.");
            System.exit(-1);
        } catch (IOException ex) {
            System.err.println(name+".out cannot be opened.");
            System.exit(-1);
        }
        System.out.println("Test "+name+".in start");

        // create and call the scanner
        Yylex scanner = new Yylex(inFile);
        Symbol token = scanner.next_token();
        while (token.sym != sym.EOF) {
            switch (token.sym) {
            case sym.BOOL:
                outFile.println("bool"); 
                break;
            case sym.INT:
                outFile.println("int");
                break;
            case sym.VOID:
                outFile.println("void");
                break;
            case sym.TRUE:
                outFile.println("true"); 
                break;
            case sym.FALSE:
                outFile.println("false"); 
                break;
            case sym.STRUCT:
                outFile.println("struct"); 
                break;
            case sym.CIN:
                outFile.println("cin"); 
                break;
            case sym.COUT:
                outFile.println("cout");
                break;				
            case sym.IF:
                outFile.println("if");
                break;
            case sym.ELSE:
                outFile.println("else");
                break;
            case sym.WHILE:
                outFile.println("while");
                break;
            case sym.RETURN:
                outFile.println("return");
                break;
            case sym.ID:
                outFile.println(((IdTokenVal)token.value).idVal);
                break;
            case sym.INTLITERAL:  
                outFile.println(((IntLitTokenVal)token.value).intVal);
                break;
            case sym.STRINGLITERAL: 
                outFile.println(((StrLitTokenVal)token.value).strVal);
                break;    
            case sym.LCURLY:
                outFile.println("{");
                break;
            case sym.RCURLY:
                outFile.println("}");
                break;
            case sym.LPAREN:
                outFile.println("(");
                break;
            case sym.RPAREN:
                outFile.println(")");
                break;
            case sym.SEMICOLON:
                outFile.println(";");
                break;
            case sym.COMMA:
                outFile.println(",");
                break;
            case sym.DOT:
                outFile.println(".");
                break;
            case sym.WRITE:
                outFile.println("<<");
                break;
            case sym.READ:
                outFile.println(">>");
                break;				
            case sym.PLUSPLUS:
                outFile.println("++");
                break;
            case sym.MINUSMINUS:
                outFile.println("--");
                break;	
            case sym.PLUS:
                outFile.println("+");
                break;
            case sym.MINUS:
                outFile.println("-");
                break;
            case sym.TIMES:
                outFile.println("*");
                break;
            case sym.DIVIDE:
                outFile.println("/");
                break;
            case sym.NOT:
                outFile.println("!");
                break;
            case sym.AND:
                outFile.println("&&");
                break;
            case sym.OR:
                outFile.println("||");
                break;
            case sym.EQUALS:
                outFile.println("==");
                break;
            case sym.NOTEQUALS:
                outFile.println("!=");
                break;
            case sym.LESS:
                outFile.println("<");
                break;
            case sym.GREATER:
                outFile.println(">");
                break;
            case sym.LESSEQ:
                outFile.println("<=");
                break;
            case sym.GREATEREQ:
                outFile.println(">=");
                break;
			case sym.ASSIGN:
                outFile.println("=");
                break;
			default:
				outFile.println("UNKNOWN TOKEN");
            } // end switch

            token = scanner.next_token();
        } // end while
        outFile.close();
    }


    private static void test_the_linenumber(String name) throws IOException {
        // open input and output files
        FileReader inFile = null;
        PrintWriter outFile = null;
        try {
            inFile = new FileReader(name+".in");
            outFile = new PrintWriter(new FileWriter(name+".out"));
        } catch (FileNotFoundException ex) {
            System.err.println("File "+name+".in not found.");
            System.exit(-1);
        } catch (IOException ex) {
            System.err.println(name+".out cannot be opened.");
            System.exit(-1);
        }
        System.out.println("Test "+name+".in start");
        // create and call the scanner
        Yylex scanner = new Yylex(inFile);
        Symbol token = scanner.next_token();
        while (token.sym != sym.EOF) {
            outFile.println("Begin at character: "+((TokenVal)token.value).charnum + " in line: "+((TokenVal)token.value).linenum);
            token = scanner.next_token();
        } // end while
        outFile.close();
    }

    private static void test_eof_or_error(String name) throws IOException {
        // open input and output files
        FileReader inFile = null;
        try {
            inFile = new FileReader(name+".txt");
        } catch (FileNotFoundException ex) {
            System.err.println("File "+name+".txt not found.");
            System.exit(-1);
        }
        System.out.println("Test "+name+".txt start");
        // create and call the scanner
        Yylex scanner = new Yylex(inFile);
        Symbol token = scanner.next_token();
        while (token.sym != sym.EOF) {
            token = scanner.next_token();
        } // end while
    }

}
