/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import entidade.Jogador;
import entidade.Questao;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author pepi
 */
@ManagedBean(name = "jogoC")
@SessionScoped
public class JogoControle {

    private Jogador jogador;
    private List<Questao> questaos;
    private Questao questao;

    private String alt1;
    private String alt2;

    public JogoControle() {
        questao = new Questao();
        questaos = new LinkedList<>();
    }

    public void salvarQuestao() {

        questao.setAlternativas(new ArrayList<>());
        questao.getAlternativas().add(alt1);
        questao.getAlternativas().add(alt2);

        questaos.add(questao);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "salvo com suceso", ""));

        limpar();
    }

    private void limpar() {

        questao = new Questao();
        alt1 = null;
        alt2 = null;
    }

    public String getAlt1() {
        return alt1;
    }

    public void setAlt1(String alt1) {
        this.alt1 = alt1;
    }

    public String getAlt2() {
        return alt2;
    }

    public void setAlt2(String alt2) {
        this.alt2 = alt2;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Questao getQuestao() {
       
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

}
