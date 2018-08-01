package control;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Conta;

public class Teste {

	public static void main(String[] args) throws IOException {
		
		Conta c = new Conta("Fulano", "343424","BANCO", "PERTO", 1000.00);
		
		String arquivo = "text.txt";
		
		//	Codigo Serializado
		try {
			FileOutputStream fileOut = new FileOutputStream(arquivo);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(c);
            out.close();
            fileOut.close();
		}catch(IOException i) {
			i.printStackTrace();
		}
		
		//	De-Serializando Codigo
		Conta desceliarizada = null;
		try
        {
            FileInputStream fileIn = new FileInputStream(arquivo);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            desceliarizada = (Conta) in.readObject();
            in.close();
            fileIn.close();
 
            System.out.println(desceliarizada.toString());
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        catch (ClassNotFoundException cnfe)
        {
            cnfe.printStackTrace();
        }
		
	}

}
