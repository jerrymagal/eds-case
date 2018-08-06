package br.com.eds.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public final class FacesUtil {

	public static void adicionarMensagem(Severity tipo, String msg) {
		FacesMessage facesMessage = new FacesMessage(tipo, msg, null);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

}
