/**
 * Дана json строка (можно сохранить в файл и читать из файла)
 * [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
 * {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
 * {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
 * Написать метод(ы), который распарсит json и, используя 
 * StringBuilder, создаст строки вида: 
 * Студент [фамилия] получил [оценка] по предмету [предмет].
 * Пример вывода:
 * Студент Иванов получил 5 по предмету Математика.
 * Студент Петрова получил 4 по предмету Информатика.
 * Студент Краснов получил 5 по предмету Физика.
 */

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.FileReader;

public class task03{
    public static void main(String[] args) throws IOException, ParseException{
        String[]  arr = {"фамилия", "оценка", "предмет"};
        JSONParser jsonParser = new JSONParser();
        try(FileReader fileTaskRead = new FileReader("Task03.json")){
            JSONArray arrFile = (JSONArray) jsonParser.parse(fileTaskRead);
            for(Object obj : arrFile){
                JSONObject per = (JSONObject) obj;
                String name = (String) per.get(arr[0]);
                String grade = (String) per.get(arr[1]);
                String subject = (String) per.get(arr[2]);
                System.out.printf("Студент %s получил %s по предмету %s.\n", name, grade, subject);

            }
        } catch(Exception e){
            System.out.println("Parsing error" + e.toString());
        }
        
    }
}
