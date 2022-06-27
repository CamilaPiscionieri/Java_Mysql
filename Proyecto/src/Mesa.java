import java.util.ArrayList;
import java.util.List;

public class Mesa {
	
	private int id_Mesa;
	private EstadoMesa estadomesa;
	
	public void setEstadoMesa(EstadoMesa estado){
		System.out.println(estado);
	}
	
	public boolean getMesaDisponible(EstadoMesa estado){
		return true;
	}

}
