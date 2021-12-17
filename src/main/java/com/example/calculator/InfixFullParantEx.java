package com.example.calculator;

/**
 * Created by Karunesh on 19-06-2017.
 */
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class InfixFullParantEx {

    public static String evaluateInfix(String input)
    {

        try {
            int i, j;
            i = input.indexOf("(");
            j = input.indexOf(")");
            int k;
            try {
                k = input.indexOf("(", i + 1);
            } catch (Throwable t) {
                k = -1;
            }
            if (k > j || k == (-1)) {
                input = input.substring(0, i) + evaluate(input.substring(i + 1, j)) + input.substring(j + 1, input.length());
                evaluateInfix(input);
            }
            else
            {
                evaluateInfix(input.substring(0,i+1)+evaluateInfix(input.substring(i+1,input.length())));
            }

        }
        catch (Throwable t) {
            input=evaluate(input);
        }
        return input;
    }
        public static String evaluate(String input)
        {
           // Scanner scan = new Scanner(System.in);
        /* Create stacks for operators and operands */
            Stack<Integer> op  = new Stack<Integer>();
            Stack<Double> val = new Stack<Double>();
        /* Create temporary stacks for operators and operands */
            Stack<Integer> optmp  = new Stack<Integer>();
            Stack<Double> valtmp = new Stack<Double>();
        /* Accept expression */
            input = "0" + input;
            input = input.replaceAll("-","+-");
        /* Store operands and operators in respective stacks */
            String temp = "";
            for (int i = 0;i < input.length();i++)
            {
                char ch = input.charAt(i);
                if (ch == '-')
                    temp = "-" + temp;
                else if (ch != '+' &&  ch != '*' && ch != '/' &&ch!='^')
                    temp = temp + ch;
                else
                {
                    val.push(Double.parseDouble(temp));
                    op.push((int)ch);
                    temp = "";
                }
            }
            val.push(Double.parseDouble(temp));
        /* Create char array of operators as per precedence */
        /* -ve sign is already taken care of while storing */
            char operators[] = {'^','/','*','+'};
        /* Evaluation of expression */
            for (int i = 0; i < 4; i++)
            {
                boolean it = false;
                while (!op.isEmpty())
                {
                    int optr = op.pop();
                    double v1 = val.pop();
                    double v2 = val.pop();
                    if (optr == operators[i])
                    {
                    /* if operator matches evaluate and store in temporary stack */
                        if (i == 0)
                        {
                            double temp2=1;
                            for(int j=0;j<(int)v1;j++)
                                temp2=temp2*v2;
                            valtmp.push(temp2);
                            it = true;
                            break;
                        }
                        else if (i == 1)
                        {
                            valtmp.push(v2 / v1);
                            it = true;
                            break;
                        }
                        else if (i == 2)
                        {
                            valtmp.push(v2 * v1);
                            it = true;
                            break;
                        }
                        else if (i == 3)
                        {
                            valtmp.push(v2 + v1);
                            it = true;
                            break;
                        }

                    }
                    else
                    {
                        valtmp.push(v1);
                        val.push(v2);
                        optmp.push(optr);
                    }
                }
            /* Push back all elements from temporary stacks to main stacks */
                while (!valtmp.isEmpty())
                    val.push(valtmp.pop());
                while (!optmp.isEmpty())
                    op.push(optmp.pop());
            /* Iterate again for same operator */
                if (it)
                    i--;
            }
            String result=val.pop()+"";
            try {
                int index = result.indexOf(".");
                return (result.substring(0,index+5));
            }catch(Throwable t){
            return (result);}
        }
    }