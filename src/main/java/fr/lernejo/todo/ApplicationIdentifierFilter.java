package fr.lernejo.todo;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.util.UUID;

@Component
public class ApplicationIdentifierFilter implements Filter {
    private final String uuidAsString;

    public ApplicationIdentifierFilter() {
        UUID uuid = UUID.randomUUID();
        this.uuidAsString = uuid.toString();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        // Créer une copie de la réponse pour éviter toute modification inattendue
        HttpServletResponse wrappedResponse = new HttpServletResponseWrapper(httpServletResponse) {
            @Override
            public void setHeader(String name, String value) {
                if (!"Instance-Id".equalsIgnoreCase(name)) {
                    super.setHeader(name, value);
                }
            }
        };

        wrappedResponse.setHeader("Instance-Id", this.uuidAsString);
        filterChain.doFilter(servletRequest, wrappedResponse);
    }
}

