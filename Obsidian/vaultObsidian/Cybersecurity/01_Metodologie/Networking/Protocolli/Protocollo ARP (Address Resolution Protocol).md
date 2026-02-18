Quando i dispositivi vogliono comunicare tra loro nella rete usano gli indirizzi IP, i pacchetti però vengono mandati inserendo l'indirizzo MAC del destinatario, questo perché i dispositivi come gli switch lavorano memorizzando gli indirizzi MAC e non IP in quanto richiederebbe molta più capacità computazionale lavorare con questi ultimi.
Per questo motivo prima di inviare dati, il dispositivo deve necessariamente richiedere l'indirizzo MAC del destinatario, questo lo fa tramite l'ARP protocol, ovvero:

- **ARP Request**: il dispositivo invia un messaggio nella rete chiedendo l'indirizzo MAC dell'IP del destinatario
- **ARP Reply**: il dispositivo che ha l'indirizzo IP corrispondente risponde inviando il suo indirizzo MAC

In seguito il dispositivo che invia il messaggio aggiorna la sua tabella ARP. Solitamente la cache della tabella ARP viene liberata quando il dispositivo non comunica più con il destinatario per un arco di tempo compreso tra 2-20 minuti.

#Networking #Protocols 