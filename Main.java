
public class Main {

	public static void main(String args[]) {
		Grafo grafo = new Grafo(10, 3);

		grafo.agregar(0, 4, 1);
		grafo.agregar(0, 7, 10);
		grafo.agregar(1, 2, 2);

		grafo.agregar(3, 0, 4);
		grafo.agregar(3, 7, 1);
		grafo.agregar(4, 5, 3);
		grafo.agregar(5, 1, 1);
		grafo.agregar(5, 2, 3);
		grafo.agregar(5, 6, 7);
		grafo.agregar(5, 8, 1);
		grafo.agregar(7, 4, 5);
		grafo.agregar(7, 8, 9);
		grafo.agregar(8, 9, 2);
		grafo.agregar(9, 6, 1);

		/*grafo.agregar(0, 0, 0);
		grafo.agregar(1, 1, 0);
		grafo.agregar(2, 2, 0);
		grafo.agregar(3, 3, 0);
		grafo.agregar(4, 4, 0);
		grafo.agregar(5, 5, 0);
		grafo.agregar(6, 6, 0);
		grafo.agregar(7, 7, 0);
		grafo.agregar(8, 8, 0);
		grafo.agregar(9, 9, 0);*/
		System.out.println("Matriz de adyacencias");
		System.out.println(grafo);

		 grafo.dijkstra();
		grafo.recuperaCamino(9);
		
		System.out.println("\nMatriz de costos");
		int peso[][]=grafo.wfi();
		System.out.println(Grafo.toString(peso));
		
		 //int c=grafo.camino(3,9);
		 //System.out.println(c);

	}

}
