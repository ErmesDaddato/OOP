Nmap è un open-source network scanner, estremamente valido e flessibile per diversi scenari.
Nmap va eseguito da un utente amministratore in quanto sarebbe altrimenti limitato.

### Verifica presenza online sulla rete

Una delle tanti funzioni di questo tool è quella di verificare chi è attivo sulla rete, per far ciò non usa semplici pacchetti con protocollo ICMP (come ping) bensì pacchetti più sofisticati che permettono di aggirare determinate restrizioni (es. firewall per ICMP), come pacchetti TCP con flag ACK.

Comando base per scanning rete:

```bash
nmap -sn 192.168.66.0/24
```

```bash
nmap -sn 192.168.66.0-10
```

Il primo esempio esegue una scansione su tutta la la sottorete (abbiamo inserito la maschera), il secondo invece esegue una scansione dei primi 11 IP (da 0 a 10).

I parametri sono:
- **-sn** specifica di verificare se i dispositivi presenti nella rete rispondono e dunque sono "up";
- **-sL** fa una lista dei dispositivi presenti nella rete senza verificare se sono online.

> [!Info] Scanning in rete Locale vs Remota
> Eseguire uno **scanning in una rete locale**, ovvero nella sottorete in cui siamo connessi tramite ethernet o wifi, permette di ottenere anche gli indirizzi MAC dei dispositivi, infatti nmap verifica se sono online tramite delle ARP request.
> 
> Eseguire uno **scanning su una rete remota** invece non permette di ottenere il MAC address, infatti è il router ad inserire il MAC address della macchina che corrisponde all'indirizzo IP di destinazione sostituendo il data link layer del modello OSI (layer 2). Per controllare se le macchine sono attive vengono inviate richieste ICMP e TCP.

---

### Scoprire servizi attivi su un host

Per scoprire quali porte sono aperte su un host, nmap usa una tecnica chiamata:

**Connect Scan**
consiste nell'inviare pacchetti SYN su ogni porta TCP per cercare di stabilire una connessione mediante il three-way handshake. Se la connessione avviene con successo vuol dire che la porta è aperta ed nmap chiude forzatamente la connessione mediante un pacchetto con flag **[RST, ACK]**. Se invece l'host risponde al tentativo di connessione su una porta con un pacchetto **[RST, ACK]** vuol dire che la porta è chiusa.
Un esempio è mostrato nella seguente cattura si wireshark:
[[nmap_connect-scan.png]]

Uso di questa scansione:

```bash
nmap -sT 192.168.66.5
```

**SYN Scan (Stealth)**
questo tipo di scan è considerato meno rumoroso e consiste nel cercare di creare una connessione TCP come nel caso precedente ma nel momento in cui si riceve il pacchetto col flag [SYN, ACK] nmap tronca la connessione con un paccheto [RST, ACK] senza concluderla.
In questo modo il bersaglio non salverà in nessun file di log il tentativo di connessione (a differenza del caso precedente in quanto è avvenuta) ma per poter essere eseguito richiede i privilegi di amministratore.
Alcuni firewall aggiornati potrebbero comunque essere in grado di riconoscere questo tentativo di scansione e allertarsi.
Un esempio è mostrato nella seguente cattura si wireshark:
[[nmap_SYN-scan.png]]

Uso di questa scansione:

```bash
nmap -sS 192.168.66.0/24
```


**Scan UDP port**
per scannerizzare le porte UDP basta eseguire il seguente comando:

```bash
nmap -sU 192.168.66.0/24
```

In caso di servizio non disponibile (porta chiusa) nmap riceverà un pacchetto ICMP "Destination Unreachable" dall'obbiettivo, come mostrato nella seguente cattura:
[[nmap_UDP-scan.png]]

Per eseguire uno scanning su porte specifiche si può usare il parametro -p:

```bash
nmap -sS -p1-1024 192.168.66.0/24
```

```bash
nmap -sS -p- 192.168.66.0/24
```

Nel primo esempio eseguiamo una scansione sulle porte più conosciute **"well known ports"** (ovvero quelle maggiormente usate dai principali servizi UDP e TCP), ovvero da 1 a 1024.
Nel secondo esempio eseguiamo una scansione su tutte le porte esistenti (genera tantissimo rumore).

---
### OS Detection

Aggiungendo il parametro **-O** si nmap cerca di indovinare tramite alcuni indicatori la versione del sistema operativo della macchina bersaglio.

---
### Service Version Detection

Per tentare di individuare la versione dei servizi attivi, si può usare il parametro -**Sv**
Con il parametro **-A** viene abilitata la OS e Service Version detection, insieme anche alla traceroute.

---
### Forzare lo scan

Per eseguire lo scan delle porte anche su host che nmap ha segnato come non attivi (ma di cui abbiamo il sospetto che lo siano), si può usare il parametro **-Pn**

---
### Impostare la velocità dello scan

Eseguire nmap alla sua velocità normale potrebbe far scattare qualche **IDS (Instrusion Detection System)**, per questo mediante il parametro -T possiamo specificare una velocità da 0 a 4 (dalla più lenta alla più veloce).

Ovviamente rallentare la scansione permette di essere meno rumorosi e aggressivi.
Di seguito riportata una tabella indicativa dei tempi per uno scan TCP:
[[nmap-speed.png]]

Esempio di utilizzo:

```bash
nmap -sS -T2 192.168.66.0/24
```

---
### Salvare la scansione

Per salvare la scansione si possono usare diversi formati, l'output normale si ottiene mediante il parametro **-oN filename**.


#Security #Enumeration #Networking 