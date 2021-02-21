package com.mini.blog.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mini.blog.model.vo.ResultVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author kpq
 * @since 1.0.0
 */
public class ResponseUtils {

    private static ObjectMapper om = new ObjectMapper();

    public static void jsonResponse(HttpServletRequest request, HttpServletResponse response, ResultVO result) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(om.writeValueAsString(result));
        out.flush();
        out.close();
    }

}
