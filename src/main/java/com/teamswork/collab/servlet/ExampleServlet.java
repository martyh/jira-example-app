package com.teamswork.collab.servlet;

import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.soy.renderer.SoyTemplateRenderer;
import com.teamswork.collab.services.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExampleServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(ExampleServlet.class);
    private final SoyTemplateRenderer soyTemplateRenderer;
    private final ResourceService resourceService;
    public ExampleServlet(@ComponentImport SoyTemplateRenderer soyTemplateRenderer, ResourceService resourceService) {
        this.soyTemplateRenderer = soyTemplateRenderer;
        this.resourceService = resourceService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String pluginKey = this.resourceService.getProperty("atlassian.plugin.key");
        Map<String, Object> map = new HashMap<>();
        map.put("pluginKey", pluginKey);

        String html = soyTemplateRenderer.render(pluginKey + ":example-app-resources", "servlet.ui.example", map);

        resp.setContentType("text/html");
        resp.getWriter().write(html);
        resp.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (log.isDebugEnabled()) {
            log.debug("doPost invoked on example servlet.");
        }
    }
}
