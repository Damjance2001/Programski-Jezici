package com.asss.pj.TuristickaAgencija;

import com.asss.pj.TuristickaAgencija.service.SpecijalnaPonudaServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class TuristickaAgencijaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TuristickaAgencijaApplication.class, args)
				.getBean(SpecijalnaPonudaServiceImpl.class) // uzimamo zrno od servisa;
				.threadForInitialization();
	}

}
