package com.oxyl.coursepfback.config;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*") // Ce filtre sera appliqué à toutes les requêtes
public class CorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialisation si nécessaire (par exemple, récupérer des configurations)
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // Convertir les objets de request et response en objets HttpServlet
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Ajouter les en-têtes CORS
        httpResponse.setHeader("Access-Control-Allow-Origin", "*"); // Remplacez "*" par un domaine spécifique si nécessaire
        httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, X-Requested-With");

        // Si la requête est une requête OPTIONS (pré-demande CORS), on répond immédiatement avec les en-têtes CORS
        if ("OPTIONS".equalsIgnoreCase(httpRequest.getMethod())) {
            httpResponse.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        // Passer la requête au filtre suivant dans la chaîne
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Libération des ressources si nécessaire
    }
}
