Le chiavi private assimetriche come sappiamo vengono salvate e cifrate mediante una chiave simmetrica AES che viene a sua volta cifrata da una **MasterKey**.
La MasterKey viene decifrata da una passphrase, di cui viene salvato l'hash.
La MasterKey viene usata nei sistemi di grandi dimensioni per la sua comodità in quanto permette di cambiare Passphrase semplicemente decifrando la MasterKey e ricifrandola con la nuova Passphrase, senza deicfrare e ricifrare magari 500gb di dati protetti.

Nel caso di chiavi private che non vengono usate per cifrare grandi quantità di dati, come nel caso delle chiavi private per **l'autenticazione mediante protocollo SSH,** queste vengono salvate semplicemente mediante una cifratura simmetrica con una chiave AES che viene generata tramite una tecnica detta **KDF (Key Derivation Function)** ovvero derivazione della chiave partendo da una passphrase scelta.


> [!Attention] Perchè gli Hash vengono salvati?
> L'operazione di salvare gli hash per verificare la correttezza della password viene eseguita nonostante comporti problemi di sicurezza (in quanto si potrebbe risalire alla passphrase craccando l'hash) perchè provare a decifrare un contenuto cifrato con una chiave sbagliata porterebbe quasi certamente alla corruzione dei dati.


#Hash #Security 