package filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
 
public final class RequestWrapper extends HttpServletRequestWrapper {
 
    public RequestWrapper(HttpServletRequest servletRequest) {
        super(servletRequest);
    }
 
    public String[] getParameterValues(String parameter) {
 
      String[] values = super.getParameterValues(parameter);
      if (values==null)  {
                  return null;
          }
      int count = values.length;
      String[] encodedValues = new String[count];
      for (int i = 0; i < count; i++) {
                 encodedValues[i] = cleanXSS(values[i]);
       }
      return encodedValues;
    }
 
    public String getParameter(String parameter) {
          String value = super.getParameter(parameter);
          if (value == null) {
                 return null;
                  }
          return cleanXSS(value);
    }
 
    public String getHeader(String name) {
        String value = super.getHeader(name);
        if (value == null)
            return null;
        return cleanXSS(value);
 
    }
 
    private String cleanXSS(String value) {
    	value = value.replaceAll("&", "&amp;");
		value = value.replaceAll("#", "&#35;");
		value = value.replaceAll(";", "&#59;");
		value = value.replaceAll("\\\\", "&#92;");
		value = value.replaceAll("<"  , "&lt;");
		value = value.replaceAll(">"  , "&gt;");
		value = value.replaceAll("\\(", "&#40;");
		value = value.replaceAll("\\)", "&#41;");
		value = value.replaceAll("'"  , "&#39;");
		value = value.replaceAll("\"", "&quot;");
		value = value.replaceAll("[$]", "&#36;");
		value = value.replaceAll("[*]", "&#42;");
		value = value.replaceAll("[+]", "&#43;");
		value = value.replaceAll("[|]", "&#124;");
		value = value.replaceAll("\\." , "&#46;");
		value = value.replaceAll("\\?" , "&#63;");
		value = value.replaceAll("\\[" , "&#91;");
		value = value.replaceAll("\\]" , "&#93;");
		value = value.replaceAll("\\^" , "&#94;");
		value = value.replaceAll("\\{" , "&#123;");
		value = value.replaceAll("\\}" , "&#125;");
		value = value.replaceAll("!", "&#33;");
		value = value.replaceAll("%", "&#37;");
		value = value.replaceAll(",", "&#44;");
		value = value.replaceAll("-", "&#45;");
		value = value.replaceAll("/", "&#47;");
		value = value.replaceAll(":", "&#58;");
		value = value.replaceAll("=", "&#61;");
		value = value.replaceAll("@", "&#64;");
		value = value.replaceAll("_", "&#95;");
		value = value.replaceAll("`", "&#96;");
		value = value.replaceAll("~", "&#126;");

        return value;
    }
}
