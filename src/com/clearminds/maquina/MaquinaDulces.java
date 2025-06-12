package com.clearminds.maquina;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;

public class MaquinaDulces {
	private Celda celda1;
	private Celda celda2;
	private Celda celda3;
	private Celda celda4;
	private double saldo;

	public void configurarMaquina(String cod1, String cod2, String cod3, String cod4) {
		// Instancia cada Celda y le asigna el código recibido
		celda1 = new Celda(cod1);
		celda2 = new Celda(cod2);
		celda3 = new Celda(cod3);
		celda4 = new Celda(cod4);
	}

	public void mostrarConfiguracion() {
		System.out.println("Celda 1: " + celda1.getCodigo());
		System.out.println("Celda 2: " + celda2.getCodigo());
		System.out.println("Celda 3: " + celda3.getCodigo());
		System.out.println("Celda 4: " + celda4.getCodigo());
	}

	// --- MÉTODO FALTANTE: buscarCelda ---
	public Celda buscarCelda(String codigoCelda) {
		// Comprueba si la celda1 existe y su código coincide
		if (celda1 != null && celda1.getCodigo().equals(codigoCelda)) {
			return celda1;
		}
		if (celda2 != null && celda2.getCodigo().equals(codigoCelda)) {
			return celda2;
		}

		if (celda3 != null && celda3.getCodigo().equals(codigoCelda)) {
			return celda3;
		}
		if (celda4 != null && celda4.getCodigo().equals(codigoCelda)) {
			return celda4;
		}
		// Si ninguna celda coincide o es nula, retorna null
		return null;
	}

	public void cargarProducto(Producto producto, String codigoCelda, int cantidad) {
		// Invoca al método buscarCelda
		Celda celdaRecuperada = buscarCelda(codigoCelda); // Guarda el retorno en celdaRecuperada

		// Verifica si la celda fue encontrada
		if (celdaRecuperada != null) {
			// En la celdaRecuperada, agrega el producto y el stock inicial
			// usando el método ingresarProducto de la celda.
			celdaRecuperada.ingresarProducto(producto, cantidad);
		} else {
			System.out.println(
					"Error: No se encontró la celda con el código " + codigoCelda + " para cargar el producto.");
		}
	}

	public void mostrarProductos() {
		// Imprimir detalles de cada celda
		System.out.println("******CELDA " + celda1.getCodigo());
		System.out.println("  Stock: " + celda1.getStock());
		if (celda1 != null && celda1.getProducto() != null) {
			System.out.println("  Producto: " + celda1.getProducto().getNombre() + " (Código: "
					+ celda1.getProducto().getCodigo() + ")");
			System.out.println("  Precio: " + celda1.getProducto().getPrecio());
		} else {
			System.out.println("  Vacía o no configurada.");
		}
		System.out.println("******CELDA " + celda2.getCodigo());
		System.out.println("  Stock: " + celda2.getStock());
		if (celda2 != null && celda2.getProducto() != null) {
			System.out.println("  Producto: " + celda2.getProducto().getNombre() + " (Código: "
					+ celda2.getProducto().getCodigo() + ")");
			System.out.println("  Precio: " + celda2.getProducto().getPrecio());
		} else {
			System.out.println("  Vacía o no configurada.");
		}
		System.out.println("******CELDA " + celda3.getCodigo());
		System.out.println("  Stock: " + celda3.getStock());
		if (celda3 != null && celda3.getProducto() != null) {
			System.out.println("  Producto: " + celda3.getProducto().getNombre() + " (Código: "
					+ celda3.getProducto().getCodigo() + ")");
			System.out.println("  Precio: " + celda3.getProducto().getPrecio());
		} else {
			System.out.println("  Vacía o no configurada.");
		}
		System.out.println("******CELDA " + celda4.getCodigo());
		System.out.println("  Stock: " + celda4.getStock());
		if (celda4 != null && celda4.getProducto() != null) {
			System.out.println("  Producto: " + celda4.getProducto().getNombre() + " (Código: "
					+ celda4.getProducto().getCodigo() + ")");
			System.out.println("  Precio: " + celda4.getProducto().getPrecio());
		} else {
			System.out.println("  Vacía o no configurada.");
		}

		System.out.println("---------------------------");
	}

	public Producto buscarProductoEnCelda(String codigoCelda) {
		Celda celdaEncontrada = buscarCelda(codigoCelda); // Reutiliza el método buscarCelda

		if (celdaEncontrada != null) {
			// Si la celda existe, retorna el producto que tiene esa celda
			return celdaEncontrada.getProducto();
		} else {
			// Si la celda no existe (buscarCelda retornó null), retorna null
			return null;
		}
	}

	public double consultarPrecio(String codigoCelda) {
		Celda celdaEncontrada = buscarCelda(codigoCelda); // Reutiliza el método buscarCelda

		if (celdaEncontrada != null) {
			// Si la celda existe, verifica si tiene un producto
			if (celdaEncontrada.getProducto() != null) {
				// Si tiene producto, retorna su precio
				return celdaEncontrada.getProducto().getPrecio();
			} else {
				// Si la celda no tiene un producto, puedes retornar 0 o lanzar una excepción
				System.out.println("La celda " + codigoCelda + " no tiene un producto asignado.");
				return 0.0;
			}
		} else {
			// Si la celda no existe (buscarCelda retornó null)
			System.out.println("No se encontró la celda con el código " + codigoCelda + ".");
			return 0.0; // O podrías retornar un valor especial como -1 para indicar que no existe
		}
	}

