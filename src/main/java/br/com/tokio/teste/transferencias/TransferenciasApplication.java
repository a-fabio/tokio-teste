package br.com.tokio.teste.transferencias;

import br.com.tokio.teste.transferencias.model.Taxa;
import br.com.tokio.teste.transferencias.repository.TaxaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TransferenciasApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TransferenciasApplication.class, args);
	}

	@Autowired
	private TaxaRepository taxaRepository;

	@Override
	public void run(String... args) throws Exception {
		List<Taxa> taxasPredefinidas = new ArrayList<>();

		taxasPredefinidas.add(new Taxa(null,0,0,new BigDecimal(3),2.5,Boolean.TRUE));
		taxasPredefinidas.add(new Taxa(null,1,10,new BigDecimal(12),0.0,Boolean.TRUE));
		taxasPredefinidas.add(new Taxa(null,11,20,new BigDecimal(0),8.2,Boolean.TRUE));
		taxasPredefinidas.add(new Taxa(null,21,30,new BigDecimal(0),6.9,Boolean.TRUE));
		taxasPredefinidas.add(new Taxa(null,31,40,new BigDecimal(0),4.7,Boolean.TRUE));
		taxasPredefinidas.add(new Taxa(null,41,50,new BigDecimal(0),1.7,Boolean.TRUE));

		taxasPredefinidas.forEach(taxaRepository::save);
	}
}
