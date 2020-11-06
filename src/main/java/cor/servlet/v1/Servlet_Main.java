package cor.servlet.v1;


import java.util.ArrayList;
import java.util.List;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/11/3 11:59
 * @descrption 责任链模式处理response
 */
public class Servlet_Main {
    public static void main(String[] args) {
        Request request=new Request();
        Response response=new Response();
        request.str="大家好:),<script>，欢迎访问 mashibing.com ,大家都是996";
        response.str="";

        FilterChain filterChain=new FilterChain();
        filterChain.add(new HTMLFilter()).add(new SensitiveFilter());
        filterChain.doFilter(request,response);
        System.out.println(request.str);
        System.out.println(response.str);
    }
}
interface Filter{
    boolean doFilter(Request request,Response response);
}
class Request{
    String str;
}
class Response{
    String str;
}
class HTMLFilter implements Filter{
    @Override
    public boolean doFilter(Request request,Response response) {
        request.str=request.str.replaceAll("<","[").replaceAll(">","]");
        return true;
    }
}
class SensitiveFilter implements Filter{

    @Override
    public boolean doFilter(Request request, Response response) {
        request.str=request.str.replaceAll("996","995");
        return true;
    }
}
class FilterChain implements Filter{
    List<Filter> filters=new ArrayList<>();

    public FilterChain add(Filter f){
        filters.add(f);
        return this;
    }

    @Override
    public boolean doFilter(Request request, Response response) {
        for(Filter f:filters){
            f.doFilter(request,response);
        }
        return false;
    }
}