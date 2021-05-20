package cadastroJAVA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Salvar implements ActionListener {
	
	public Salvar (ActionListener salvar) {
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
				try {
					
					Configuracoes.registraDados(CadastroJAVA.arquivoCadClientes);
				
				} catch (FileNotFoundException e) {
					
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	}
			
		
}
