package br.com.yaw.cdi.mb;

import static javax.faces.context.FacesContext.getCurrentInstance;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.yaw.cdi.model.Mercadoria;
import br.com.yaw.cdi.service.MercadoriaService;

@Named
@RequestScoped
public class MercadoriaMB implements Serializable {
	
	/**
	 * Referência para o componente EJB.
	 */
	@Inject
	private MercadoriaService service;
	
	/**
	 * Referência para a mercadoria utiliza na inclusão (nova) ou edição.
	 */
	//@Inject
	private Mercadoria mercadoria = new Mercadoria();
	
	private Long idSelecionado;
	
	private List<Mercadoria> mercadorias;
	
	public MercadoriaMB() {
	}
	
	public void setIdSelecionado(Long idSelecionado) {
		this.idSelecionado = idSelecionado;
	}
	
	public Long getIdSelecionado() {
		return idSelecionado;
	}
	
	public Mercadoria getMercadoria() {
		return mercadoria;
	}
	
	
	public void editar() {
		if (idSelecionado == null) {
			return;
		}
		mercadoria = service.find(idSelecionado);
		//log.debug("Pronto pra editar");
	}
	
	public List<Mercadoria> getMercadorias() {
		System.out.println("service: "+service);
		if (mercadorias == null) {
			mercadorias = service.findAll();
		}
		return mercadorias;
	}

	
	public String salvar() {
		try {
			System.out.println("service: "+service);
			service.save(mercadoria);
		} catch(Exception ex) {
			//log.error("Erro ao salvar mercadoria.", ex);
			addMessage(getMessageFromI18N("msg.erro.salvar.mercadoria"), ex.getMessage());
			return "";
		}
		//log.debug("Salvour mercadoria "+mercadoria.getId());
		return "listaMercadorias";
	}
	
	public String remover() {
		try {
			service.remove(mercadoria);
		} catch(Exception ex) {
			//log.error("Erro ao remover mercadoria.", ex);
			addMessage(getMessageFromI18N("msg.erro.remover.mercadoria"), ex.getMessage());
			return "";
		}
		//log.debug("Removeu mercadoria "+mercadoria.getId());
		return "listaMercadorias";
	}
	
	/**
	 * @param key
	 * @return Recupera a mensagem do arquivo properties <code>ResourceBundle</code>.
	 */
	private String getMessageFromI18N(String key) {
		ResourceBundle bundle = ResourceBundle.getBundle("messages_labels", getCurrentInstance().getViewRoot().getLocale());
		return bundle.getString(key);
	}
	
	/**
	 * Adiciona um mensagem no contexto do Faces (<code>FacesContext</code>).
	 * @param summary
	 * @param detail
	 */
	private void addMessage(String summary, String detail) {
		getCurrentInstance().addMessage(null, new FacesMessage(summary, summary.concat("<br/>").concat(detail)));
	}
	
}
