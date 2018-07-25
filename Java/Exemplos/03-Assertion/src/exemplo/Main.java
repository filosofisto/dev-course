package exemplo;

public class Main {

	private static final Integer QUILOMETROS_POR_SEGUNDO = 0;
    private static final Integer METROS_POR_SEGUNDO = 1;
    private static final Integer VELOCIDADE_LUZ = 300000;
    
	public static void main(String[] args) {
		//Em KM/s
        Integer velocidadeParticula = retornarVelocidadeParticula(12, QUILOMETROS_POR_SEGUNDO);
        
        assert(velocidadeParticula < VELOCIDADE_LUZ) : "Velocidade da particula não pode ser maior que a velocidade da luz";
        
        /*try{
            if (velocidadeParticula > VELOCIDADE_LUZ)            
                throw new Exception("Velocidade da Particula não pode ser maior que a velocidade da Luz");  
         
        } catch(Exception e) {
            e.printStackTrace();
        }*/
        
        
	}

	private static Integer retornarVelocidadeParticula(int i, Integer quilometrosPorSegundo) {
		return VELOCIDADE_LUZ-1;
	}
}
