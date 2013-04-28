package br.com.yaw.erp.rh;

import org.junit.Test;

public class FuncionarioTest {

	@Test
	public void newFuncionarioTest() {
		Funcionario f = new Funcionario();
		f.setNome("Jose da Silva");
		f.setMatricula("X-0010");
		f.setSalario(2500.0);
	}
	
}
