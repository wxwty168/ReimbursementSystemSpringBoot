import com.jxd.reimbursementsystem.MPApplication;
import com.jxd.reimbursementsystem.model.Employees;
import com.jxd.reimbursementsystem.service.ILoginService;
import com.jxd.reimbursementsystem.service.ITicketsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/3/13 13:12
 */
// 用谁作为启动器去启动
@RunWith(SpringRunner.class)
// 读取主程序的配置（加载容器及组件）
@SpringBootTest(classes = MPApplication.class)
public class TestDao {
    @Resource
    private ILoginService loginService;

    @Resource
    private ITicketsService ticketsService;
    // 测试方法，三无（无参数，无返回值，无静态）
    @Test
    public void testEmp(){
        Employees employee = new Employees();
        employee.setEno(10000);
        employee.setPassword("123");
        System.out.println(employee.getEno());
        String outPut = loginService.doLogin(employee).toString();
        System.out.println(outPut);

    }

    @Test
    public void testGetTickets(){
        //获取文件在服务器的储存位置
        String property = System.getProperty("user.dir");
        String path = property + "/src/main/resources/static/uploadImg";
//        String path = "G://idea//test//src//main//resources//static//uploadImg";
        System.out.println(path);
        File filePath = new File(path);
        if (!filePath.exists() && !filePath.isDirectory()) {
            System.out.println(1);
            filePath.mkdir();
        }
    }
}