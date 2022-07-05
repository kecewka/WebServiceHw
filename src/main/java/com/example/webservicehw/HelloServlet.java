package com.example.webservicehw;

import java.io.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.json.simple.JSONArray;

import static java.util.stream.Collectors.joining;


@WebServlet(name = "helloServlet", urlPatterns = {"/organizations/*"})
public class HelloServlet extends HttpServlet {
    private static final Gson GSON = new GsonBuilder().create();


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");

        JSONArray jsonArray = new JSONArray();
        for (Organization o : Organizations.orgs.values()) {
            jsonArray.add(o);
        }
        String answer = GSON.toJson(jsonArray);

        response.getOutputStream().println(answer);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = readInputSteam(req.getInputStream());

        Organization org = GSON.fromJson(json, Organization.class);

        if (!checkId(Organizations.orgs.size() + 1L)) {
            org.setId(Organizations.orgs.size() + 1L);
        }
        org.setId(Organizations.orgs.size() + 2L);

        Organizations.orgs.put(org.getId(), org);

        resp.setHeader("Content-Type", "application/json");
        resp.getOutputStream().println(GSON.toJson(org));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        Long id = Long.parseLong(uri.substring(uri.length() - 1));

        Organization org = Organizations.orgs.remove(id);
        String json = GSON.toJson(org);

        resp.setHeader("Content-Type", "application/json");
        resp.getOutputStream().println(json);
    }

    public static String readInputSteam(InputStream stream) {
        return new BufferedReader(new InputStreamReader(stream)).lines().collect(joining("\n"));
    }

    public static boolean checkId(Long id) {
        if (Organizations.orgs.containsKey(id)) {
            return true;
        }
        return false;
    }
}