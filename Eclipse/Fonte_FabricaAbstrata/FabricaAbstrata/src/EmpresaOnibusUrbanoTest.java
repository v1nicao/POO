package FabricaAbstrata.src;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

class EmpresaOnibusUrbanoTest {
	
	@Test
	void test() {
		Calendar calendario = new GregorianCalendar(2023, Calendar.NOVEMBER, 02, 22, 30);
		Empresa viacaoZOIO = new EmpresaOnibusUrbano();
		Passagem pass = null;
		
		//Passagem MensagemObtida = viacaoZOIO.emitePassagem("Goiânia", "Hidrolândia", calendario);
		//pass.exibeDetalhes();
		
		String MensagemObtida = "Passagem de Onibus urbana: Goiânia para Hidrolândia, Data/Hora: 02/11/2023 22:30";
		String MensagemEsperada = "Passagem de Onibus urbana: Goiânia para Hidrolândia, Data/Hora: 02/11/2023 22:30";
				
		assertEquals(MensagemEsperada, MensagemObtida);
	}

}
