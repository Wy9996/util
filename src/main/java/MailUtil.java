import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

public class MailUtil {
    //邮件服务器主机名
    private static String myEmailSMTPHost = "smtp.qq.com";
    //发件人邮箱
    private static String myEmailAccount = "250668861@qq.com";
    //发件人授权码
    private static String myEmailPassword = "rurvarmhlsbrbgfd";

    public static void sendMail(String toEmailAdress,String emailTitle,String emailContent) throws Exception{
        Properties properties = new Properties();

//        //开启debug调试
        properties.setProperty("mail.debug","true");
        //发送服务器需要身份证验证
        properties.setProperty("mail.smtp.auth","ture");
        //端口号
        properties.put("mail.smtp.port",465);
        //设置邮箱服务器主机名
        properties.setProperty("mail.smtp.host",myEmailSMTPHost);

        //发送邮件协议名称
        properties.setProperty("mail.transport.protocol","smtp");

        //ssl认证
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);

        //设置是否使用ssl安全连接
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.ssl.socketFactory",sf);

        //创建会话
        Session session = Session.getInstance(properties);

        //获取邮件对象
        Message msg = new MimeMessage(session);

        //设置邮件标题
        msg.setSubject(emailTitle);

        //设置邮件内容
        StringBuilder builder = new StringBuilder();

        //写入内容
        builder.append("\n"+emailContent);

        //显示邮件发件时间
        msg.setSentDate(new Date());

        //设置邮件内容
        msg.setText(builder.toString());

        //设置发件人
        msg.setFrom(new InternetAddress(myEmailAccount,"工作站","UTF-8"));

        //得到邮差对象
        Transport transport = session.getTransport();

        //连接自己的邮箱
        transport.connect(myEmailSMTPHost,myEmailAccount,myEmailPassword);

        //发送邮件
        transport.sendMessage(msg,new Address[]{ new InternetAddress(toEmailAdress)});

        //将邮件保存到本地
        OutputStream outputStream = new FileOutputStream("myEmail.eml");
        msg.writeTo(outputStream);
        outputStream.flush();
        outputStream.close();

        transport.close();
    }
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
                    sendMail(mailAddress, emailTitle, emailContent);

                    System.out.println("邮箱验证码发送成功");
                }catch(Exception e){
                    System.out.println("邮箱验证码发送失败");
                }




    }

}
