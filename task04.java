/**
 * К калькулятору из предыдущего дз добавить логирование.
 */


import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class task04 {
    public static void main(String[] args) throws IOException{
        FileWriter fileTask = new FileWriter("logTask04.txt", true);
        StringBuilder strBui = new StringBuilder();
        strBui.append(LocalDateTime.now());
        strBui.append("\n");
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите операцию +, -, *, /, ! : ");
        String str = scan.nextLine();
        strBui.append("Операция: ");
        strBui.append(str);
        if (str.equals("!")) {
            System.out.print("Введите число n: ");
            int n = scan.nextInt();
            strBui.append("  было введено число: ");
            strBui.append(n);
            int res = 0;
            if (n != 0) {
                res++;
                for (int i = 1; i <= n; i++) {
                    res *= i;
                }
            }
            System.out.printf("результат равер %d \n", res);
            strBui.append("  результат равер: ");
            strBui.append(res);
        } else {
            System.out.print("Введите число a: ");
            int a = scan.nextInt();
            System.out.print("Введите число b: ");
            int b = scan.nextInt();
            strBui.append("  были введены числа a и b: ");
            strBui.append(a);
            strBui.append(" ");
            strBui.append(b);
            strBui.append("  результат равер: ");
            if (str.equals("+")) {
                strBui.append(a + b);
                System.out.printf("результат равер %d + %d = %d \n", a, b, a + b);
            } else if (str.equals("-")) {
                strBui.append(a - b);
                System.out.printf("результат равер %d - %d = %d \n", a, b, a - b);
            } else if (str.equals("*")) {
                strBui.append(a * b);
                System.out.printf("результат равер %d * %d = %d \n", a, b, a * b);
            } else if (str.equals("/")) {
                strBui.append(a / b);
                System.out.printf("результат равер %d / %d = %d \n", a, b, a / b);
            }
        }
        scan.close();
        strBui.append("\n");
        fileTask.write(strBui.toString());
        fileTask.flush();
        fileTask.close();
    }
}
