# Fichier jar et sh
  dossier contenant le prettyPrinter (whpp) et le compilateur (whc) et un script d'éxecution whpp.sh et whc.sh
  
# PrettyPrinterWhile

  # Mode d'execution du jar
    ## 1. indentation par defaut                                       ##1.1 indentation par defaut
      java -jar whpp.jar test40.wh -o test.txt                           ./whpp.sh test40.wh -0 test.txt
      (ex: test40.wh fichier while , test.txt fichier de sortie)
    ## 2. aide en ligne                                                ##2.2 aide en ligne
      java -jar whc.jar -help                                            ./whpp.sh -help
      
  # Processus d'exécution des fichiers java
    ## 1. plusiseur option d'indentation pouvant etre combiné (ex: -if 2 -while 5 -for 6 -o test.txt)
      D:\TL>java -jar whpp.jar fichier.wh -while 5 -for 6 -o test.txt     

# Compilateur

  # Lib
    Dossier contenant le Libwh et le BinTree
  # Mode d'execution du jar
    ## 1. Génération de code 3@
      java -jar whc.jar test40.wh -3aC test.txt
    ## 2. Génération de fichier Java (extension .java)
      java -jar whc.jar test40.wh -o test.java
      
  # Processus d'exécution des fichiers java
    ## 1. le BinTree  se placer dans le dossier ou se trouve tous nos fichier java (ex: D:\TL\test\comp)
      D:\TL\test\comp>javac -d D:\TL\test\comp BinTree.java
    ## 2. le Libwh 
      D:\TL\test\comp>javac -d D:\TL\test\comp Libwh.java
    ## 3. notre fichier généré
      D:\TL\test\comp>javac -d D:\TL\test\comp Test.java
    ## 4. Execution du fichier  compilation est le package ou se trouve notre classe
      D:\TL\test\comp>java compilation.Test f0 6 8     
# Auteurs
  ### Sie Vincent KAM (Responsable Test) 
  ### Achraff JAFFAR (Scrum Master)
  ### Lou Anna Marcel VI
  ### Marius Katou 
