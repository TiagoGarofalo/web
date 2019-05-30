package controle;


import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pepi
 */
@ManagedBean (name = "calculadoraC")
public class CalculadoraControle implements Serializable{
    
    private Double numero1;
    private Double numero2;
    private String total;
    
    //getters e setters
    
    public void multiplicar(){
    
    total = numero1 + " * " + numero2 + " = " + (numero1*numero2);
    limparCampo();
    }
    
    public void dividir(){
    
        if(numero2 == 0){
            
            total = "Impossível dividir por zero";
            FacesContext.getCurrentInstance().addMessage("mens", new FacesMessage(FacesMessage.SEVERITY_WARN, total, null));
        }else{
            
         total = numero1 + " / " + numero2 + " = " + (numero1/numero2);
        }
   
    limparCampo();
    }
    
    public void somar(){
    
    total = numero1 + " + " + numero2 + " = " + (numero1+numero2);
    limparCampo();
    }
    
    public void subtrair(){
    
    total = numero1 + " - " + numero2 + " = " + (numero1-numero2);
    limparCampo();
    }
    
    private void limparCampo(){
    
    numero1 = null;
    numero2 = null;
    }

    public Double getNumero1() {
        return numero1;
    }

    public void setNumero1(Double numero1) {
        this.numero1 = numero1;
    }

    public Double getNumero2() {
        return numero2;
    }

    public void setNumero2(Double numero2) {
        this.numero2 = numero2;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    
  
    
    
}
