package lguplus.security.vulner;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class FilterServlet
  implements Filter
{
  private FilterConfig filterConfig;

  public void init(FilterConfig config)
    throws ServletException
  {
    this.filterConfig = config;
  }

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws ServletException, IOException
  {
    HttpServletRequest f_request = new HttpServletRequestWrapper((HttpServletRequest)request);
    Enumeration e = f_request.getParameterNames();

    HttpRequestWithModifiableParameters param = 
      new HttpRequestWithModifiableParameters(f_request);

    while (e.hasMoreElements())
    {
      String key = (String)e.nextElement();
      String[] values = request.getParameterValues(key);
      for (int idx = 0; idx < values.length; ++idx) {
        try {
        System.out.println("before values[idx] : " + values[idx]);
          values[idx] = SecurityModule.VulnerabilityChek(
            values[idx], 
            1, 
            "common", 
        	"xss|sqlinjection|fileup_block|filedown");
          System.out.println("after values[idx] : " + values[idx]);
          param.setParameter(key, values[idx]);
        }
        catch (Exception localException)
        {
        	System.out.println("doFilter localException : " + localException.toString());
        }
      }
    }
    request = param;
    chain.doFilter(request, response);
  }

  public void destroy()
  {
  }
}