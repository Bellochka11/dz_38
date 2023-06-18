// Дана строка sql-запроса "select * from students WHERE ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
//  Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Пример данной строки {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Вывод: select * from students WHERE name=Ivanov AND country=Russia AND city=Moscow
public class dz1 {
  
  public static void main(String[] args) {
    String text = "{\"name\":\"Ivanov\", \"country\":\"null\", \"city\":\"Moscow\", \"age\":\"21\"}";

    String text1 = text.substring(1, text.length() - 1);

    String[] keyWithVal = text1.split(", ");    

    StringBuilder res = new StringBuilder();
    boolean flag = true;

    for (String item : keyWithVal) {
      String[] keyValue = item.split(":");
      String key = keyValue[0].replace("\"", ""); 
      String value = keyValue[1].replace("\"", ""); 

      if (!value.equalsIgnoreCase("null")) {
        if(flag==false)
          res.append(" AND ");
        res.append(key).append("=").append(value);
        flag = false; 
      }  
    }

    String sql = "SELECT * FROM students WHERE " + res.toString();
    System.out.println(sql);    
  } 
}
