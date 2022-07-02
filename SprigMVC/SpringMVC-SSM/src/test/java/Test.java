import com.wang.pojo.Books;
import com.wang.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.ws.Service;

public class Test {

    @org.junit.Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService service =  context.getBean("bookServiceImp", BookService.class);
        Books books = service.selectBooksById(1);
        System.out.println(books);
    }
}
