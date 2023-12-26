package com.rviewer.skeletons;

import com.rviewer.skeletons.ewok.menu.EWokApp;
import com.rviewer.skeletons.ewok.menu.EWokMenu;
import com.rviewer.skeletons.ewok.menu.EwokOrder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.rviewer.skeletons"})
public class RviewerSkeletonApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(RviewerSkeletonApplication.class, args);
		EwokOrder ewokOrder = context.getBean(EwokOrder.class);
		ewokOrder.placeOrder();
	}
}
