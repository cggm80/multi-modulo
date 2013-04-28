package br.com.yaw.erp.financeiro;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.time.FastDateFormat;

import br.com.yaw.erp.rh.Funcionario;

public class LancamentoSalario {

    private double valorEmCaixa; 
    private Date data;

    private Funcionario funcionario;
    
    public LancamentoSalario(Funcionario f, double caixa) {
    	if (f == null)
    		throw new IllegalArgumentException("Informe o funcionario");
    	
    	if (caixa <= 0) {
    		throw new IllegalArgumentException("Caixa deve ser positivo");
    	}
    	
    	this.funcionario = f;
    	this.valorEmCaixa = caixa;
    	this.data = new Date();
    }
    
    public double getValorEmCaixa() {
		return valorEmCaixa;
	}
    
    public void lancar() {
    	BigDecimal salario = new BigDecimal(funcionario.getSalario());
    	BigDecimal caixa = new BigDecimal(valorEmCaixa);
    	if (caixa.compareTo(salario) < 0) {
    		throw new RuntimeException("Nao ha caixa para realizar pagamento!");
    	}
    	caixa = caixa.subtract(salario);
    	this.valorEmCaixa = caixa.doubleValue();
    }
    
    @Override
    public String toString() {
    	ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
    		.append("Lancamento de salario")
    		.append("Caixa", valorEmCaixa)
    		.append("Funcionario",funcionario.getNome())
    		.append("Salario", funcionario.getSalario())
    		.append("Data", FastDateFormat.getInstance("dd/MM/yyyy").format(data));
    	
    	return builder.build();
    }
    

}
