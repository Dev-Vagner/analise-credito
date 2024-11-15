package br.com.vbruno.analisecredito;

import br.com.vbruno.analisecredito.service.analisecredito.AnaliseCreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnalisecreditoApplication {

	@Autowired
	private AnaliseCreditoService analiseCreditoService;

	public static void main(String[] args) {
		SpringApplication.run(AnalisecreditoApplication.class, args);
	}
}
