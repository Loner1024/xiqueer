import utils.Api;

import java.util.HashMap;
import java.util.Map;


public class Main {

    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();

        //登录参数(源代码中put的顺序)
		/*hashMap.put("loginId", "账号");
		hashMap.put("xxdm", "13589");
		hashMap.put("pwd", "密码");
		hashMap.put("action", "getLoginInfoNew");
		hashMap.put("isky", "1");
		hashMap.put("sjbz", "861997044188014");
		hashMap.put("sswl", "46000");
		hashMap.put("sjxh", "MI 8");
		hashMap.put("os", "android");
		hashMap.put("xtbb", "9");
		hashMap.put("loginmode", "0");
		hashMap.put("appver", "2.4.506");*/

        //选择学校(源代码中put的顺序)
        /*hashMap.put("action", "getAgent");
        hashMap.put("appver", "2.4.506");
        hashMap.put("xxmc", "");*/

        //取课表(源代码中put的顺序)
        hashMap.put("userId", "账号");
        hashMap.put("usertype", "STU");
        hashMap.put("action", "getKb");
        hashMap.put("step", "kbdetail_bz");
        hashMap.put("bjdm", "");
        hashMap.put("jsdm", "");
        hashMap.put("xnxq", "20190");
        hashMap.put("week", "");
        hashMap.put("channel", "jrkb");

        //取课表,未携带账号(也许是登录时返回的，至少我是)，密匙(与密码不同哦，登录时返回)
        String param1 = "jsdm=&week=&xnxq=20190&channel=jrkb&usertype=STU&action=getKb&step=kbdetail_bz&userId=账号&bjdm=";

        //取课表,携带账号
        String param2 = "jsdm=&week=&xnxq=20190&channel=jrkb&usertype=STU&action=getKb&step=kbdetail_bz&userId=123456&bjdm=&sfid=123456&uuid=1234567";

        //这个东西确确实实是登录后返回的，默认值是: 00000(也就是登录时携带的)
        String token = "00000";

        //调用解密函数
        Map<String, String> encodeingMap = Api.encodeing(hashMap, true, "账号", "密匙", token);
        Map<String, String> encodeingMap1 = Api.encodeing(param1, true, "账号", "密匙", token);
        Map<String, String> encodeingMap2 = Api.encodeing(param2, token);

        //遍历
        for (Map.Entry i : encodeingMap.entrySet()) {
            System.out.println(i.getKey() + "=" + i.getValue());
        }
        System.out.println("------------------Cutting line--------------------");
        //遍历
        for (Map.Entry i : encodeingMap1.entrySet()) {
            System.out.println(i.getKey() + "=" + i.getValue());
        }
        System.out.println("------------------Cutting line--------------------");
        //遍历
        for (Map.Entry i : encodeingMap2.entrySet()) {
            System.out.println(i.getKey() + "=" + i.getValue());
        }

        System.out.println("如果侵犯到您的权益或者隐私，请与我联系删除，敬谢！");
    }
}
