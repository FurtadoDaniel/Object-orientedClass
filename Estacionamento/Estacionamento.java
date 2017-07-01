package Estacionamento;


public class Estacionamento {
	
    public static void main(String[] args) {
		
        //Instanciar 3 guaritas de entrada
        Entrada [] Entradas = new Entrada[3];
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
        CarroPequeno Corsa = new CarroPequeno("Corsa");
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
        Entradas[0].ReceberCarro(Doblo);
		
        //Receber Blazer por G2
        Entradas[1].ReceberCarro(Blazer);
		
        //Receber Corsa por G1
        Entradas[0].ReceberCarro(Corsa);
		
        //Receber Palio por G1
        Entradas[0].ReceberCarro(Palio);
        
        //Abrir a entrada G3.
        Entradas[2].AbrirEntrada();
        
        //Receber Corolla por G3.
        Entradas[2].ReceberCarro(Corolla);
        
        //Liberar Corsa.
        GS.LiberarCarro(Corsa);
        
        //S10 tenta entrar por G3.
        Entradas[2].ReceberCarro(S10);
        
        //Receber Honda por G2.
        Entradas[1].ReceberCarro(Honda);
        
        //Liberar Corolla.
        GS.LiberarCarro(Corolla);
        
        //Liberar Pálio.
        GS.LiberarCarro(Palio);
        
        //Fechar as entradas G2 e G3.
        Entradas[1].FecharEntrada();
        Entradas[2].FecharEntrada();
        
        //Tentar fechar a saída.
        GS.FecharSaida(Entradas);
        
        //Fechar a entrada G1.
        Entradas[0].FecharEntrada();
        
        //Fechar a saída
        GS.FecharSaida(Entradas);
    }
}
