package com.ylq;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.w3c.dom.Document;
import org.xhtmlrenderer.context.AWTFontResolver;
import org.xhtmlrenderer.swing.Java2DRenderer;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static java.awt.Font.TRUETYPE_FONT;

public class Html2Pic {
    private static final String PATH="/Users/bing/Desktop/IDEA/JavaDemoStudy/src/main/resources/templates/";
    public static String getTemplate(String template, Map<String, Object> map) throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
        String templatePath = Html2Pic.PATH;
        System.out.println(templatePath);
        cfg.setDirectoryForTemplateLoading(new File(templatePath));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        Template temp = cfg.getTemplate(template);
        StringWriter stringWriter = new StringWriter();
        temp.process(map, stringWriter);
        stringWriter.flush();
        stringWriter.close();
        String resutl = stringWriter.getBuffer().toString();
        return resutl;
    }

    public static void turnImage(String template, Map<String, Object> map) throws Exception {

        String html = getTemplate(template, map);
        System.out.println(html);

        byte[] bytes=html.getBytes();
        ByteArrayInputStream bin=new ByteArrayInputStream(bytes);
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document document=builder.parse(bin);
        Java2DRenderer renderer = new Java2DRenderer(document,600,800);
        BufferedImage img = renderer.getImage();
//        response.setContentType("image/jpeg");
//        response.setDateHeader("expries", -1);
//        response.setHeader("Cache-Control", "no-cache");
//        response.setHeader("Pragma", "no-cache");
        //输出在页面
        // ImageIO.write(img, "jpg", response.getOutputStream());
        //指定下载路径
        File file=new File("测试.jpg");
        try {

            ImageIO.write(img, "jpg", file);
        }catch (Exception e){

            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("title", "标题");
        map.put("bg", Html2Pic.PATH+"/P1.jpeg");
        map.put("qrCode",  Html2Pic.PATH+"/P1.jpeg");
        turnImage("test.html", map);
    }

}
