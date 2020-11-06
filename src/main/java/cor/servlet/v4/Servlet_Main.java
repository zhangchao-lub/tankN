package cor.servlet.v4;


import java.util.ArrayList;
import java.util.List;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/11/3 11:59
 * @descrption 完全模拟Servlet中的FilterChain
 */
public class Servlet_Main {
    public static void main(String[] args) {
        Request request = new Request();
        Response response = new Response();
        request.str = "大家好:),<script>，欢迎访问 mashibing.com ,大家都是996";
        response.str = "response";

        FilterChain filterChain = new FilterChain();
        filterChain.add(new HTMLFilter()).add(new SensitiveFilter());
        filterChain.doFilter(request, response);
        System.out.println(request.str);
        System.out.println(response.str);
    }
}

interface Filter {
    void doFilter(Request request, Response response, FilterChain filterChain);
}

class Request {
    String str;
}

class Response {
    String str;
}

class HTMLFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.str = request.str.replaceAll("<", "[").replaceAll(">", "]") + "--HTMLFilter()";
        filterChain.doFilter(request, response);
        response.str += "--HTMLFilter()";
    }
}

class SensitiveFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.str = request.str.replaceAll("996", "995") + "--SensitiveFilter()";
        filterChain.doFilter(request, response);
        response.str += "--SensitiveFilter()";
    }
}

class FilterChain {
    List<Filter> filters = new ArrayList<>();
    int index = 0;

    public FilterChain add(Filter f) {
        filters.add(f);
        return this;
    }

    public void doFilter(Request request, Response response) {
        if (index == filters.size()) {
            return;
        } else {
            index++;
            filters.get(index-1).doFilter(request, response, this);
        }
    }
}