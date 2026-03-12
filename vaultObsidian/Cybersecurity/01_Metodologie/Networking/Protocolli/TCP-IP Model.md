È un'implementazione del modello concettuale [[OSI (Open Systems Interconnection) Model]]
sta per **Transmission Control Protocol/Internet Protocol**.
Una delle caratteristiche di questo protocollo è che la rete può continuare a funzionare anche se alcune sue parti sono fuori servizio.

I Layer di questo protocollo sono:

- **Link Layer**, corrisponde al Layer 2 dell'OSI;
- **Internet Layer**, corrisponde al Layer 3;
- **Transport Layer**, corrisponde al Layer 4;
- **Application Layer**, corrisponde al Layer 5, 6 e 7 uniti tutti insieme.

La seguente immagine mostra la categoria di indirizzi IP riservati alle reti private, **qualsiasi indirizzo IP al di fuori di questo range è pubblico!**
[[Range-IP.png]] 
(guardare i blocchi centrali per far riferimento agli intervalli)

### Maschere e range di indirizzi IP

Usare maschere come /24 e /27 fanno riferimento al numero di bit (8 per ogni blocco) che devono restare invariati. Ad esempio con **192.12.23.32/27** stiamo dicendo che i primi 27 bit devono restare invariati, dunque solo gli ultimi 5 bit possono variare (totale 32 bit = 4 byte). A questo punto viene calcolato il range degli 2^5 = 32 indirizzi IP successivi a quello indicato, dunque fino a **192.12.23.63**.

#Networking #Protocols 