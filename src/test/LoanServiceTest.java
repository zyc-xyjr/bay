import com.Application;
import com.demo.entity.Loan;
import com.demo.service.LoanService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringApplicationConfiguration(classes = Application.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration
public class LoanServiceTest {
    @Resource
    private LoanService loanService;

    @org.junit.Test
    public void testFindAll() throws Exception {
       Page<Loan> loen=loanService.findAll(new PageRequest(0,10));
        System.out.println("+++++++++");
    }
}