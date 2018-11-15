# CORSO DI INGEGNERIA DEL SOFTWARE A.A. 2016/17

## PROVA IN ITINERE III

* TEAMMATE 1: Cognome, Nome, matricola, bitbucket-username
* TEAMMATE 2: Cognome, Nome, matricola, bitbucket-username

Ogni **gruppo** di studenti procede ad effettuare il **fork** di questo repository.
L'utente che ha effettuato il fork modifica questo README inserendo le opportune **informazioni sui membri del team** seguendo lo schema sopra riportato.
Inoltre, concede i permessi di scrittura al propri compagni di team e i **permessi di lettura** a **entrambi** i docenti (`carlobellettini`, `matteocamilli`).


## Processo

Una volta effettuato il **clone** del repository, il gruppo esegue il comando `git flow init` all'interno della directory clonata.
Dopodiché, il gruppo implementa secondo la *metodologia TDD* 
le specifiche riportate di seguito; in maggior dettaglio, ripete i passi seguenti fino ad aver implementato tutte le funzionalità richieste:

* crea un nuovo *branch* per la funzionalità corrente attraverso l'esecuzione del comando `git flow feature start`,
* implementa un test per le funzionalità richieste **procedendo nell'ordine** in cui sono specificate,
* verifica che **il codice compili correttamente**, ma l'**esecuzione del test fallisca**; solo a questo punto effettua un *commit* (usando `git add` e `git commit`) iniziando il messaggio di commit con la stringa `ROSSO:`,
* aggiunge la minima implementazione necessaria a realizzare la funzionalità, in modo che **il test esegua con successo**; solo a questo punto
  effettua un *commit* (usando `git add` e `git commit`) iniziando il messaggio di commit con la stringa `VERDE:`,
* procede, se necessario, al **refactoring** del codice, accertandosi che le modifiche non comportino il fallimento di alcun test; solo in questo caso fa seguire ad ogni
  passo un *commit* (usando `git add` e `git commit`) iniziando il messaggio di commit con la stringa `REFACTORING:`,
* esegue il *merge* del *branch* per la funzionalità sviluppata all'interno del *branch develop* attraverso il comando `git flow feature finish`,
* **solo in fase di rilascio**, esegue una *release* all'interno del *branch master* attraverso il comando `git flow release start` e successivamente `git flow release finish`,
* effettua un *push* (di tutti i *branch*) su Bitbucket con `git push origin --all --follow-tags`.

Al termine del laboratorio effettua una **ultima release**, un ultimo *push*, e **verifica su Bitbucket** che ci sia la completa traccia di *commit* effettuati.
Si suggerisce di eseguire i test non soltanto con Eclipse, ma anche eseguendo `./gradlew test` da riga di comando.


### Specifica dei requisiti

Obiettivo dell'esercizio è progettare e realizzare (secondo la **metodologia TDD** e facendo uso di opportuni **design pattern**) una gerarchia di classi
atte a produrre un semplice programma Java che si occupa di supportare *clienti* (Customer) e *impiegati* (OfficeWorker)
di un negozio nella gestione della *coda* (unica) alla cassa.
In particolare i clienti vengono serviti in modo FIFO in base al numero di *biglietto* (Ticket) assegnato.
Ogni cliente, quando arriva alla cassa chiede al sistema (attraverso una particolare vista) un nuovo biglietto.
I cassieri, prima di servire, chiedono al sistema (attraverso una particolare vista) il prossimo numero in coda.
Un'ulteriore vista mostra sempre il numero di biglietto correntemente servito.

Il sistema deve poter funzionare con *N* (grande a piacere) viste per clienti ed *M* (grande  piacere) viste per cassieri.
Tutte le viste devono essere coordinate sul numero di biglietto da *servire* e da *erogare*.

Per semplicità, assumiamo che le operazioni degli utenti vengano eseguite in modo *atomico*, 
non è richiesto quindi di occuparsi di problemi di *sincronizzazione*.

### Requisiti informali

Il progetto deve tener conto dei seguenti requisiti:

*  Le viste associate a *clienti* e *impiegati* possono essere realizzate tramite una unica classe. Attraverso un [JButton](https://docs.oracle.com/javase/8/docs/api/javax/swing/JButton.html) e un [JLabel](https://docs.oracle.com/javase/8/docs/api/javax/swing/JLabel.html) ci permettono di richiedere e di leggere il prossimo numero di *biglietto*. La classe astratta da cui partire per definire la classe per le due viste è già presente in [TicketManagerUI](src/main/java/it/unimi/di/sweng/lab12/view/TicketManagerUI.java).
Un'ulteriore vista, che contiene solamente  un [JLabel](https://docs.oracle.com/javase/8/docs/api/javax/swing/JLabel.html) consente di leggere il numero correntemente servito. Tutte le viste devono essere in grado di *osservare* un cambiamento nei biglietti (erogati/serviti) gestiti dal sistema.

* La componente [Model](src/main/java/it/unimi/di/sweng/lab12/model/Model.java) si occupa di mantenere i dati riguardo ai Ticket da erogare/servire. E' unica e comune a tutte le viste. Il `Model` a fronte di un cambiamento di stato, deve occuparsi di *notificare* tutte le viste.

* Il [Controller](src/main/java/it/unimi/di/sweng/lab12/controller/AbstractController.java) reagisce all’input dell’utente (pressione di un bottone) e richiama le operazioni opportune (definite dalla View tramite una strategy) sul `Model`.


* Lo svolgimento dell'esercizio richiede l'uso del *compound pattern* [Model-View-Controller (MVC)](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller).



## Indicazioni aggiuntive sul processo 

Di seguito sono riportate alcune indicazioni per quanto riguarda i rilasci del software.
Sono previsti in particolare 3 rilasci che comprendono lo sviluppo delle componenti indicate.

**RELEASE 1** `v1.0`

* componente `View` per *cliente* e *impiegato*;
* componente `Model` e strategie `RoleStrategy`;


**RELEASE 2** `v2.0`

* componente `Controller`;
* componente `View` in sola lettura;

**RELEASE 3** `v3.0`

* test di integrazione.

	


## Verifica e Convalida

### Integration Test

Il test di integrazione simuerà la pressione del bottone in una *view* e farà asserzioni sulle modifiche conseguenti nelle altre *view*.
Le *view* verranno quindi testate utilizzando opportunamente la libreria [AssertJ-Swing](http://joel-costigliola.github.io/assertj/assertj-swing.html) per verificare le modifiche dal punto di vista esterno (a livello di *GUI*).

### Code coverage

Prima di effettuare la release finale, il gruppo utilizza il framework *JaCoCo* per ricavare le informazioni sulla copertura.
Nello specifico, occorre garantire un'elevata percentuale di **copertura** del codice per stimolare l'esecuzione di tutte le porzioni potenzialmente difettose.
E' richiesta la copertura di almeno il 95% delle **istruzioni** sia delle **decisioni** nelle varie classi sviluppate.
Durante la scrittura dei test, occorre prestare particolare attenzione ai campi di variabilità dei dati in input per individuazione le opportune **classi di equivalenza**.

Ottenere il report sulla copertura invocando il comando
```
gradle clean check jacocoTestReport
```
dopodiché, il report può essere visualizzato aprendo il file `build/reports/jacoco/test/html/index.html`.