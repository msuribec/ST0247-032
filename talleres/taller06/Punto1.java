/**
	* Metodo que dado un entero n y un conjunto de denominciones de dinero
	* busque la manera optima de dar el cambio
	* @param n cantidad a devolver
	* @param denominaciones conjunto de denominaciones de dinero (monedas, billetes)
	* @return un conjunto de unidades por denominacion
	*/
public static int[] cambioGreedy(int n , int[] denominaciones){
  int[] respuesta = new int[denominaciones.length];
  for (int i =0;i<denominaciones.length;i++){
  int cantidad = n/ denominaciones[i];
  n= % denominaciones[i];
  }
}