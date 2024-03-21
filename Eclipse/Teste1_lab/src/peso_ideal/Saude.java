package peso_ideal;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;




public class Saude {
	int idade; double altura; double peso;

public Saude(int idade, double altura,double peso) {
		this.idade = idade;
		this.altura = altura;
		this.peso = peso;
	}
	public double calculaIMC() {
return peso / (altura * altura);
}
public String condicaoFisica() {
if ( calculaIMC() < 18.5 )
	return "Abaixo do peso adequado";
else if ( calculaIMC() <= 24.9 )
return "Peso adequado";
return "Acima do peso adequado";
}
}