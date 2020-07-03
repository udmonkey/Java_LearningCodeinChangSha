import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

//Jackson快速入门
public class Test01 {
    public static void main(String[] args) {
        //创建工具核心对象
        ObjectMapper om = new ObjectMapper();
        //创建一个java对象
        HashMap<String, String> map = new HashMap<>();
        map.put("1","zhangsan");
        map.put("2","pfh");
        try {
            //writeValueAsString(Object)  传入 java对象 返回json 字符串
            String jsonStr = om.writeValueAsString(map);
            System.out.println("json字符串"+jsonStr);
            //readValue(String,Object)  传入 json对象 返回java 字符串
            HashMap map2 = om.readValue(jsonStr, HashMap.class);
            System.out.println("java对象" + map2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
