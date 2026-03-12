Tutti i protocolli studiati possono essere messi in sicurezza, garantendo **confidenzialità, integrità e autenticità**, mediante l'aggiunta del protocollo TLS.

I protocolli con l'aggiunta di questo layer vengono indicati con una s finale, es. POP3S, IMAPS, HTTPS, ...

Il protocollo TLS lavora al **layer 4 del modello OSI**.

TLS permette di riconoscere l'autenticità dei server mediante dei certificati, firmati da agenzie di terza parte che garantiscono l'autenticità del server.


> [!Attention] **Self-Signed Certificates**
> Non bisogna mai fidarsi dei Self-Signed Certificates per autenticare un server in quanto, come dice il nome, non sono stati verificati da un'agenzia di terze parti.

> [!TIP] **SFTP e FTPS**
> Quando vogliamo scaricare dei dati da un server in maniera sicura spesso è più comodo usare la suite di comandi del protocollo SSH per scaricare file piuttosto che configurare il protocollo FTPS che richiede dei certificati di autenticità.


#Networking #Protocols #Privacy #Security #Websites #DNS #Mail #SSH #Download 
