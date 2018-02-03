package org.flat.text;

public class SynonymsOracleFactory {
  
  private static SynonymsOracle oracle;

  public static SynonymsOracle getSynonymsOracle() {
    String type = System.getProperty("oracle.type", "file");
    System.out.println("DEBUG: type: " + type);

    switch (type) {
    case "file":
      if (oracle == null) {
        oracle = new SynonymsFileOracle();
        break;
      }
      return oracle;
    case "network":
      if (oracle == null) {
        oracle = new SynonymsNetworkOracle();
        break;
      }
    default:
      oracle = new SynonymsFileOracle();
    }    
    return oracle;
  }
}
