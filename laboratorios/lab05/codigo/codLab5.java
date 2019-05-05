import java.util.Arrays;

/**
 * code for Lab 5
 *
 * @author María Sofía Uribe, Isabel graciano
 */
public class codLab5 {


    public static void main(String[] args) {

        lcSubsequence( "ABCDGH" ,"AEDFHR" );
        lcSubsequence("AGGTAB" , "GXTXAYB");

    }


    /**
     *  Método Auxiliar que imprime la subsecuencia común más larga presente en dos cadenas dadas y su longitud
     *  Llama a los métodos posteriores
     *  @param x primera cadena dada dado
     * @param y segunda cadena dada dado
     * */
    public static void lcSubsequence( String x, String y) {
        int[][] lcs = new int[x.length() + 1][y.length() + 1];
        int n = lcSubsequence(x, y, lcs);
        System.out.println("LCS length = " + n +", LCS = " + findtlcs(lcs, x, y, n) );

    }


    /**
     *  Método que retorna la longitud de la subsecuencia común más larga presente en dos cadenas dadas
     * @param lcs matriz vacía donde se guardará el resultado del algoritmo de lcs con programación dinámica
    *  @param x primera cadena dada dado
     * @param y segunda cadena dada dado
     * @return longitud de la subsecuencia común más larga entre la cadena x y  la cadena y
     * */
    public static int lcSubsequence( String x, String y, int[][] lcs) {

        int m = x.length();
        int n = y.length();


        for (int i=0; i<=m; i++) {
            for (int j=0; j<=n; j++) {
                if (i == 0 || j == 0) lcs[i][j] = 0;
                else if (x.charAt(i-1) == y.charAt(j-1))
                    lcs[i][j] = 1+ lcs[i-1][j-1] ;
                else
                    lcs[i][j] = Math.max(lcs[i-1][j],lcs[i][j-1]);
            }
        }

        return lcs[m][n];
    }


    /**
     *  Método que retorna la subsecuencia común más larga presente en dos cadenas dadas
     *  @param lcs matriz del resultado del algoritmo de lcs con programación dinámica
     *  @param x primera cadena dada dado
     * @param y segunda cadena dada dado
     * @return cadena de caracteres que es la subsecuencia común más larga entre la cadena x y  la cadena y
     * */
    public static String findtlcs(int[][] lcs,String x, String y, int lengthLCS) {
        int i = x.length();
        int j = y.length();
        int k = lengthLCS;

        char[] answer = new char[lengthLCS+ 1];

        while (i > 0 && j > 0) {
            if (x.charAt(i-1) == y.charAt(j-1)) {
                i--;k--;
                answer[k] = x.charAt(i);
                j--;
            }
            else if (lcs[i-1][j] < lcs[i][j-1]) j--;
            else i--;
        }

        return new String(answer);
    }



    /**
     * Método auxiliar que  llama al método posterior que retorna (usando programación dinámica)la  distancia
     Levenshtein que hay entre dos cadenas de caracteres asumiendo que ambas están en mayúscula o en minúscula
     * @param str1 primera cadena dada dado
     * @param str2 segunda cadena dada dado
     * @return distancia Levenshtein que hay entre  str1 y str2
     */
    static int levenshtein(String str1, String str2) {
        return levenshtein( str1 , str2 , str1.length(), str2.length());
    }

    /**
     * Método que retorna (usando programación dinámica)la  distancia
     Levenshtein que hay entre dos cadenas de caracteres asumiendo que ambas están en mayúscula o en minúscula
     * @param str1 primera cadena dada dado
     * @param str2 segunda cadena dada dado
     * @return distancia Levenshtein que hay entre  str1 y str2
     */
    static int levenshtein(String str1, String str2, int m, int n) {

        int d[][] = new int[m+1][n+1];

        for (int i=0; i<=m; i++) {
            for (int j=0; j<=n; j++) {
                if (i==0) d[0][j] = j;
                else if (j==0) d[i][j] = i;
                else if (str1.charAt(i-1) == str2.charAt(j-1))
                    d[i][j] = d[i-1][j-1];

                else{
                    d[i][j] = Math.min(d[i][j-1],
                            d[i-1][j]);
                    d[i][j]  = 1 + Math.min (d[i-1][j-1],d[i][j]);
                }
            }
        }
        return d[m][n];
    }
    /**
     * Método auxiliar que inicializa las matrices de costos y padres y llama al método posterior que resuelve el problema de TSP
     * usando programación dinámica
     * @param g grafo dado
     * @return  costo mínimo del recorrido que pasa por
     * todos los vértices exactamente una vez y vuelve al nodo inicial.
     */
    public static int heldKarp(Digraph g) {
        int n = g.size;
        int m = 1 << n;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                dp[i][j] = -1;
        BitmaskSet set = new BitmaskSet(n);
        set.add(0);
        return heldKarp(g, dp, 0, set);
    }

    /**
     * Método que calcula el costo mínimo del recorrido que pasa por
     * todos los vértices exactamente una vez y vuelve al nodo inicial
     * @param g grafo dado
     * @param dp matriz que guarda el costo de ir del nodo 0 al nodo destino pasando por el conjunto de vértices set
     * @param v vértice fuente
     * @param set conjunto de vértices por los que se pasa para llegar de 0 al destino (en una máscara en binario)
     */
    private static int heldKarp(Digraph g, int[][] dp, int v, BitmaskSet set) {
        if (set.isFull())
            return g.getWeight(v, 0);
        int m = set.mask();
        if (dp[v][m] != -1)
            return dp[v][m];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < g.size; ++i)
            if (i != v && !set.contains(i)) {
                BitmaskSet t = new BitmaskSet(set);
                t.add(i);
                ans = Math.min(ans, g.getWeight(v, i) + heldKarp(g, dp, i, t));
            }
        return dp[v][m] = ans;
    }
}
