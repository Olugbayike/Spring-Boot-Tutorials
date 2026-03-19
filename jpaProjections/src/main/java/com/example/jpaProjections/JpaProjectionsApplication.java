package com.example.jpaProjections;

import com.example.entity.SalesOrder;
import com.example.repositories.SalesOrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@EntityScan(basePackages = "com.example.entity")
@EnableJpaRepositories(basePackages = "com.example.repositories")
@SpringBootApplication
public class JpaProjectionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaProjectionsApplication.class, args);
	}

}

@Component
class Runner implements CommandLineRunner {

    private final SalesOrderRepository salesOrderRepository;

    Runner(SalesOrderRepository salesOrderRepository) {
        this.salesOrderRepository = salesOrderRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        salesOrderRepository.saveAll(List.of(
                    new SalesOrder("Company 1", 2000),
                    new SalesOrder("Company 2", 1845),
                    new SalesOrder("Company 1", 200),
                    new SalesOrder("Company 3", 4961),
                    new SalesOrder("Company 1", 5000)
                )
        );

        salesOrderRepository.getScalarProjections().forEach(arr -> System.out.println(Arrays.toString(arr)));

        System.out.println("--------------------------------------------------------------------------------------------------------");

        salesOrderRepository.getDtoProjections().forEach(System.out::println);
    }
}
