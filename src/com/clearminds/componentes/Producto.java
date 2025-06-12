package com.clearminds.componentes;

public class Producto {
	private String nombre;
	private double precio;
	private String codigo;

	public Producto(String nombre, double precio, String codigo) {
		this.nombre = nombre;
		this.precio = precio;
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
	public void incrementarPrecio(int porcentaje) {
		// Calcula el porcentaje de incremento
		double incremento = precio * (porcentaje / 100.0);

		// Suma el incremento al precio actual
		precio = precio + incremento;
	}

	public void disminuirPrecio(double descuento) {
		// Calcula el monto de descuento
	    // Se divide por 100.0 para asegurar una división de punto flotante
	    double montoDescuento = precio * (descuento / 100.0); 

	    // Disminuye el precio actual
	    precio = precio - montoDescuento; 
	}
}
