**É la nuova versione del comando ifconfig, inoltre permette di integrare una intera suite di tools in un'unico strumento.**
Infatti attraverso questo tool è possibile gestire le interfacce di rete, il percorso che i dati fanno una volta usciti dal computer (Routing),...

Per funzionare il comando segue questa sintassi:

```bash
ip [oggetto] [comando]
```

Con l'oggetto indichiamo su cosa vogliamo agire, interfaccia di rete, routing, indirizzi IP associati, ...
Il comando è invece specifico per l'oggetto, es.

```bash
ip addr show
```

mostra tutti gli indirizzi IP associati alle interfacce di rete.

Oppure

```bash
ip route show
```

mostra il routing dei dati.

Tramite il comando IP è anche possibile cambiare il default Gateway.

#Networking #Comandi #Linux 