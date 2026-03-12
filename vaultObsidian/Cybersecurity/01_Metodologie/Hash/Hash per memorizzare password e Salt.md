Gli hash vengono usati per diversi motivi, validazione, controllo integrità e anche per salvare password piuttosto che memorizzarle in cleartext. Ormai vengono usati gli hash per salvare password solo dai sistemi operativi per le password degli utenti, per il resto gli hash non fanno riferimento alla password bensì alla KDF o altri sistemi.

Oltre a salvare le passowrd tramite il loro codice hash, per evitare che un attacante possa risalire alla password originale mediante una **Rainbow Table**, ovvero una tabella precompilata con milioni di hash, spesso il server aggiunge alla password inserita un valore casuale detto **Salt** (sale) e lo memorizza in chiaro accanto all'hash della password . In questo modo l'uso delle Rainbow Table diventa inutile e l'unico modo per riottenere la password è craccare l'hash (che spesso diventa impossibile se si usa una password sufficientemente lunga).

Quando l'hash viene memorizzato, spesso vengono salvate anche altre informazioni come ad esempio la tipologia di hash usato, i parametri passati ed il salt.

**NTLM** è l'hash usato da MS Windows per memorizzare le password all'interno del file SAM. Questo hash è debole in quanto non utilizza neanche i salt e duque soggetto ad attacchi mediante Rainbow Table. A differenza dei sistemi UNIX che usano algoritmi più complessy che oltre ad aggiungere il salt e numerosi cicli di hash, vengono usati algoritmi che sono **appositamente lenti da calcolare**, saturano la RAM e/o non permettono di ottenere vantaggio computazionale usando GPU.

Nel seguente link sono presenti dei tipi di hash che possono essere usati con hashcat:
https://hashcat.net/wiki/doku.php?id=example_hashes




#Hash #Security #Windows #Linux 