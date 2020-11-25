package util;

public class RandomUtil {

    //随机数 6位验证码
    public synchronized static String getCode(){
        StringBuilder code = new StringBuilder();
        int num;
        for (int i = 0; i < 6; i++) {
            num = (int) (Math.random()*10);
            code.append(String.valueOf(num));
        }
        return code.toString();
    }

}
