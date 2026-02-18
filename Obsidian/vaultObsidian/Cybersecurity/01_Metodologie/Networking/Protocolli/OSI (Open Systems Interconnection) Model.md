**IL modello OSI corrisponde al linguaggio tramite cui comunicano i dispositivi sulla rete**.
Le informazioni inviate tramite questo modello vengono incapsulate in 7 livelli, ognuno con un diverso ruolo e responsabilità (l'incapsulamento avviene dal livello 7 a scendere). 

Di seguito lo schema riassuntivo:
[[OSI_Model.png]]

- **Layer 1 - Physical**, contiene le informazioni sulle componenti fisiche usate nella rete come i cavi, a quanti Volt deve trasmettere le informazioni, se deve mandarle tramite cavo, Wi-Fi, fibra e così via.
---
- **Layer 2 - Data Link**, aggiunge l'indirizzo MAC del destinatario. I dispositivi come gli AP e gli Switch si dice che operano al livello 2 in quanto usano queste informazioni per inviare i dati.
  Durante questa fase i dati sono divisi in **frame**.
  I due protocolli per incapsulare questi dati sono **IEEE 802.3** (Ethernet) e **IEEE 802.11** (WiFi)
---
- **Layer 3 - Network**, contiene le informazioni ottimali per il percorso che i dati dovranno seguire, ottenute mediante protocolli come **OSPF** (Open Shortest Path First) e **RIP** (Routing Information Protocol). A questo livello tutto viene gestito mediante indirizzo IP. Dispositivi come i router si dice che operano al livello 3, in quanto usano queste informazioni per inviare i dati all'interno della stessa rete.
  Durante questa fase i dati sono divisi in **pacchetti**.
---
-  **Layer 4 - Transport**, decide il protocollo con cui inviare i dati: **TCP** (Transmission Control Protocol) o **UDP** (User Datagram Protocol), il primo richiede una connessione costante tra i 2 dispositivi e si assicura che tutti i pacchetti in cui sono stati divisi i dati siano arrivati e siano stati ricostruiti in ordine (lento e non adatto a reti lente), il secondo invece non esegue tutti questi controlli a discapito di una maggiore velocità di trasmissione.
---
- **Layer 5 - Session**, questo livello si occupa di aprire (e chiudere) una sessione con il destinatario, in modo da rimanere connessi durante l'invio dei dati, inoltre contiene anche dei Checkpoint in modo tale che in caso di perdita di connessione, una volta ristabilita verranno inviati solo i dati dal Checkpoint raggiunto in poi.
---
- **Layer 6 - Presentation**, si occupa di tradurre i dati in un formato standardizzato, comprensibile in maniera univoca.
---
- **Layer 7 - Application**, è l'insieme di regole e protocolli che determinano come l'utente può interagire con i dati.



> [!TIP] Trasporto dei Frame
> Se il dispositivo che invia i dati deve **comunicare all'interno della sua stessa rete/sottorete** con un altro dispositivo inserisce al secondo livello l'indirizzo MAC del destinatario e questo verrà elaborato da uno switch (in caso anche lo switch contenuto nel router).
> 
>  Se invece vuole **comunicare con un altro dispositivo in un'altra sottorete o al di fuori (internet)**, il mittente inserisce nel secondo livello l'indirizzo MAC del *Default Gateway* (solitamente il router) e nel terzo livello inserisce l'indirizzo IP del server/dispositivo che deve ricevere i dati. 
>  In questo caso il Gateway rimuove (strips) il secondo livello, analizza il terzo livello e se l'indirizzo **IP corrisponde ad un dispositivo in un'altra sottorete** inserisce nel secondo livello l'indirizzo MAC del dispositivo
>  Se il **destinatario è invece su internet** allora il router inserisce l'indirizzo MAC del server dell'ISP che a sua volta ripeterà l'operazione (facendo saltare i frame) fino a quando non si raggiunge il destinatario.


> [!WARNING] Cosa vede l'ISP
> Dato che i frame che vanno su internet passano sempre dall'ISP questi possono essere **"Sniffati"**, e analizzati dall'internet provider, in particolar modo le richieste al DNS. Anche se uso un DNS pubblico diverso da quello dell'ISP questo riesce comunque a vedere i miei frame.
> 
> L'operazione da eseguire per evitate lo Sniffing dei frame è eseguire una cifratura dei frame, **DoH** o **DoT** (DNS over HTTPS o DNS over TLS).
> In questo modo l'ISP riuscirà solo a vedere che sto eseguendo una richiesta verso il server DNS ma non cosa sto chiedendo
> 
> Il resto delle comunicazioni, ad esempio verso i siti web, sono cifrate mediante protocolli come HTTPS


> [!TIP] Funzionamento del protocollo TCP
> Il protocollo TCP funziona mediante un **Three-Way Handshake**, come illustrato negli schemi riassuntivi:
> 	[[Apertura_TCP.png]]
> 	[[Chiusura_TCP.png]]



#Networking #Protocols #Security #Privacy
