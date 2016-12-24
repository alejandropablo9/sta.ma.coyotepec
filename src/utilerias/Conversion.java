package utilerias;

/**
 *
 * @author Alejandro
 */
import java.math.BigDecimal;
import java.math.BigInteger;

public final class Conversion {
  public static final int deStringAint(String x) {
    int y;
    try {
      y = Integer.parseInt(x);
    } catch (NumberFormatException e) {
      y = 0;
    }
    return y;
  }
  
  public static final int deStringAint(String x, int porDefault) {
    int y;
    try {
      y = Integer.parseInt(x);
    } catch (NumberFormatException e) {
      y = porDefault;
    }
    return y;
  }

  public static final long deStringAlong(String x) {
    long y;
    try {
      y = Long.parseLong(x);
    } catch (NumberFormatException e) {
      y = 0;
    }
    return y;
  }
  
  public static final long deStringAlong(String x, long porDefault) {
    long y;
    try {
      y = Long.parseLong(x);
    } catch (NumberFormatException e) {
      y = porDefault;
    }
    return y;
  }
  
  public static final double deStringAdouble(String x) {
    double y;
    try {
      y = Double.parseDouble(x);
    } catch (NumberFormatException e) {
      y = 0.0;
    }
    return y;
  }
  
  public static final double deStringAdouble(String x, double porDefault) {
    double y;
    try {
      y = Double.parseDouble(x);
    } catch (NumberFormatException e) {
      y = porDefault;
    }
    return y;
  }
  
  public static final boolean deStringAboolean(String x) {
    boolean y = false;
    if (x.equals("true")) {
      y = true;
    }
    if (x.equals("false")) {
      y = false;
    }
    return y;
  }
  
  public static final boolean deStringAboolean(String x, boolean porDefault) {
    boolean y = porDefault;
    if (x.equals("true")) {
      y = true;
    }
    if (x.equals("false")) {
      y = false;
    }
    return y;
  }
  
  public static final char deStringAchar(String x) {
    char y;
    if (x.length() == 0 || x.length() > 1) {
      y = '\u0000';
    } else {
      y = x.charAt(0);
    }
    return y;
  }
  
  public static final char deStringAchar(String x, char porDefault) {
    char y;
    if (x.length() == 0 || x.length() > 1) {
      y = porDefault;
    } else {
      y = x.charAt(0);
    }
    return y;
  }

  public static final BigInteger deStringAbigInteger(String x) {
    BigInteger y;
    try {
      y = new BigInteger(x);
    } catch (NumberFormatException e) {
      y = new BigInteger("0");
    }
    return y;
  }
  
  public static final BigInteger deStringAbigInteger(String x, String porDefault) {
    BigInteger y;
    try {
      y = new BigInteger(x);
    } catch (NumberFormatException e) {
      y = new BigInteger(porDefault);
    }
    return y;
  }
  
  public static final BigDecimal deStringAbigDecimal(String x) {
    BigDecimal y;
    try {
      y = new BigDecimal(x);
    } catch (NumberFormatException e) {
      y = new BigDecimal("0.0");
    }
    return y;
  }
  
  public static final BigDecimal deStringAbigDecimal(String x, String porDefault) {
    BigDecimal y;
    try {
      y = new BigDecimal(x);
    } catch (NumberFormatException e) {
      y = new BigDecimal(porDefault);
    }
    return y;
  }
  
  public static final String deIntAString(int x){
      return ""+x;
  }
}