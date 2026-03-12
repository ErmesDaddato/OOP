**La Crontab è una tabella contenente tutti i processi, inclusi comandi scritti in bash che vengono eseguiti al boot del sistema**, specificando parametri come giorno mese, ...

Per accedervi e modificarla è sufficiente eseguire il comando:

```bash
crontab -e 
```

> [!Tip] Esecuzione ad eventi
> È anche possibile far eseguire in seguito a particolari eventi, specificando col carattere @.
es. **@reboot *comando bash***


#Linux #Processi 