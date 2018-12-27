package com.bootdo.system.servlet;

import com.bootdo.common.annotation.Log;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

//@WebServlet(urlPatterns = "/validateCodeServlet")
public class ValidateCodeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Log("validate code do doPost.....")
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("validate code do doPost.....");
        super.doPost(req, resp);
    }
    @Log("validate code do post.....")
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("validate code do doGet.....");
        int width = 60;
        int height = 32;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(new Color(0xDCDBD2));
        g.fillRect(0, 0, width, height);
        g.setColor(Color.black);
        g.drawRect(0, 0, width - 1, height - 1);
        Random rdm = new Random();
        String hash1 = Integer.toHexString(rdm.nextInt());
        System.out.println(hash1);
        for (int i = 0; i < 50; i++) {
            int x = rdm.nextInt(width);
            int y = rdm.nextInt(height);
            g.drawOval(x, y, 0, 0);
        }
        String capstr = hash1.substring(0, 4);
        Session session = SecurityUtils.getSubject().getSession();
        //将生成的验证码存入session
        session.setAttribute("validateCode", capstr);
        g.setColor(new Color(53, 61, 255));
        g.setFont(new Font("宋体", Font.PLAIN, 24));
        g.drawString(capstr, 8, 24);
        g.dispose();
        //输出图片
        resp.setContentType("image/jpeg");
        OutputStream strm = resp.getOutputStream();
        ImageIO.write(image, "jpeg", strm);
        strm.close();
        super.doGet(req, resp);
    }
}
