package mate.academy;

import javax.naming.AuthenticationException;
import mate.academy.dao.impl.UserDaoImpl;
import mate.academy.service.AuthenticationService;
import mate.academy.service.impl.AuthenticationServiceImpl;

public class Main {
    public static void main(String[] args) throws AuthenticationException {
        UserDaoImpl userDao = new UserDaoImpl();
        AuthenticationService authenticationService = new AuthenticationServiceImpl(userDao);
        authenticationService.login("bob", "1234");

        /*

        Product iphone = new Product();
        iphone.setName("iphone 7");
        iphone.setPrice(BigDecimal.valueOf(499));

        Product samsung = new Product();
        samsung.setName("Samsung S20");
        samsung.setPrice(BigDecimal.valueOf(695));

        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(mate.academy.config.AppConfig.class);
        ProductService productService = context.getBean(ProductService.class);

        productService.save(iphone);
        productService.save(samsung);

        System.out.println(productService.findall());

         */

        // Login password

        //FB
    }
}










