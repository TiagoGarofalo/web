/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import entidade.Cliente;
import java.util.InputMismatchException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author pepi
 */
@ManagedBean(name = "clienteC")
public class ClienteControle {

    private Cliente cliente;

    public String salvar() {

        return "mostrarCliente";
    }

    public void validarCpf() {
        FacesContext contexto = FacesContext.getCurrentInstance();

        String cpf = cliente.getCpf();
        if (verificarNumerosIgualTela(cpf)) {
            contexto.addMessage(null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            "CPF Inválido!", "Erro!"));
        } else {

            char dig10, dig11;
            int sm, i, r, num, peso;

            try {
// Calculo do 1o. Digito Verificador
                cpf = cpf.replace(".", "");
                System.out.println(cpf);
                cpf = cpf.replace("-", "");
                System.out.println(cpf);

                sm = 0;
                peso = 10;
                for (i = 0; i < 9; i++) {
                    num = (int) (cpf.charAt(i) - 48);
                    sm = sm + (num * peso);
                    peso = peso - 1;
                }

                r = 11 - (sm % 11);
                if ((r == 10) || (r == 11)) {
                    dig10 = '0';
                } else {
                    dig10 = (char) (r + 48); // converte no respectivo caractere numerico
                }
// Calculo do 2o. Digito Verificador
                sm = 0;
                peso = 11;
                for (i = 0; i < 10; i++) {
                    num = (int) (cpf.charAt(i) - 48);
                    sm = sm + (num * peso);
                    peso = peso - 1;
                }

                r = 11 - (sm % 11);
                if ((r == 10) || (r == 11)) {
                    dig11 = '0';
                } else {
                    dig11 = (char) (r + 48);
                }

// Verifica se os digitos calculados conferem com os digitos informados.
                if ((dig10 != cpf.charAt(9)) || (dig11 != cpf.charAt(10))) {
                    contexto.addMessage(null, new FacesMessage(
                            FacesMessage.SEVERITY_ERROR, "CPF Inválido!", "Erro!"));
                }
            } catch (InputMismatchException erro) {
                System.out.println("Erro na validação do CPF " + erro.getMessage());
            }

        }
    }

    private boolean verificarNumerosIgualTela(String cpf) {
        if (cpf.equals("000.000.000-00")
                || cpf.equals("111.111.111-11")
                || cpf.equals("222.222.222-22") || cpf.equals("333.333.333-33")
                || cpf.equals("444.444.444-44") || cpf.equals("555.555.555-55")
                || cpf.equals("666.666.666-66") || cpf.equals("777.777.777-77")
                || cpf.equals("888.888.888-88") || cpf.equals("999.999.999-99")) {
            return true;
        }
        return false;
    }

    public Cliente getCliente() {

        if (cliente == null) {
            cliente = new Cliente();
        }
        return cliente;
    }
}
