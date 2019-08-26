package com.example.demo.util;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

/**
 * @ClassName
 * @Description TODO
 * @Date 2019-08-26 14:27
 **/
public class MailUtil {

    //1邮箱的服务器地址
    private static final String smtpserver = "smtp.qq.com";
    //端口号
    private static final String port = "465";
    //发送人的邮箱
    private static final String account = "510717270@qq.com";
    //发送人邮箱的授权码
    private static final String pwd = "cjxhvryczyuebihj";

    public static void contextLoads(String msg){
        try {
            //创建邮件配置
            Properties properties = new Properties();
            //使用的协议
            properties.setProperty("mail.transport.protocol", "smtp");
            //发件人的邮箱的 SMTP 服务器地址
            properties.setProperty("mail.smtp.host", smtpserver);
            properties.setProperty("mail.smtp.port", port);
            properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            properties.setProperty("mail.smtp.auth", "true"); // 需要请求认证
            properties.setProperty("mail.smtp.ssl.enable", "true");// 开启ssl

            //根据邮件创建会话（传入配置文件）
            Session session = Session.getDefaultInstance(properties);
            // 开启debug模式，可以看到更多详细的输入日志
//            session.setDebug(true);

            //创建邮件对象传入session
            MimeMessage email = createEmail(session, msg);

            Transport transport = session.getTransport();
            //获取连接通道，pwd是授权码
            transport.connect(smtpserver, account, pwd);
            //发送
            transport.sendMessage(email, email.getAllRecipients());
            //关闭session连接
            transport.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static MimeMessage createEmail(Session session, String msg) throws UnsupportedEncodingException, MessagingException {
        MimeMessage message = new MimeMessage(session);

        // address邮件地址, personal邮件昵称, charset编码方式
        InternetAddress fromaddress = new InternetAddress(account, "test", "utf-8");
        //设置邮件的发送方
        message.setFrom(fromaddress);

        InternetAddress acvitaddress = new InternetAddress("li.zhixin@chinaott.net");
        //设置邮件接收方
        message.setRecipient(Message.RecipientType.TO, acvitaddress);
        //设置主题
        message.setSubject("ES搜索服务异常", "utf-8");

        message.setContent(msg, "text/html;charset=UTF-8");

        message.setSentDate(new Date());
        message.saveChanges();

        return message;
    }

    public static void main(String[] args) {
        contextLoads("测试");
    }
}
