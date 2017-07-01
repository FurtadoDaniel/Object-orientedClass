package Estacionamento;
/**
 *
 * @author Barbara Moreira Drummond de Almeida
 */
public class Estacionamento {
	
    public static void main(String[] args) {
		
        //Instanciar 3 guaritas de entrada
		Entrada Entradas [3];
        Entradas[0] = new Entrada(1);
        Entradas[1] = new Entrada(2);
        Entradas[2] = new Entrada(3);
		
        //Instanciar guarita de saida
        Saida GS = new Saida();
		
        //Instanciar 4 carros grandes, com os nomes Doblo, Blazer, Corolla e S10
        CarroGrande Doblo = new CarroGrande("Doblo");
        CarroGrande Blazer = new CarroGrande("Blazer");
        CarroGrande Corolla = new CarroGrande("Corolla");
        CarroGrande S10 = new CarroGrande("S10");
		
        //Instanciar 3 carros pequenos, com os nomes Corsa, Palio e Fiesta
        CarroPequeno Corsa = new ("Corsa");
        CarroPequeno Palio = new CarroPequeno("Palio");
        CarroPequeno Fiesta = new CarroPequeno("Fiesta");
		
        //Instanciar 2 motos, com os nomes Honda e Suzuki
        Moto Honda = new Moto("Honda");
        Moto Suzuki = new Moto("Suzuki");
        
		
        //Abrir as entradas G1 e G2
        Entradas[0].AbrirEntrada();
        Entradas[1].AbrirEntrada();
		
        //Abrir a saida
        GS.AbrirSaida();
		
        //Receber Doblo por G1
        Entradas[0].ReceberCarroGrande(Doblo.nome);
		
        //Receber Blazer por G2
        Entradas[1].ReceberCarroGrande(Blazer.nome);
		
        //Receber Corsa por G1
        Entradas[0].ReceberCarroPequeno(Corsa.nome);
		
        //Receber Palio por G1
        Entradas[0].ReceberCarroPequeno(Palio.nome);
    }
}
