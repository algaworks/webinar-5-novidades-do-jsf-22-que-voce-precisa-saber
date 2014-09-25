package com.algaworks.webinario.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JsfUtil {

	public static void adicionarMensagem(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	}
	
}