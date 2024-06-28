package br.com.tokio.teste.transferencias;

import br.com.tokio.teste.transferencias.enumerator.StatusTaxa;
import br.com.tokio.teste.transferencias.model.Taxa;
import br.com.tokio.teste.transferencias.repository.TaxaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class TransferenciasApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TransferenciasApplication.class, args);
	}

	@Autowired
	private TaxaRepository taxaRepository;

	@Override
	public void run(String... args) throws Exception {
		List<Taxa> taxasPredefinidas = new ArrayList<>();

		taxasPredefinidas.add(new Taxa(null,0L,0L,new BigDecimal(3),2.5, StatusTaxa.ATIVA));
		taxasPredefinidas.add(new Taxa(null,1L,10L,new BigDecimal(12),0.0,StatusTaxa.ATIVA));
		taxasPredefinidas.add(new Taxa(null,11L,20L,new BigDecimal(0),8.2,StatusTaxa.ATIVA));
		taxasPredefinidas.add(new Taxa(null,21L,30L,new BigDecimal(0),6.9,StatusTaxa.ATIVA));
		taxasPredefinidas.add(new Taxa(null,31L,40L,new BigDecimal(0),4.7,StatusTaxa.ATIVA));
		taxasPredefinidas.add(new Taxa(null,41L,50L,new BigDecimal(0),1.7,StatusTaxa.ATIVA));

        taxaRepository.saveAll(taxasPredefinidas);
	}
}
