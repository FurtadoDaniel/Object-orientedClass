package Estacionamento;


public class Entrada extends Guarita {
	
    private int arrecadado = 0;
	
	private int numero
	
	
    void AbrirEntrada(){
        System.out.println("Entrada G" 
                + i +
                " em funcionamento!");
        EntradasAbertas++;
        Aberta = true;
    }
	
    void ReceberCarro(CarroGrande carro){
        
		if(Aberta){
			
			for (int i=0; i<3; i++ ){
				if (vagasCarroGrande [i] == null) {
					System.out.println(carro.getNome() + 
                        " entrando por G" 
                        + this.number + 
                        "!");
				this.arrecadado += 5;
				}
				
			}
			
			System.out.println("Nao ha mais vagas para carros grandes.");
        }
		
		else{
            System.out.println("Entrada fechada, tente outra!");
        }
    }
	
    void ReceberCarro(CarroPequeno carro){
        
		if(Aberta){
			
			for (int i=0; i<5; i++ ){
				if (vagasCarroPequeno [i] == null) {
					System.out.println(carro.getNome() + 
                        " entrando por G" 
                        + this.number + 
                        "!");
				this.arrecadado += 3;
				}
				
			}
			
			System.out.println("Nao ha mais vagas para carros pequenoss.");
        }
		
		else{
            System.out.println("Entrada fechada, tente outra!");
        }
    }
	
    void ReceberCarro(Moto carro){
        
		if(Aberta){
			
			for (int i=0; i<3; i++ ){
				if (vagasMoto [i] == null) {
					System.out.println(carro.getNome() + 
                        " entrando por G" 
                        + this.number + 
                        "!");
				this.arrecadado += 1;
				}
				
			}
			
			System.out.println("Nao ha mais vagas para motos.");
        }
		
		else{
            System.out.println("Entrada fechada, tente outra!");
        }
    }
	
	int getArrecadado () {
		return this.arrecadado;
	}
	
    void FecharEntrada(){
        System.out.println("Fechando entrada G"
                + this.number +
                " com total de " 
                + this.arrecadado +
                " reais.");
        Aberta = false;
    }
    
}
