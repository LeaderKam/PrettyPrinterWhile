# PrettyPrinterWhile

# Fichier jar
  dossier contenant le prettyPrinter

# Compilateur

  # Lib
    Dossier contenant le Libwh et le BinTree
  # Mode d'execution du jar
    ## 1. Génération de code 3@
      java -jar whc.jar test40.wh -3aCode test.txt
    ## 2. Génération de fichier Java (extension .java)
      java -jar whc.jar test40.wh -3aJava test.java
      
  # Processus d'exécution des fichiers java
    ## 1. le BinTree  se placer dans le dossier ou se trouve tous nos fichier java (ex: D:\TL\test\comp)
      D:\TL\test\comp>javac -d D:\TL\test\comp BinTree.java
    ## 2. le Libwh 
      D:\TL\test\comp>javac -d D:\TL\test\comp Libwh.java
    ## 3. notre fichier généré
      D:\TL\test\comp>javac -d D:\TL\test\comp Test.java
    ## 4. Execution du fichier  compilation est le package ou se trouve notre classe
      D:\TL\test\comp>java compilation.Test f0 6 8     
# Auteur
   Sie Vincent KAM (Responsable Test) Achraff JAFFAR (Scrum Master) Marius Katou Anna Vi