	// --- Método buscarCeldaProducto ---
	// Recibe el código de producto y retorna la celda que lo contiene, si no
	// encuentra retorna null.
	public Celda buscarCeldaProducto(String codigoProducto) {
		// Recorre cada celda y verifica si contiene el producto con el código buscado
		if (celda1 != null && celda1.getProducto() != null && celda1.getProducto().getCodigo().equals(codigoProducto)) {
			return celda1;
		} else if (celda2 != null && celda2.getProducto() != null
				&& celda2.getProducto().getCodigo().equals(codigoProducto)) {
			return celda2;
		} else if (celda3 != null && celda3.getProducto() != null
				&& celda3.getProducto().getCodigo().equals(codigoProducto)) {
			return celda3;
		} else if (celda4 != null && celda4.getProducto() != null
				&& celda4.getProducto().getCodigo().equals(codigoProducto)) {
			return celda4;
		} else {
			// Si no se encuentra ninguna celda con ese producto, retorna null
			return null;
		}
	}

	public void incrementarProductos(String codigoProducto, int cantidadItems) {
		// Invoca al método buscarCeldaProducto usando el código del producto que
		// recibe.
		Celda celdaEncontrada = buscarCeldaProducto(codigoProducto); // Guarda el retorno en celdaEncontrada.

		if (celdaEncontrada != null) {
			// En la celdaEncontrada, agrega el número de items al stock actual.
			celdaEncontrada.setStock(celdaEncontrada.getStock() + cantidadItems);
			System.out.println("Se incrementó el stock del producto " + codigoProducto + " en la celda "
					+ celdaEncontrada.getCodigo() + " en " + cantidadItems + " unidades.");
		} else {
			System.out.println("Error: No se encontró una celda con el producto de código " + codigoProducto
					+ " para incrementar el stock.");
		}
	}

	public void vender(String codigoCelda) {
		Celda celdaAComprar = buscarCelda(codigoCelda); // Busca la celda

		if (celdaAComprar != null) {
			if (celdaAComprar.getStock() > 0) {
				// Disminuye en 1 el stock.
				celdaAComprar.setStock(celdaAComprar.getStock() - 1);

				// Obtiene el precio del producto y sumar este valor al saldo actual de la
				// máquina.
				if (celdaAComprar.getProducto() != null) {
					double precioProducto = celdaAComprar.getProducto().getPrecio();
					this.saldo = this.saldo + precioProducto; // Suma al saldo de la máquina
					System.out.println("Producto vendido de la celda " + codigoCelda + ". Precio: " + precioProducto
							+ ". Saldo actual: " + this.saldo);
				} else {
					System.out.println("Error: La celda " + codigoCelda + " está vacía. No se puede vender.");
				}
			} else {
				System.out.println("Error: La celda " + codigoCelda + " no tiene stock disponible.");
			}
		} else {
			System.out.println("Error: No se encontró la celda con el código " + codigoCelda + ".");
		}
	}

	public double venderConCambio(String codigoCelda, double valorIngresado) {
		Celda celdaAComprar = buscarCelda(codigoCelda); // Busca la celda
		double vuelto = 0.0;

		if (celdaAComprar != null) {
			if (celdaAComprar.getStock() > 0) {
				if (celdaAComprar.getProducto() != null) {
					double precioProducto = celdaAComprar.getProducto().getPrecio();

					if (valorIngresado >= precioProducto) {
						// Resta 1 al stock del producto
						celdaAComprar.setStock(celdaAComprar.getStock() - 1);

						// Modifica el saldo
						this.saldo = this.saldo + precioProducto;

						// Retorna el vuelto que le debe entregar al cliente.
						vuelto = valorIngresado - precioProducto;
						System.out.println("Venta exitosa de la celda " + codigoCelda + ". Precio: " + precioProducto
								+ ". Ingresado: " + valorIngresado + ". Vuelto: " + vuelto
								+ ". Nuevo saldo de máquina: " + this.saldo);
					} else {
						System.out.println("Error: Valor ingresado insuficiente para comprar el producto en la celda "
								+ codigoCelda + ". Precio: " + precioProducto + ". Ingresado: " + valorIngresado);
						// No hay vuelto si el valor es insuficiente
					}
				} else {
					System.out.println("Error: La celda " + codigoCelda + " está vacía. No se puede vender.");
				}
			} else {
				System.out.println("Error: La celda " + codigoCelda + " no tiene stock disponible.");
			}
		} else {
			System.out.println("Error: No se encontró la celda con el código " + codigoCelda + ".");
		}
		return vuelto;
	}

	public Celda getCelda1() {
		return celda1;
	}

	public void setCelda1(Celda celda1) {
		this.celda1 = celda1;
	}

	public Celda getCelda2() {
		return celda2;
	}

	public void setCelda2(Celda celda2) {
		this.celda2 = celda2;
	}

	public Celda getCelda3() {
		return celda3;
	}

	public void setCelda3(Celda celda3) {
		this.celda3 = celda3;
	}

	public Celda getCelda4() {
		return celda4;
	}

	public void setCelda4(Celda celda4) {
		this.celda4 = celda4;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
