
public class Empleados_Preparadores {
	
	private String legajo;
	private TipoPreparadores tipopreparadores;
	private Comanda comanda;
	
	public void prepararComanda(TipoPreparadores tipoPreparador){
		if(tipoPreparador == tipopreparadores.COCINERO){
			comanda.setEstadoComanda(EstadoComanda.ELABORANDO);
		}else if(tipoPreparador == tipopreparadores.BARTENDER){
			comanda.setEstadoComanda(EstadoComanda.ELABORANDO);
		}else if(tipoPreparador == tipopreparadores.CERVERCERO){
			comanda.setEstadoComanda(EstadoComanda.ELABORANDO);
		}else if(tipoPreparador == tipopreparadores.CANDYBAR){
			comanda.setEstadoComanda(EstadoComanda.ELABORANDO);
		}else{
			System.out.println("");
		}
	}
	
	public void terminarComanda(TipoPreparadores tipoPreparador){
		comanda.setEstadoComanda(EstadoComanda.TERMINADA);
		System.out.println("La comanda de" + tipoPreparador +"fue terminada");
	}

}
