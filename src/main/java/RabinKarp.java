package main.java;

public class RabinKarp {
    // Rabin-Karp algorithm in Java

  public final static int d = 256;
  //possiblilites of characters on ascii keyboard
  public final static int q = 101;
  //prime to get unique hash code
  public static boolean search(String pattern, String text) {
    int m = pattern.length();
    int n = text.length();
    int i, j;
    int p = 0;
    int t = 0;
    int h = 1;

    for (i = 0; i < m - 1; i++)
      h = (h * d) % q;

    // Calculate hash value for pattern and text
    for (i = 0; i < m; i++) {
      p = (d * p + pattern.charAt(i)) % q;
      t = (d * t + text.charAt(i)) % q;
    }

    // Find the match
    //if the loop is broken, that means it was a false alarm
    for (i = 0; i <= n - m; i++) {
     //when p equals t, they have the same hash value. DO another check to make sure it was plagiarism
      if (p == t) {
        j = 0;
        while (j < m) {
          if (text.charAt(i + j) != pattern.charAt(j))
            break;
          j++;
        }
        //if you hit the terminating condition of the while loop, that means the characters are the same (cheating detected)
        if (j == m)
          return true;
      }

      if (i < n - m) {
        t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;
        if (t < 0)
          t = (t + q);
      }
    }
    return false;
  }
}
