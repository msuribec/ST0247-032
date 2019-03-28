
 /**
 * Clase en la cual se implementan los metodos del Taller 9
 * 
 * @author Marìa Sofia U, Isabel Graciano
 */
class Taller9{ 
   
    static int levenshtein(String str1, String str2) { 
        return levenshtein( str1 , str2 , str1.length(), str2.length()); 
    
    }
  
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
  
      
}
