package lguplus.security.vulner;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class HttpRequestWithModifiableParameters extends HttpServletRequestWrapper
{
  HashMap params;

  public HttpRequestWithModifiableParameters(HttpServletRequest request)
  {
    super(request);
    this.params = new HashMap(request.getParameterMap());
  }

  public String getParameter(String name)
  {
    String returnValue = null;
    String[] paramArray = getParameterValues(name);
    if ((paramArray != null) && (paramArray.length > 0)) {
      returnValue = paramArray[0];
    }
    return returnValue;
  }

  public Map getParameterMap()
  {
    return Collections.unmodifiableMap(this.params);
  }

  public Enumeration getParameterNames()
  {
    return Collections.enumeration(this.params.keySet());
  }

  public String[] getParameterValues(String name)
  {
    String[] result = null;
    String[] temp = (String[])this.params.get(name);
    if (temp != null) {
      result = new String[temp.length];
      System.arraycopy(temp, 0, result, 0, temp.length);
    }
    return result;
  }

  public void setParameter(String name, String value)
  {
    String[] oneParam = { value };
    setParameter(name, oneParam);
  }

  public void setParameter(String name, String[] values)
  {
    this.params.put(name, values);
  }
}