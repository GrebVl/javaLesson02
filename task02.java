/**
 * Реализуйте алгоритм сортировки пузырьком числового массива,
 *  результат после каждой итерации запишите в лог-файл.
 */
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class task02 {
    public static String numToStr(int[] Arr) {
        StringBuilder strBuil = new StringBuilder();
        for(int i = 0; i < Arr.length; i++){
            strBuil.append(Arr[i]);
            if (i != Arr.length-1){
                strBuil.append(", ");
            }
        }
        String str = strBuil.toString();  
        return str;      
    }
    public static int[] searchBabble(int[] arr) throws IOException{
        FileWriter fileTask = new FileWriter("logTask02.txt", true);
        StringBuilder s = new StringBuilder();
        s.append(LocalDateTime.now());
        s.append("\n");
        s.append(numToStr(arr));
        s.append("\n");
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            s.append("min = ");
            s.append(arr[minIndex]);
            s.append("\n");
            for(int j = i + 1; j < arr.length; j++){
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            int val = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = val;
            s.append(numToStr(arr));
            s.append("\n");
        }
        fileTask.write(s.toString());
        fileTask.flush();
        fileTask.close();
        return arr;        
    }
    public static void main(String[] args) throws IOException{
        int[] usArr = {1, 5, 7, 2, 4, 0};
        int[] res = searchBabble(usArr);
        System.out.printf(numToStr(res));
        System.out.println();
    }
}
