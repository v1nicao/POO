//Coloque a implementação do grupo aqui
package FabricaAbstrata.src;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TesteFabricaAbstrata {

    public static void main(String[] args) {
        
        Empresa empresa = new EmpresaOnibusUrbano();
        Calendar calendario = new GregorianCalendar(2023, Calendar.DECEMBER, 15, 15, 30);
        Passagem passagem = empresa.emitePassagem("São Paulo", "Campinas", calendario);
        passagem.exibeDetalhes();
        
        Calendar calendario2 = new GregorianCalendar(2023, Calendar.DECEMBER, 19, 20, 46);
        empresa = new EmpresaOnibusInterestadual();
        passagem = empresa.emitePassagem("Sao Paulo", "Rio de Janeiro", calendario2);
        passagem.exibeDetalhes();
        
    }
}
