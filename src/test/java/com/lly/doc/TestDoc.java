package com.lly.doc;

import com.lly.demo.config.TestBean;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

public class TestDoc {

    @Test
    public void createDoc() {
        Writer out = null;
        Configuration configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
        configuration.setClassForTemplateLoading(this.getClass(), "/templates");

        try {
            Template template = configuration.getTemplate("test_xy.xml");

            Map<String, Object> dataMap = getDataMap();

            String fileName = "C:\\Users\\Administrator\\Desktop\\测试\\" + UUID.randomUUID().toString() + ".doc";
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));

            template.process(dataMap, out);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }
        System.out.println("ok...");
    }

    public Map<String, Object> getDataMap() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("blNo", "Testaaaaaa");


        TestBean testBean = new TestBean();


        return dataMap;
    }

}
