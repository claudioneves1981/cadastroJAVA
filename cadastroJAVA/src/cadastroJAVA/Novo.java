package cadastroJAVA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Novo implements ActionListener {
	
	public Novo (ActionListener novo) {
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Configuracoes.limpaCampos();
		
	}

}
