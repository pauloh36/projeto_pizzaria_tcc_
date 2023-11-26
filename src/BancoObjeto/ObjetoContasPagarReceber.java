/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BancoObjeto;

/**
 *
 * @author Paulo
 */
public class ObjetoContasPagarReceber {
    
    private String PeencheCombo;

    /**
     * @return the PeencheCombo
     */
    public String getPeencheCombo() {
        return PeencheCombo;
    }

    /**
     * @param PeencheCombo the PeencheCombo to set
     */
    public void setPeencheCombo(String PeencheCombo) {
        this.PeencheCombo = PeencheCombo;
    }
    
    
    public String toString() {  
        return getPeencheCombo();      
    }  
    
}
