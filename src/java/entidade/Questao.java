/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.util.List;

/**
 *
 * @author pepi
 */
public class Questao {
    private String pergunta;
    private String resposta;
    private List<String> alternativas;

    public Questao(String pergunta, String resposta, List<String> alternativas) {
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.alternativas = alternativas;
    }

    public Questao() {
    }

 
    
    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public List<String> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<String> alternativas) {
        this.alternativas = alternativas;
    }
    
    
}
