È uno strumento di cattura dei pacchetti di rete (non solo TCP) da linea di comando (CLI), dunque a differenza di wireshark può essere usato su dispositivi che non possiedono una interfaccia grafica.

**La grande capacità di tcpdump sta nella potenza e nella facilità di applicare filtri alla cattura.** 

Comando base:
```bash
tcpdump -i eth0 -C 500 -v -w file.pcap
```

nello specifico: 
- **-i** specifica l'interfaccia di rete da usare;
- **-C** specifica un conteggio di quanti pacchetti catturare
- **-v** specifica di essere "verbose", dunque vengono aggiunte più informazioni come i TTL;
- **-w** specifica il file di output, in questo modo a schermo non verrà stampato niente.

altre opzioni sono:

- **-n** non fa risolvere gli hostname, in questo modo vengono visualizzati gli indirizzi ip dei webserver;
- **-nn** non vengono risolte neanche le porte dei servizi;
- **-r** per leggere da un file .pcap;
- **-e** mostra gli indirizzi MAC;
- **--number** numera i pacchetti;

I **filtri** possono essere applicati nel modo seguente:

```bash
tcpdump -i eth0 -w file.pcap hostname example.com and port 443
```

```bash
tcpdump -i eth0 -w file.pcap port 53
```

```bash
tcpdump -i eth0 -w file.pcap src host 10.23.1.5
```

Il primo esempio filtra i pacchetti provenienti e diretti verso uno specifico IP o hostname e con l'aggiunta dell'**end** specifichiamo anche la porta (l'operatore end permette di aggiungere condizioni), il secondo cattura solo i pacchetti in entrata e uscita dalla porta 53, il terzo cattura solo i pacchetti provenienti da uno specifico indirizzo IP o hostaname.

Insieme ai filtri possono essere applicati operatori logici come **&, |, !** (and, or, not).

Possono anche essere usati filtri avanzati per **filtrare i pacchetti in base al loro header**, ad esempio:

```bash
tcpdump -i eth0 -w file.pcap "tcp[tcpflags] == tcp-syn"
```

```bash
tcpdump -i eth0 -w file.pcap "tcp[tcpflags] & tcp-syn != 0"
```

Il primo comando cattura solo i pacchetti il cui header tcp contiene la flag tcp-syn (dunque pacchetto SYN), il secondo esempio invece cattura tutti i pacchetti che hanno almeno il flag SYN impostato a 1, ovvero catturerà anche i pacchetti SYN-ACK

#Sniffing #Tools  