Un dispositivo può avere un indirizzo IP privato (unico sulla rete) ed uno pubblico.

> [!INFO]
> A differenza di quello privato, l'IP pubblico non è unico, perciò per distinguere i dispositivi con lo stesso indirizzo pubblico, i server web riconoscono il dispositivo mediante la sua **impronta digitale**.

Per esempio tutti i dispositivi connessi allo stesso router hanno lo stesso indirizzo IP pubblico, il router per distinguere i dispositivi tra loro e smistare il traffico in ingresso, associa ad ogni dispositivo una porta diversa ed inoltre salva l'associazione porta/dispositivo all'interno di una tabella **NAT**.

[[NAT.png]]


#Networking #Protocols