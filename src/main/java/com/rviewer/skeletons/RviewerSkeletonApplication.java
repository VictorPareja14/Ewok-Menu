package com.rviewer.skeletons;

import com.rviewer.skeletons.ewok.menu.EWokApp;
import com.rviewer.skeletons.ewok.menu.EWokMenu;
import com.rviewer.skeletons.ewok.menu.EwokOrder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RviewerSkeletonApplication {

	public static void main(String[] args) {
		SpringApplication.run(RviewerSkeletonApplication.class, args);
	}
}
