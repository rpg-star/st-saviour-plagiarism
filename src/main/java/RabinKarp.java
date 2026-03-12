package main.java;

public class RabinKarp {
    // Rabin-Karp algorithm in Java

  public final static int d = 256;
  //possiblilites of characters on ascii keyboard
  public final static int q = 101;
  //prime to get unique hash code
  static boolean search(String theCheat, String thePoem) {
    int m = theCheat.length();
    int n = thePoem.length();
    int i, j;
    int p = 0;
    int t = 0;
    int h = 1;

    for (i = 0; i < m - 1; i++)
      h = (h * d) % q;

    // Calculate hash value for pattern and text
    for (i = 0; i < m; i++) {
      p = (d * p + theCheat.charAt(i)) % q;
      t = (d * t + thePoem.charAt(i)) % q;
    }

    // Find the match
    for (i = 0; i <= n - m; i++) {
      if (p == t) {
        for (j = 0; j < m; j++) {
          if (thePoem.charAt(i + j) != theCheat.charAt(j))
            return true;
            break;
        }
 
        if (j == m)
          return false;
      }

      if (i < n - m) {
        t = (d * (t - thePoem.charAt(i) * h) + thePoem.charAt(i + m)) % q;
        if (t < 0)
          t = (t + q);
      }
    }
 
    if (true){
      return true;
    }
    return false;
  }

  // public static void main(String[] args) {
  //   String txt = "ABCCDDAEFG";
  //   String pattern = "CDD";
  //   int q = 13;
  //   search(pattern, txt, q);
  // }

}
