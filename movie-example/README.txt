Run the GUI:
javac org/iths/*/*.java && java -cp .:sqlite.jar org.iths.main.GUI
Run the text version:
javac org/iths/*/*.java && java -cp .:sqlite.jar org.iths.main.Main
Run the JavaFX version:
If you are using Oracle's JDK 8:
javac org/iths/*/*.java && java -cp .:sqlite.jar org.iths.gui.JavaFX
If you are using OpenJDK 8 on Ubuntu:
javac -cp .:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/ext/jfxrt.jar org/iths/*/*.java && java -cp .:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/ext/jfxrt.jar:sqlite.jar org.iths.gui.JavaFX
(JavaFX isn't included in the OpenJDK but it is in the Oracle installation)
The background image used in the JavaFX version is Foggy_Forest_by_Jake_Stewart.jpg under CC-BY-SA.
