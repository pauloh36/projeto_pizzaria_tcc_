/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConfiguracaoBanco.FILE;

import java.io.*;

/**
 *
 * @author Jaime
 */
public class ManageFilesWriter {

    FileWriter fileWriter;
    BufferedWriter bufferedWriter;

   

    public void setArquivoDeConf(File arquivo, String server, String door, String dataBase, String user, String password) throws IOException {
       
        fileWriter = new FileWriter(arquivo);
        bufferedWriter = new BufferedWriter(fileWriter);
        
        bufferedWriter.write(server);
        bufferedWriter.newLine();
        bufferedWriter.write(door);
        bufferedWriter.newLine();
        bufferedWriter.write(dataBase);
        bufferedWriter.newLine();
        bufferedWriter.write(user);
        bufferedWriter.newLine();
        bufferedWriter.write(password);
        
        bufferedWriter.close();
    }
}
