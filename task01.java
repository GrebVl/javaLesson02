/**
 * Дана строка sql-запроса "select * from students where ".
 * Сформируйте часть WHERE этого запроса, используя StringBuilder. 
 * Данные для фильтрации приведены ниже в виде json строки.
 * Если значение null, то параметр не должен попадать в запрос.
 * Параметры для фильтрации: 
 * {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 */
import org.json.simple.JSONObject;

public class task01{
    public static void main(String[] args) {
        JSONObject obj = new JSONObject();
        String[]  arr = {"name", "countri", "city", "age"};
        obj.put(arr[0], "Ivanov");
        obj.put(arr[1], "Russia");
        obj.put(arr[2], "Moscow");
        obj.put(arr[3], "null");
        StringBuilder where = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            if(obj.get(arr[i]) != "null"){
                where.append(obj.get(arr[i]));
                where.append(" ");
            }
        }
        System.out.printf("select * from students %s\n", where.toString());
    }
}