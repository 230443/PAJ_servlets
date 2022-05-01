package be.pxl.paj.servlets;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@WebFilter(urlPatterns = { "/SelectBeer.do" })
public class HeaderLogFilter implements Filter {

	private static final Logger LOGGER = LogManager.getLogger(HeaderLogFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
	                     FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rep = (HttpServletResponse) response;

		LOGGER.info("----- Request ---------");
		Collections.list(req.getHeaderNames()).forEach(n -> LOGGER.info(n + ": " + req.getHeader(n)));

		chain.doFilter(request, response);

		LOGGER.info("----- response ---------");

		rep.getHeaderNames().forEach(n -> LOGGER.info(n + ": " + rep.getHeader(n)));

		LOGGER.info("response status: " + rep.getStatus());
	}
}
