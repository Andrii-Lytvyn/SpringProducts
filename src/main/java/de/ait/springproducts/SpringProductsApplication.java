package de.ait.springproducts;

import de.ait.springproducts.config.ApplicationConfig;
import de.ait.springproducts.services.ProductsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//@SpringBootApplication
public class SpringProductsApplication {

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ProductsService productsService = context.getBean(ProductsService.class);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("1. Add new good");
            System.out.println("2. Select all goods");
            System.out.println("0. Exit");
            int command = Integer.parseInt(br.readLine());

            switch (command) {
                case 1 -> {
                    System.out.print("Enter new product: ");
                    String title = br.readLine();
                    System.out.print("Enter new barcode: ");
                    String barcode = br.readLine();

                    productsService.addProduct(title, barcode);
                }
                case 2 -> System.out.println(productsService.getAllProducts());
                case 0 -> System.exit(0);
            }
        }
    }
}
