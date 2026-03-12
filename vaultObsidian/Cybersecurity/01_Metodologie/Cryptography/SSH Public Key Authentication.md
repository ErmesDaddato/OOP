Una delle grandi capacità dell'algoritmo RSA è la sua **dualità**, ovvero avendo una coppia di chiavi (pubblica e privata), se una viene usata per cifrare allora solo l'altra può decifrare e viceversa. Questo concetto è alla base dell'autenticazione mediante chiave pubblica sul protocollo SSH.

I passaggi sono i seguenti (il concetto usato è lo stesso della firma digitale):
- **Si genera una coppia di chiavi**, una pubblica ed una privata, la privata può essere protetta da passphrase, come spiegato in [[Tipologie di Cifratura]];
- **Si condivide la chiave pubblica**,  mentre la chiave privata rimane segreta, la pubblica viene condivisa sui server a cui si vorrà accedere e per la precisione viene inserita all'interno di una **lista di chiavi pubbliche autorizzate** all'accesso;

- **Richiesta**, il client richiede l'accesso mediante SSH inviando lo username e la chiave pubblica al server;
- **Sfida (Challenge)**, il server verifica che l'utente e la chiave pubblica siano all'interno del file delle chiavi autorizzate e, in caso di conferma, risponde alla richiesta con una sfida ovvero un numero generato casualmente che viene successivamente cifrato con la chiave pubblica dell'utente;
- **Risposta e Firma**, il client decifra la challenge con la sua chiave privata (**grazie alla dualità dell'RSA**), ne calcola l'hash e lo firma ovvero lo cifra nuovamente con la sua chiave privata;
- **Verifica**, il server decifra il dato ricevuto e se l'hash ricevuto corrisponde al quello del numero inviato (challenge), allora la connessione viene stabilita in quanto è stata verifcata l'autenticità del client.

Se usata una passphrase per cifrare la chiave privata, questa viene cifrata mediante una chiave AES-256 bit che viene generata da una KDF che prende come input la passphrase ed un salt, iterando il processo più volte per rallentare il calcolo.


#Security #Cryptography #SSH #Networking 
