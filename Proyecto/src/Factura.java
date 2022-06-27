
public class Factura {
	
	private int id_Factura;
	private TipoFactura tipoFactura;
	private int numero_factura;
	private int fecha_factura;
	private int importe_factura;
	private Pago pago;
	
	public void hacerFactura(TipoFactura tipofactura, TipoDePago tipodepago){
		switch(tipofactura){
		case A:
			pago.generarPago(tipodepago);
			System.out.println(".....");
		break;
		
		case B:
			pago.generarPago(tipodepago);
			System.out.println(".....");
		break;
		
		default:
			System.out.println(".....");
		break;
	}
	}

}
