package br.com.yaw.erp.financeiro;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import br.com.yaw.erp.rh.Funcionario;

public class LancamentoSalarioTest {

	private Funcionario f;
	
	@Before
	public void setup() {
		f = new Funcionario();
		f.setNome("Jose da Silva");
		f.setMatricula("X-0010");
		f.setSalario(2500.0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testLancamentoSemFuncionario() {
		LancamentoSalario lancamento = new LancamentoSalario(null, 1000);
		lancamento.lancar();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testLancamentoCaixaNegativo() {
		LancamentoSalario lancamento = new LancamentoSalario(f, -500);
		lancamento.lancar();
	}
	
	@Test(expected=RuntimeException.class)
	public void testLancamentoSalarioMaiorCaixa() {
		LancamentoSalario lancamento = new LancamentoSalario(f, 1000);
		lancamento.lancar();
	}
	
	@Test
	public void testLancamento() {
		LancamentoSalario lancamento = new LancamentoSalario(f, 3000);
		BigDecimal valorEsperado = new BigDecimal(3000);
		valorEsperado = valorEsperado.subtract(new BigDecimal(f.getSalario()));
		lancamento.lancar();
		
		assertEquals(valorEsperado, new BigDecimal(lancamento.getValorEmCaixa()));
		
		System.out.println(lancamento);
	}
	
}
