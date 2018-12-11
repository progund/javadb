package org.flat.text;

public class SynonymsOracleFactory {
  
  private static SynonymsOracle oracle;

  public static SynonymsOracle getSynonymsOracle() {
    String type = System.getProperty("oracle.type", "file");
    System.out.println("DEBUG: type: " + type);
    if (oracle != null) {
      return oracle;
    }
    switch (type) {
      case "file":
        oracle = new SynonymsFileOracle();
        break;
      case "network":
        oracle = new SynonymsNetworkOracle();
        break;
      case "db":
        oracle = new SynonymsDbOracle();
        break;
      default:
        oracle = new SynonymsFileOracle();
    }    
    return oracle;
  }
}
