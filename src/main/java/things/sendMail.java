package things;

import util.MailUtil;
import util.RandomUtil;

public class sendMail {
    /*
     * 向邮箱发送验证码
     * */
    public static void main(String[] args) {

        try{
            //接收人
            String mailAddress = "1015355840@qq.com";
            //生成验证码
            String verifyCode = RandomUtil.getCode();
            //邮件主题
            String emailTitle = "邮箱验证";
            //邮件内容
            String emailContent = "您正在进行邮箱验证，您的验证码为：" + verifyCode + "，请于5分钟内完成验证！";
            //发送邮件
            MailUtil.sendMail(mailAddress, emailTitle, emailContent);

            System.out.println("邮箱验证码发送成功");
        }catch(Exception e){
            System.out.println("邮箱验证码发送失败");
        }

    }
}
