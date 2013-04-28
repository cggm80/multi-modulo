package br.com.yaw.erp.rh;

import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.apache.log4j.Logger;

@Table
public class Funcionario {

	private static final Logger log = Logger.getLogger(Funcionario.class);
	
	@NotNull
    private String nome;
	
	@NotNull
    private String matricula;
    
    @Min(1)
    private double salario;
    
    public Funcionario() {
    	log.debug("Criou uma instancia de funcionario");
    }

    public String getNome() {
		return nome;
	}
    
    public void setNome(String nome) {
		this.nome = nome;
	}
    
    public String getMatricula() {
		return matricula;
	}
    
    public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
    
    public double getSalario() {
		return salario;
	}
    
    public void setSalario(double salario) {
		this.salario = salario;
	}

}
