Esistono 2 principali tipi di cifratura:

- **Symmetric Encryption**, viene usata la stessa chiave di cifratura per cifrare e decifrare i "plain text", questo tipo di cifratura è più veloce in quanto richiede chiavi più piccole ma richiede che la chiave di cifratura sia tenuta ben nascosta e dunque non è consigliabile per comunicare con molti host. Alcuni algoritmi sono:
	- DES (Data Encryption standard), ormai deprecato;
	- 3DES (3 volte il DES), chiavi più grandi ma anch'esso obsoleto;
	- **AES (Advanced Encryption Standard)**, lo standard moderno e molto sicuro.

- **Asymmetric Encryption**, vengono usate due chiavi diverse ovvero una public key, usata per la fase di cifratura del "plain text" e che può essere accessibile a chiunque, ed una private key che deve rimanere segreta e viene usata solo per la decifratura. Questa tecnica è più lenta in quanto richiede chiavi di grandi dimensioni ma è estremamente efficace per inviare documenti e messaggi cifrati tra molti utenti. Alcuni algoritmi di cifratura assimetrica sono:
	- ECC
	- **RSA** che usa chiavi a 2048, 3072 e 4096 bit.


Le conndizioni che la cifratua deve garantire sono le seguenti:
- **Authentication**, ovvero essere certi dell'host con cui si sta comunicando;
- **Authenticity**, ovvero essere certi che i dati ricevuti provengano dall'host dichiarato;
- **Integrity**, ovvero non permettere la modifica dei dati inviati e ricevuti durante il viaggio;
- **Confidentiality**, non permettere la lettura non autorizzata dei dati durante il viaggio (in seguito ad una intercettazione).

**Per garantire queste condizioni non basta usare la sola cifratura simmetrica o assimetrica, bisogna usare delle cifrature ibride che consistono nel combinare questi tipi di cifratura in diversi modi e più volte.**

Ad esempio, essendo la cifratura simmetrica più veloce dell'assimetrica, spesso si passa una chiave di cifratura simmetrica mediante un messaggio inviato tramite cifratura assimmetrica, con l'aggiunta di firme e codici per l'integrità del documento.

**Firma digitale**
Una firma digitale corrisponde semplicemente ad un codice che viene cifrato mediante una chiave privata dal mittente del messaggio e decifrato con la sua chiave pubblica da ricevente, in questo modo il ricevente è certo che il messaggio sia stato mandato da chi pensa visto che la firma è stata creata usando la sua chiave privata.
Il codice contenuto nella firma digitale è l'hash stesso del messaggio, dunque con questo sistema si permette di garantire autenticità, integrità e confidenzialità.

**Come funziona la cifratura assimetrica moderna mediante MasterKey**
La cifratura assimetrica prevede una chiave privata e pubblica, a cui vengono associate delle fingerprint (i loro hash). Per rendere il tutto più sicuro, la chiave privata (per la decifratura) che deve restare nascosta viene a sua volta protetta da una **MasterKey**, ovvero una chiave AES che viene generata casualmente dal sistema operativo e che esegue una cifratura simmetrica della chiave privata. Ovviamente bisogna proteggere anche la MasterKey e dunque viene inserita una **passphrase** scelta dall'utente che viene usata per cifrare a sua volta la MasterKey.
Questo oltre ad implementare la sicurezza permette anche di cambiare la PassPhrase in quanto un suo cambio non comporta un cambio della chiave privata.

#Security #Privacy #Cryptography 