package com.thoughtworks.is.stringtemplate;

import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.core.io.Resource;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.StringTemplate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.io.PrintWriter;

public class StringTemplateView extends InternalResourceView {

    @Override
    protected void renderMergedOutputModel(Map model, HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {

        Resource templateFile = getApplicationContext().getResource("/WEB-INF/templates");

        StringTemplateGroup group = new StringTemplateGroup("webpages", templateFile.getFile().getPath());
        StringTemplate template = group.getInstanceOf(getBeanName());
        template.setAttributes(model);

        PrintWriter writer = response.getWriter();
        writer.print(template);
        writer.flush();
        writer.close();
    }
}
