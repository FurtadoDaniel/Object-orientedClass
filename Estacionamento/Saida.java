package Estacionamento;


public class Saida extends Guarita {
	
    Saida(){
    }
	
    void AbrirSaida(){
		this.Aberta = true;
        System.out.println("Saida aberta!");
    }
	
    void LiberarCarro(CarroGrande carro){
		
		if(Aberta){
			
			for (int i=0; i<3; i++){
                            if (vagasCarroGrande[i] != null)
				if (vagasCarroGrande[i].getNome() == carro.getNome()) {
					vagasCarroGrande[i] = null;
					System.out.println(carro.getNome() + 
                        " saindo!");
                                return;
				}
			}
			
			System.out.println("O carro não se encontra no estacionamento.");
        }
		
		else{
            System.out.println("Entrada fechada, tente outra!");
        }
    }
	
	void LiberarCarro(CarroPequeno carro){
		
		if(Aberta){
			
			for (int i=0; i<5; i++ ){
                            if (vagasCarroPequeno[i] != null) 
				if (vagasCarroPequeno[i].getNome() == carro.getNome()) {
					vagasCarroPequeno [i] = null;
					System.out.println(carro.getNome() + 
                        " saindo!");
                                return;
				}
			}
			
			System.out.println("O carro não se encontra no estacionamento.");
        }
		
		else{
            System.out.println("Entrada fechada, tente outra!");
        }
    }
	
	void LiberarCarro(Moto carro){
		
		if(Aberta){
			
			for (int i=0; i<3; i++ ){
                            if (vagasMoto[i] != null)
				if (vagasMoto [i].getNome() == carro.getNome()) {
					vagasMoto [i] = null;
					System.out.println(carro.getNome() + 
                        " saindo!");
                                        return;
				}
			}
			
			System.out.println("O carro não se encontra no estacionamento.");
        }
		
		else{
            System.out.println("Entrada fechada, tente outra!");
        }
    }
	
    void FecharSaida(Entrada [] guaritas){
		
		int total = 0;
		boolean todas = false;
		
		for (Entrada entrada : guaritas) {
			total += entrada.getArrecadado();
			todas = todas || entrada.Aberta;
		}
		
        if (!todas){
            System.out.println("Estacionamento fechado! Total do dia: "+ total +" reais.");
        }else{
            System.out.println("Erro ao fechar saida: verifique se ha alguma entrada em funcionamento.");
        }
    }
}
