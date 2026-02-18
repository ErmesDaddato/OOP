Di seguito è rappresentata la gerarchia dei domini di rete:
[[Domain_Hierarchy.png]]

Esistono due tipi di TLD:
- **gTLD** (generic Top Level Domain), per indicare lo scopo del dominio, come .com (attività commerciali), .gov (per le istituzioni) e così via;
- **ccTLD** (country code Top Level Domain), per identificare la zona geografica del dominio, come .it, .ca, e così via

Quando due TLD vengono associati insieme, quello più a destra diventa il TLD e quello successivo il Secondary, ed il nome del dominio (che di solito sarebbe di secondo livello), diventa di **terzo livello**.


> [!Info] Subdomain
> Una ulteriore divisione, come admin.tryhackme.com, admin rappresenta un **sottodominio**.

> [!Tip] Tools
> Ci sono numerosi tool, come **dig** che permettono di ottenere la risposta ottenuta dal dns del dominio richiesto

 ---
## DNS 
 
Il percorso che le richieste DNS fanno è rappresentato dall'immagine seguente:
[[DNS.png]]

Esistono diversi tipi di **record DNS**: 
- **Record A**, risolvono gli indirizzi IPv4 dei domini;
- **Record AAAA**, risolvono gli indirizzi IPV6 dei domini;
- **CNAME Record (Canonical Name)**, risolvono i domini associati ad altri, ad esempio twitter.com è associato a x.com;
- **MX Record (Mail Exchange)**, risolve i domini per gli indirizzi di posta elettronica. 



#Networking #Network_Domain #Tools #Websites #DNS
