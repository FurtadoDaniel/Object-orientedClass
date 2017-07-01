package Estacionamento;


public class Entrada extends Guarita {
	
    private int arrecadado = 0;
	
	private int numero;
	
    Entrada(int num){
		this.numero = num;
    }
	
    public void AbrirEntrada(){
        System.out.println("Entrada G" 
                + this.numero +
                " em funcionamento!");
        Aberta = true;
    }
	
    public void ReceberCarro(CarroGrande carro){
        
		if(Aberta){
			
			for (int i=0; i<3; i++ ){
				if (vagasCarroGrande [i] == null) {
                                    vagasCarroGrande [i] = carro;
					System.out.println(carro.getNome() + 
                        " entrando por G" 
                        + this.numero + 
                        "!");
			this.arrecadado += 5;
                        return;
			}
				
			}
			
			System.out.println("Nao ha mais vagas para carros grandes.");
        }
		
		else{
            System.out.println("Entrada fechada, tente outra!");
        }
    }
	
    public void ReceberCarro(CarroPequeno carro){
        
		if(Aberta){
			
			for (int i=0; i<5; i++ ){
				if (vagasCarroPequeno [i] == null) {
                                    vagasCarroPequeno [i] = carro;
					System.out.println(carro.getNome() + 
                        " entrando por G" 
                        + this.numero + 
                        "!");
                            this.arrecadado += 3;
                            return;
			}
				
			}
			
			System.out.println("Nao ha mais vagas para carros pequenoss.");
        }
		
		else{
            System.out.println("Entrada fechada, tente outra!");
        }
    }
	
    public void ReceberCarro(Moto carro){
        
		if(Aberta){
			
			for (int i=0; i<3; i++ ){
				if (vagasMoto [i] == null) {
                                        vagasMoto [i] = carro;
					System.out.println(carro.getNome() + 
                        " entrando por G" 
                        + this.numero + 
                        "!");
				this.arrecadado += 1;
                                return;
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
	
    public void FecharEntrada(){
        System.out.println("Fechando entrada G"
                + this.numero +
                " com total de " 
                + this.arrecadado +
                " reais.");
        Aberta = false;
    }
    
}
