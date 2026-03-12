John the Ripper originario è stato portato avanti dalla comunità, grazie alla quale adesso supporta numerosissimi hash e diverse tipologie di file. Inoltre lavora insieme ad una suite di script, come **ssh2john, pdf2john** e così via che hanno ampliato le sue funzionalita.
Il nome della versione è **Jumbo John the Ripper**.
John the Ripper nasce come tool di hash cracking basato su **CPU**, il supporto GPU è stato aggiunto nella versione Jumbo ma non è paragonabile alla velocità su GPU di hashcat con hash che permettono alte prestazione su schede video.

> [!Tip] Rilevazione automatica dell'hash
> Usare la rilevazione automatica dell'hash non è quasi mai una buona ida in quanto alcuni hash potrebbero confondersi e dunque bisogna sempre considerare il contesto (es. alcune tipologie di hash sono usate per verificare le password dei documenti PDF e potrebbero assomigliare ad algoritmi di hash usati per scopi totalmente differenti)

Comando per rilevazione automatica: 

```bash
john --wordlist=[path to wordlist] [path to file]
```

Comando con specifica della tipologia dell'hash:
```bash
john --format=[format] --wordlist=[path to wordlist] [path to file]
```

Per craccare un hash di tipo NTLM (quello usato per memorizzare le password in Windows) basta usare il flag "--format=nt".

### **Craccare Password Linux** - unshadow

Nei sistemi Linux le password vengono memorizzate nel file **etc/shadow**, mentre le altre informazioni vengono salvate nel fiel **etc/passwd** che a differenza del primo è accessibile a tutti e permette di individuare ad esempio le corrispettive home directory per ogni utente.

Per poter craccare gli hash memorizzati c'è bisogno di ricreare il file completo mediante un tool di john detto **unshadow**:

```bash
unshadow [path_to_passwd] [path_to_shadow] > unshadowed.txt
```

### Single Crack Mode

Questa modalità permette a John di creare il suo dizionario personalizzato in base allo username dell'utente. John crea tutte le possibili variazioni dello Username e delle informazioni ricavate dalle **general informations** dello user (come il nome completo ed il suo numero di telefono) e le usa per cercare di crarrare la password:

```bash
john --format=[format] --single [path to file]
```

> [!Attention] Cambiare formato file
> Per usare la single Crack mode è necessario specificare (se il file è un singolo hash e non ad esempio l'unione del passwd e dello shadow) lo username dell'utente prima dell'hash in questo modo:
>**username:hash** 

### Custom Rules

Le custom rules non sono come le maschere in hashcat, permettono di definire delle regole per filtrare dizionari o modificarli aggiungendo dei caratteri alla fine, all'inizio, in mezzo e condizioni del tipo aggiungi una @ se la parola è lunga 10 lettere.

Come si può capire sono uno strumento estremamente potente, le custo rules sono definite nel file **/etc/john/john.conf** in fondo al file sono presenti una serie di custom rules, ognuna con il proprio titolo così da poter essere invocata, e su cui si possono aggiungere nuove regole.

Il comando per invocare ad esempio la custom rules "PoloPassword" è il seguente:

```bash
john --format=[format] --wordlist=[path to wordlist] [path to file] --rule=PoloPassword
```


### Craccare file Zip

Per estrarre gli hash da un file Zip, si usa il tool **zip2john** che funziona allo stesso modo di unshadow:

```bash
zip2john [zip file] > [output file]
```

Altri tool sono rar2john, ssh2john, .. che hanno la stessa sintassi e lo stesso scopo.


#Hash #Security #Tools 