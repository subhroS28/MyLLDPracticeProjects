package org.subhro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.subhro.util.CommandMapperAndReader;

import java.io.FileInputStream;
import java.util.Scanner;

@SpringBootApplication
public class SubscriptionAppApplication {

	public static void main(String[] args) throws Exception {
//		SpringApplication.run(SubscriptionAppApplication.class, args);
		FileInputStream fis = new FileInputStream(args[0]);
		try {
			CommandMapperAndReader.executeCommands(new Scanner(fis));
		} catch (Exception e){
			throw new Exception(e.getMessage());
		}finally {
			fis.close();
		}
	}

}
