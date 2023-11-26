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
public class ManageFilesReader {

    ManageFiles manageFiles = new ManageFiles();
    public int tamanhoDoArray;
    public String[] arrayDoArquivo;

    public ManageFilesReader() {
    }

    public ManageFilesReader(int tamanhoDoArray, File arquivo) throws FileNotFoundException, IOException {
        
        FileReader fileReader = new FileReader(arquivo);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(arquivo));
        lineNumberReader.skip(arquivo.length());
        int qtdLinhas = lineNumberReader.getLineNumber() + 1;
        
        arrayDoArquivo = new String[qtdLinhas];

        for (int i = 0; i < qtdLinhas; i++) {
            arrayDoArquivo[i] = bufferedReader.readLine();
        }

        bufferedReader.close();
    }

    public String[] getArrayDoArquivo() {
        return arrayDoArquivo;
    }

    public void setArrayDoArquivo(String[] arrayDoArquivo) {
        this.arrayDoArquivo = arrayDoArquivo;
    }

    public int getTamanhoDoArray() {
        return tamanhoDoArray;
    }

    public void setTamanhoDoArray(int tamanhoDoArray) {
        this.tamanhoDoArray = tamanhoDoArray;
    }
}
