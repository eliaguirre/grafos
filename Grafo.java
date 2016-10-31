
public class Grafo {
	private int nvert;
	private int[][] costos;
	private final static int MAXC = Integer.MAX_VALUE / 3;
	boolean f[];
	int d[];
	int ultimo[];
	int ori;

	public Grafo(int nv, int orig) {
		costos = new int[nv][nv];
		d = new int[nv];
		ultimo = new int[nv];
		f = new boolean[nv];
		for (int i = 0; i < nv; i++)
			for (int j = 0; j < nv; j++)
				costos[i][j] = MAXC;
		nvert = nv;
		ori = orig;
	}

	public boolean agregar(int or, int de, int peso) {// agrega el peso a la
														// arista or,de
		if (or < nvert && de < nvert) {
			costos[or][de] = peso;
			return true;
		}
		return false;
	}

	public int camino(int or, int de) {
		boolean fin = false, sal = false;
		int d = 0, suma = 0;
		if (costos[or][de] != MAXC) {
			System.out.println(or + "->" + de);
			return costos[or][de];
		} else
			for (int o = or; d != de && o < nvert; o++) {
				d = 0;
				while (!fin) {
					for (; d != de && d < nvert; d++)
						if (costos[o][d] != MAXC) {
							System.out.println(o + "->" + d);
							suma = suma + costos[o][d];
							o = d;
							break;
						}
					if (d == de) {
						System.out.println(o + "->" + d);
						fin = true;
					}
				}
			}
		return suma;
	}

	public void dijkstra() {
		int i = 0, v;
		int min = MAXC;
		for (i = 0; i < nvert; i++) {
			d[i] = costos[ori][i];
			f[i] = false;
			ultimo[i] = ori;
		}
		f[ori] = true;
		d[ori] = 0;
		// pasos para marcar los vertices
		for (i = 0; i < nvert; i++) {
			v = minimo();
			f[v] = true;
			for (int w = 1; w < nvert; w++)
				if (!f[w])
					if ((d[v] + costos[v][w]) < d[w]) {
						d[w] = d[v] + costos[v][w];
						ultimo[w] = v;
					}
		}
	}

	private int minimo() {
		int v = 0;
		int min = MAXC;
		for (int j = 0; j < nvert; j++)
			if (!f[j] && (d[j] <= min)) {
				min = d[j];
				v = j;
			}
		return v;
	}

	public void recuperaCamino(int v) {
		int anterior = ultimo[v];
		if (v != ori) {
			recuperaCamino(anterior);
			System.out.print("->" + v);
		} else
			System.out.print("V " + ori);
	}

	public int[][] wfi() {
		int weight[][] = costos.clone();
		for (int i = 0; i < nvert; i++) {
			for (int j = 0; j < nvert; j++) {
				for (int k = 0; k < nvert; k++) {
					if (weight[j][k] > weight[j][i] + weight[i][k]) {
						weight[j][k] = weight[j][i] + weight[i][k];
					}
				}
			}
		}
		return weight;
	}

	public static String toString(int[][] c) {
		String res = "";
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c.length; j++)
				if (c[i][j] >= MAXC) {
					res += "-\t";
				} else {
					res += (c[i][j]) + "\t";
				}
			res += "\n";
		}
		return res;
	}

	public String toString() {
		String res = "";
		for (int i = 0; i < nvert; i++) {
			for (int j = 0; j < nvert; j++)
				if (costos[i][j] == MAXC) {
					res += "-\t";
				} else {
					res += (costos[i][j]) + "\t";
				}
			res += "\n";
		}
		return res;
	}

}