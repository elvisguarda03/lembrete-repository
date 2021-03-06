package br.com.guacom.lembrete.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.guacom.lembrete.dao.LembreteDAO;
import br.com.guacom.lembrete.model.Lembrete;

@ManagedBean
@RequestScoped
public class LembreteBean {
	private Lembrete lembrete = new Lembrete();
	private List<Lembrete> lembretes;

	@PostConstruct
	public void posCriacao() {
		System.out.println("Objeto lembrete bean foi criado");
	}

	public Lembrete getLembrete() {
		return lembrete;
	}

	public String save() {
		FacesContext context = FacesContext.getCurrentInstance();
		// Mantendo mensagens entre duas requisi��es.
		context.getExternalContext().getFlash().setKeepMessages(true);
		if (lembrete.getTitulo().isEmpty() || lembrete.getData() == null) {
			this.lembrete = new Lembrete("Digite seu t�tulo", "Descri��o para o lembrete");
			context.addMessage("messages", new FacesMessage("Campos obrigat�rios n�o podem ficar v�zios"));
			return "cadastro?faces-redirect=true";
		}
		try {
			LembreteDAO dao = new LembreteDAO();
			dao.persist(lembrete);
		} catch (Exception e) {
			context.addMessage("messages", new FacesMessage("Erro: " + e.getMessage()));
		}
		return "lembretes?faces-redirect=true";
	}

	public String navigation() {
		System.out.println("Navegando");
		return String.format("%s?faces-redirect=true", "cadastro");
	}

	public List<Lembrete> loadReminders() {
		if (lembretes == null)
			lembretes = new LembreteDAO().findAll();
		return lembretes;
	}
}