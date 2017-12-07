package top.dongpeili.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

@WebServlet("/email")
public class Email extends HttpServlet {

	/**
	 * @question 测试不通过 A secure connection is requiered(such as ssl).
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * @summary qq要授权码, 不知道加到哪里. 测试网易的
	 * @date 2017年12月5日
	 * @return boolean
	 * @author dpl
	 */
	public boolean send2() {
		// 发送email对象
		HtmlEmail email = new HtmlEmail();
		try {
			// 这里是SMTP发送服务器的名字
			email.setHostName("smtp.163.com");
			// 端口号不为空时,用户自定义的端口号为SMTP发送服务器端口号
			if (!"".equals("465")) {
				email.setSSLOnConnect(true);
				email.setSslSmtpPort("465");
			}
			// 字符编码集的设置
			email.setCharset("UTF-8");
			// 收件人的邮箱
			email.addTo("526741151@qq.com");
			// 发送人的邮箱
			email.setFrom("dong.peili@icerno.com", "董佩力");
			// 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和密码
			email.setAuthentication("dong.peili@icerno.com", "Lzhl2017");
			// 要发送的邮件主题
			email.setSubject("today");
			// 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
			email.setMsg("tot");
			// 发送
			email.send();
			return true;
		} catch (EmailException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @summary 测试qq的
	 * @date 2017年12月5日
	 * @return boolean
	 * @author dpl
	 */
	public boolean send() {
		// 发送email对象
		HtmlEmail email = new HtmlEmail();
		try {
			// 这里是SMTP发送服务器的名字
			email.setHostName("smtp.qq.com");
			// 端口号不为空时,用户自定义的端口号为SMTP发送服务器端口号
			if (!"".equals("465")) {
				email.setSSLOnConnect(true);
				email.setSslSmtpPort("465");
			}
			// 字符编码集的设置
			email.setCharset("UTF-8");
			// 收件人的邮箱
			email.addTo("dong.peili@icerno.com");
			// 发送人的邮箱
			email.setFrom("526741151@qq.com", "董佩力");
			// 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和密码
			email.setAuthentication("526741151@qq.com", "Muyang7707183");
			// 要发送的邮件主题
			email.setSubject("today");
			// 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
			email.setMsg("tot");
			// 发送
			email.send();
			return true;
		} catch (EmailException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @summary 测试邮件发送, 需要ssl
	 * @date 2017年12月5日
	 * @return void
	 * @author dpl
	 */
	@SuppressWarnings("static-access")
	protected void sendMessage(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
		// 收件人的电子邮件 ID
		String to = "dong.peili@icerno.com";

		// 发件人的电子邮件 ID
		String from = "526741151@qq.com";

		// 假设您是从本地主机发送电子邮件
		String host = "smtp.qq.com";

		// 获取系统的属性
		Properties properties = System.getProperties();

		// 设置邮件服务器
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.user", "526741151@qq.com");
		properties.setProperty("mail.password", "Muyang7707183");
		properties.setProperty("mail.transport.protocol", "smtp");

		// 获取默认的 Session 对象
		Session session = Session.getDefaultInstance(properties);

		// 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		try {
			// 创建一个默认的 MimeMessage 对象
			MimeMessage message = new MimeMessage(session);
			// 设置 From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// 设置 To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// 设置 Subject: header field
			message.setSubject("主题!");
			// 现在设置实际消息
			message.setText("晋太元中，武陵人捕鱼为业。缘溪行，忘路之远近。忽逢桃花林，夹岸数百步，中无杂树，芳草鲜美，落英缤纷，渔人甚异之。复前行，欲穷其林。");
			// 发送消息
			Transport transport = session.getTransport();
			System.out.println(1);
			transport.connect("smtp.qq.com", "526741151", "Muyang7707183");

			transport.send(message);
			String title = "发送电子邮件";
			String res = "成功发送消息...";
			String docType = "<!DOCTYPE html> \n";
			out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n" + "<p align=\"center\">"
					+ res + "</p>\n" + "</body></html>");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.sendMessage(req, resp);
		// this.send2();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
