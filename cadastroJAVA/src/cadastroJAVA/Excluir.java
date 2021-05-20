package cadastroJAVA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Excluir implements ActionListener {
	
	
	public Excluir(ActionListener excluir) {
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		try {
			
			if(!Configuracoes.pesquisados.isEmpty()) {
				
			Configuracoes.deletaRegistros(CadastroJAVA.arquivoCadClientes,CadastroJAVA.arquivoTemp,Configuracoes.pesquisados);

			}else {
			
			Configuracoes.deletaRegistros(CadastroJAVA.arquivoCadClientes,CadastroJAVA.arquivoTemp,Configuracoes.lista);
		
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
