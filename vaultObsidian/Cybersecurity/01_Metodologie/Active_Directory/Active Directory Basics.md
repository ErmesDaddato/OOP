**Active Directory è un sistema di gestione** creato da Microsoft per facilitare la gestione dei dispositivi all'interno di un ambiente aziendale.

In questo modo l'azienda crea un **Windows Domain**, all'interno del quale ogni utente può loggarsi su diversi dispositivi solo usando le sue credenziali e senza dover ogni volta aggiungere il proprio account nel caso fosse il primo log-in.
Dunque il Windows Domain è l'insieme dei dispositivi gestiti dal software **Active Directory**, il quale gira su un server centralizzato chiamato **Domain Controller**.

In questo modo la gestione degli utenti e delle policy di sicurezza può essere tranquillamente gestita mediante l'Active Directory senza dover modificare ogni singolo dispositivo manualmente.

---
## **L'Active Directory Domain Service**

È la componente dell'AD che si occupa della gestione delle informazioni di tutti gli **oggetti** presenti all'interno del Windows Domain, come utenti, stampanti, macchine e altri.
**AD DS è il cuore dell'AD.**

Esistono diversi tipi di oggetti, i più importanti sono:
- **Users**, gli utenti sono degli oggetti facenti parte dei **security principals**, in quanto possono essere autenticati dal dominio e gli possono essere assegnate risorse come stampanti e privilegi.
  Gli utenti si dividono in:
	  - **Persone**, che ovviamente rappresentano persone come impiegati e hanno determinati privilegi e risorse;
	  - **Servizi**, sono utenti creati appositamente per far girare in maniera automatica dei servizi, questi utenti sono spesso limitati al solo essenziale per far girare il servizio a loro associato;

- **Macchine**, **ogni computer facente parte del dominio ha un account ad esso associato** che usa per comunicare con il DC, in questo modo l'AD sa di star comunicando con un dispositivo sicuro e autenticato, inoltre servono per eseguire operazioni per cui servirebbe una autenticazione da amministratore nel computer, come aggiornamenti da remoto, installazione di software,... 
  Questi account sono molto simili a degli account utenti e **corrispondo ad amministratori locali del computer associato**.  
	  - **Username**: spesso corrisponde al nome del dispositivo nella rete con un dollaro aggiunto alla fine;
	  - **Password**: viene automaticamente aggiornata dall'AD ogni 30 giorni ed è composta da 120 caratteri casuali;
	  

---
## **Security Groups vs OUs**

Quando viene creata una AD, gli utenti e le macchine, dunque tutti gli oggetti facenti parte dei security principals, vengono divisi in diversi container chiamati **Organizational Units** (OUs), che possono sembrare simili ai security groups ma presentano delle differenze:
le OUs spesso **rispettano l'ordine e la gestione del personale all'interno dell'azienda** (come la divisione in reparti), e **non si può far parte di più OUs contemporaneamente**. 

Dunque i Security groups gestiscono i permessi degli utenti, ad esempio sull'accesso a Directories e file, ed ogni utente può far parte di molteplici gruppi.

Le OUs invece definiscono regole specifiche in base al ruolo dell'utente, ad esempio tutti quelli facenti parte del reparto finanza non possono usare chiavette usb.

> [!INFO] **GPOs (Group Policy Objects)**
> Le GPOs sono le policy di sicurezza applicate alle OUs, si creano nel **Group Policy Managment** e vengono successivamente linkate a specifici OUs. 
> Quando avviene una modifica o viene creata una nuova Group Policy, questa viene distribuita sulla rete mediante **SYSVOL** e a meno che non forzato, l'aggiornamento totale della rete per la nuova Policy può impiegare fino a 2 ore per raggiungere tutti i dispositivi.

---
## **Delegazione**

La delegazione fa riferimento alla delegazione di permessi amministrativi che vengono ceduti ad un utente, ristretti però ad una specifica cerchia di dispositivi.

---

## **Authentications Method**

In un Windows Domain, **tutte le credenziali sono memorizzate nel Domain Controller**, nel momento in cui un utente cerca di autenticarsi ad un servizio del Dominio, questo invia le credenziali al DC per verificarne la correttezza.
Per eseguire questo controllo possono essere usati due protocolli: 
### Kerberos
È il protocollo ufficiale per l'autenticazione all'interno di un Windows Domain.
Il processo di autenticazione in un dominio mediante Kerberos è diviso in 3 fasi.
Immaginiamo che un utente stia cercando di accedere ad un servizio ospitato su un server del dominio, per cui viene richiesta l'autenticazione, i passaggi sono i seguenti:

1) [[Kerberos_1.png]]
2) [[Kerberos_2.png]]
3) [[Kerberos_3.png]]

Tramite l'uso di Kerberos, la password non viene mai trasmessa per la rete, ed una volta effettuata l'autenticazione al KDC ed ottenuto il **TGT (Ticket Granting Ticket)** e la **Session Key**, basta richiedere i **Ticket Granting Serices** per accedere ai servizi, senza eseguire nuovamente l'autenticazione. 

> [!Attention] **TGT e TGS**
> Il TGT ed il TGS contendono al loro interno rispettivamente la **Session Key** e la **Service Session Key**, in modo tale che il KDC ed il server che ospita il servizio siano in grado, mediante la decifrazione dei ticket, di recuperare la chiave corrispondente, evitando di trasmetterla nella rete.

### NetNTLM
Ormai obsoleto, potrebbe essere attivo insieme a Kerberos solo per questione di compatibilità con sistemi più vecchi.
[[netNTLM.png]]



#Active_Directory #Security 