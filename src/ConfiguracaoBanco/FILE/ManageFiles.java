/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConfiguracaoBanco.FILE;

import java.io.File;

public class ManageFiles {
    
    
    
    String caminho = System.getProperty("user.dir")+"\\conf.ini";
    public File arquivoDeConf = new File(caminho);

    public File getArquivoDeConf() {
        return arquivoDeConf;
    }
    
}
