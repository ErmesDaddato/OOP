È un tool usato per **cercare directories e pagine web nascoste** (spesso usate per gli accessi da amministratore e di gestione) non rese private e dunque accessibili. 

Cosa richiede:
- dominio del sito web
- dizionario per la ricerca delle pagine

La sintassi del comando è la seguente:

```bash
gobuster -u http://fakebank.thm -w wordlist.txt
```

> [!Attention] Ricorsività
> Gobuster non è ricorsivo di default, questo vuol dire che non analizza tutte le possibili opzioni a "cascata", ovvero le sottodirectory.


#Tools #Enumeration 