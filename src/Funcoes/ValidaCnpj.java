package Funcoes;

import java.util.InputMismatchException;
import javax.swing.JOptionPane;
import org.alfredlibrary.AlfredException;
import org.alfredlibrary.utilitarios.texto.Texto;

public class ValidaCnpj {

public static String formatar(String cnpj) {
    
    
		StringBuilder s = new StringBuilder();
		String soNumeros = Texto.manterNumeros(cnpj);
		if (soNumeros.length() != 14)
			throw new AlfredException("Informe um CNPJ valido. Este CNPJ possui apenas " + soNumeros.length() + " nÃºmeros. Um CNPJ vÃ¡lido deve conter 15.");
		s.append(soNumeros.substring(0, 2));
		s.append(".");
		s.append(soNumeros.substring(2, 5));
		s.append(".");
		s.append(soNumeros.substring(5, 8));
		s.append("/");
		s.append(soNumeros.substring(8, 12));
		s.append("-");
		s.append(soNumeros.substring(12, 14));
		return s.toString();
                
	}
        
}


