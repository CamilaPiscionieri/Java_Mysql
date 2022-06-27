
public class Pago {
	
	private int id_Pago;
	private String fecha_pago;
	private int importe_pago;
	private TipoDePago tipodepago;
	
	public void generarPago(TipoDePago tipodepago){
		switch(tipodepago){
			case EFECTIVO:
				System.out.println(".....");
			break;
			
			case DEBITO:
				System.out.println(".....");
			break;
			
			case TARJETA_DE_CREDITO:
				System.out.println(".....");
			break;
			
			default:
				System.out.println(".....");
			break;
		}
	}

}
