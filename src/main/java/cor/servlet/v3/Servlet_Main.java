package cor.servlet.v3;


import java.util.ArrayList;
import java.util.List;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/11/3 11:59
 * @descrption 在filterChain中处理加入位置的记录
 *             同时在filter中加入第三个参数
 */
public class Servlet_Main {
    public static void main(String[] args) {
        Request request = new Request();
        Response response = new Response();
        request.str = "大家好:),<script>，欢迎访问 mashibing.com ,大家都是996";
        response.str = "response";

        FilterChain filterChain = new FilterChain();
        filterChain.add(new HTMLFilter()).add(new SensitiveFilter());
        filterChain.doFilter(request, response, filterChain);
        System.out.println(request.str);
        System.out.println(response.str);
    }
}

interface Filter {
    boolean doFilter(Request request, Response response, FilterChain filterChain);
}

class Request {
    String str;
}

class Response {
    String str;
}

class HTMLFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        request.str = request.str.replaceAll("<", "[").replaceAll(">", "]") + "--HTMLFilter()";
        filterChain.doFilter(request, response, filterChain);
        response.str += "--HTMLFilter()";
        return true;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        request.str = request.str.replaceAll("996", "995") + "--SensitiveFilter()";
        filterChain.doFilter(request, response, filterChain);
        response.str += "--SensitiveFilter()";
        return true;
    }
}

class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>();
    int index = 0;

    public FilterChain add(Filter f) {
        filters.add(f);
        return this;
    }

    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        if (index == filters.size()) {
            return false;
        } else {
            index++;
            return filters.get(index-1).doFilter(request, response, filterChain);
        }
    }
}